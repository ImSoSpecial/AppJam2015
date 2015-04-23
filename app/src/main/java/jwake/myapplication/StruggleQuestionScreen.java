package jwake.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class StruggleQuestionScreen extends ActionBarActivity {

    ArrayList<SurveyQuestions> Sorted;
    DataBaseForStruggles db;
    List<SurveyQuestions> QuestionList;
    SurveyQuestions currentQ;
    List<SurveyQuestions> SortByCategory;
    int qid=0;
    int cid=0;  //category id

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_struggle_question_screen);
        db = new DataBaseForStruggles(this, null, null, 1);

        Sorted = new ArrayList<SurveyQuestions>();
        Sorted = db.getAllQuestionsArray();

        System.out.println("Sorted: "+Sorted.size());
        ListAdapter listAdapter = new CustomAdapter(this, Sorted);
        ListView listViewContainer = (ListView) findViewById(R.id.StruggleList);
        listViewContainer.setAdapter(listAdapter);

        //QuestionList = db.getAllQuestions();
        //currentQ = QuestionList.get(qid);

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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
