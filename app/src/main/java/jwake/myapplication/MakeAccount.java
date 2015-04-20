package jwake.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.EditText;


public class MakeAccount extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;


    private EditText parentName;
    private EditText parentAge;
    private EditText parentGender;
    private EditText childName;
    private EditText childAge;
    private EditText childGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_account);



        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.make_account, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
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

    public void onFinishButtonClick(View view)
    {
        parentName = (EditText) findViewById(R.id.ParentNameEdit);
        parentAge = (EditText) findViewById(R.id.ParentAgeEdit);
        parentGender = (EditText) findViewById(R.id.ParentGenderEdit);

        childName = (EditText) findViewById(R.id.ChildNameEdit);
        childAge = (EditText) findViewById(R.id.ChildAgeEdit);
        childGender = (EditText) findViewById(R.id.ChildGenderEdit);

        //save info for parent
        SharedPreferences P_Name = getSharedPreferences("parentName", Context.MODE_PRIVATE);
        SharedPreferences.Editor P_Name_Editor = P_Name.edit();
        P_Name_Editor.putString("parentName",parentName.getText().toString());
        P_Name_Editor.apply();

        //Might need to change to int
        SharedPreferences P_Age = getSharedPreferences("parentAge", Context.MODE_PRIVATE);
        SharedPreferences.Editor P_Age_Editor = P_Age.edit();
        P_Age_Editor.putString("parentAge",parentAge.getText().toString());
        P_Age_Editor.apply();

        SharedPreferences P_Gender = getSharedPreferences("parentGender", Context.MODE_PRIVATE);
        SharedPreferences.Editor P_Gender_Editor = P_Gender.edit();
        P_Gender_Editor.putString("parentGender",parentGender.getText().toString());
        P_Gender_Editor.apply();

        //save info for child
        SharedPreferences C_Name = getSharedPreferences("childName", Context.MODE_PRIVATE);
        SharedPreferences.Editor C_Name_Editor = C_Name.edit();
        C_Name_Editor.putString("childName",childName.getText().toString());
        C_Name_Editor.apply();

        SharedPreferences C_Age = getSharedPreferences("childAge", Context.MODE_PRIVATE);
        SharedPreferences.Editor C_Age_Editor = C_Age.edit();
        C_Age_Editor.putString("childAge",childAge.getText().toString());
        C_Age_Editor.apply();

        SharedPreferences C_Gender = getSharedPreferences("childGender", Context.MODE_PRIVATE);
        SharedPreferences.Editor C_Gender_Editor = C_Gender.edit();
        C_Gender_Editor.putString("childGender",childGender.getText().toString());
        C_Gender_Editor.apply();


        //isempty
        if(P_Name.getString("parentName","").equals("")) {
            parentName.setHintTextColor(Color.RED);
        }
        else if(P_Age.getString("parentAge","").equals("")) {
            parentAge.setHintTextColor(Color.RED);
        }
        else if(P_Gender.getString("parentGender","").equals("")) {
            //parentName.setHint("Name");
            parentGender.setHintTextColor(Color.RED);
        }

        else if(C_Name.getString("childName","").equals("")) {
            childName.setHintTextColor(Color.RED);
        }
        else if(C_Age.getString("childAge","").equals("")) {
            childAge.setHintTextColor(Color.RED);
        }
        else if(C_Gender.getString("childGender","").equals("")) {
            //parentName.setHint("Name");
            childGender.setHintTextColor(Color.RED);
        }

        else {
            SharedPreferences introFirstTime = getSharedPreferences("introInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor firstTimeEditor = introFirstTime.edit();

            firstTimeEditor.putBoolean("introInfo", true);

            firstTimeEditor.apply();
            Intent i = new Intent(this, HomeScreen.class);
            startActivity(i);
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_make_account, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MakeAccount) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }

    }

}
