package jwake.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class StruggleQuestionScreen extends ActionBarActivity {

    List<String> CatList = new ArrayList<String>(
            Arrays.asList("Maladaptive Behavior Index", "Communication Domain",
                    "Daily Living Skills", "Socialization",
                    "Motor Skills"));

    List<ArrayList<SurveyQuestions>> sortByCategory;
    ArrayList<SurveyQuestions> unSorted;
    DataBaseForStruggles db;
    ArrayList<SurveyQuestions> addCategory;
    String currentCat;
    int qid=0;
    int cid=0;  //category id

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(CatList.get(qid));
        setContentView(R.layout.activity_struggle_question_screen);

        db = new DataBaseForStruggles(this, null, null, 1);
        addCategory = new ArrayList<SurveyQuestions>();
        unSorted = new ArrayList<SurveyQuestions>();
        unSorted = db.getAllQuestionsArray();
        currentCat = CatList.get(0);
        sortByCategory = new ArrayList<ArrayList<SurveyQuestions>>();

        for(int i = 0; i < unSorted.size(); i++) {
            SurveyQuestions SQ = new SurveyQuestions(unSorted.get(i).getCategory(), unSorted.get(i).getSubCategory(), unSorted.get(i).getQuestion(), unSorted.get(i).getAnswer());

            if(unSorted.get(i).getCategory().equals(currentCat)) {
               addCategory.add(SQ);
            }
            else {
                sortByCategory.add(cid, addCategory);
                addCategory = new ArrayList<SurveyQuestions>();
                currentCat = unSorted.get(i).getCategory();
                addCategory.add(unSorted.get(i));   //This adds the new category first question
                cid++;
            }
        }
        sortByCategory.add(cid, addCategory);   //adds the last category

        ListAdapter listAdapter = new CustomAdapter(this, sortByCategory.get(0));
        ListView listViewContainer = (ListView) findViewById(R.id.StruggleList);
        listViewContainer.setAdapter(listAdapter);

    }

    @Override
    public void onBackPressed() {
        if(qid > 0) {
            qid--;
            setTitle(CatList.get(qid));
            ListAdapter listAdapter = new CustomAdapter(this, sortByCategory.get(qid));
            ListView listViewContainer = (ListView) findViewById(R.id.StruggleList);
            listViewContainer.setAdapter(listAdapter);
        }
        //else qid == 0 nothing happens
    }

    public void onNextStruggleClicked(View view) {
        qid++;
        if(qid < sortByCategory.size()) {
            setTitle(CatList.get(qid));
            ListAdapter listAdapter = new CustomAdapter(this, sortByCategory.get(qid));
            ListView listViewContainer = (ListView) findViewById(R.id.StruggleList);
            listViewContainer.setAdapter(listAdapter);
        }
        else {
            Intent intent = new Intent(this, HomeScreen.class);
            startActivity(intent);
        }
    }

    public void onSkipStruggleClicked(View view) {
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_struggle_question_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }


}
