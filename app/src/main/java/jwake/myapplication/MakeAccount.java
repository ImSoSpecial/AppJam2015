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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


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
    private RadioButton parentMale;
    private RadioButton parentFemale;

    private EditText childName;
    private EditText childAge;
    private RadioButton childMale;
    private RadioButton childFemale;

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
        parentMale = (RadioButton) findViewById(R.id.MaleGenderRadioButton);
        parentFemale = (RadioButton) findViewById(R.id.FemaleGenderRadioButton);

        childName = (EditText) findViewById(R.id.ChildNameEdit);
        childAge = (EditText) findViewById(R.id.ChildAgeEdit);
        childMale = (RadioButton) findViewById(R.id.CMaleGenderRadioButton);
        childFemale = (RadioButton) findViewById(R.id.CFemaleGenderRadioButton);

        boolean allFilled = true;
        //save info for parent

        if(!parentName.getText().toString().isEmpty()) {
            SharedPreferences P_Name = getSharedPreferences("parentName", Context.MODE_PRIVATE);
            SharedPreferences.Editor P_Name_Editor = P_Name.edit();
            P_Name_Editor.putString("parentName", parentName.getText().toString());
            P_Name_Editor.apply();
            parentName.setHintTextColor(Color.BLACK);
        }
        else {
            parentName.setHintTextColor(Color.RED);
            allFilled = false;
        }

        if(!parentAge.getText().toString().isEmpty()) {
            //Might need to change to int
            SharedPreferences P_Age = getSharedPreferences("parentAge", Context.MODE_PRIVATE);
            SharedPreferences.Editor P_Age_Editor = P_Age.edit();
            P_Age_Editor.putString("parentAge", parentAge.getText().toString());
            P_Age_Editor.apply();
            parentAge.setHintTextColor(Color.BLACK);
        }
        else {
            parentAge.setHintTextColor(Color.RED);
            allFilled = false;
        }

        if(parentMale.isChecked() || parentFemale.isChecked()) {
            if(parentMale.isChecked()) {
                SharedPreferences P_Gender = getSharedPreferences("parentMale", Context.MODE_PRIVATE);
                SharedPreferences.Editor P_Gender_Editor = P_Gender.edit();
                P_Gender_Editor.putString("parentMale", "Male");
                P_Gender_Editor.apply();
                parentMale.setTextColor(Color.BLACK);
            }
            else {
                SharedPreferences P_Gender = getSharedPreferences("parentFemale", Context.MODE_PRIVATE);
                SharedPreferences.Editor P_Gender_Editor = P_Gender.edit();
                P_Gender_Editor.putString("parentFemale", "Female");
                P_Gender_Editor.apply();
                parentFemale.setTextColor(Color.BLACK);
            }
        }
        else {
            parentMale.setTextColor(Color.RED);
            parentFemale.setTextColor(Color.RED);
            allFilled = false;
        }

        //save info for child
        if(!childName.getText().toString().isEmpty()) {
            SharedPreferences C_Name = getSharedPreferences("childName", Context.MODE_PRIVATE);
            SharedPreferences.Editor C_Name_Editor = C_Name.edit();
            C_Name_Editor.putString("childName", childName.getText().toString());
            C_Name_Editor.apply();
            childName.setHintTextColor(Color.BLACK);
        }
        else {
            childName.setHintTextColor(Color.RED);
            allFilled = false;
        }

        if(!childAge.getText().toString().isEmpty()) {
            SharedPreferences C_Age = getSharedPreferences("childAge", Context.MODE_PRIVATE);
            SharedPreferences.Editor C_Age_Editor = C_Age.edit();
            C_Age_Editor.putString("childAge", childAge.getText().toString());
            C_Age_Editor.apply();
            childAge.setHintTextColor(Color.BLACK);
        }
        else {
            childAge.setHintTextColor(Color.RED);
            allFilled = false;
        }

        if(childMale.isChecked() || childFemale.isChecked()) {
            if(childMale.isChecked()) {
                SharedPreferences C_Gender = getSharedPreferences("childMale", Context.MODE_PRIVATE);
                SharedPreferences.Editor C_Gender_Editor = C_Gender.edit();
                C_Gender_Editor.putString("childMale", "Male");
                C_Gender_Editor.apply();
                childMale.setTextColor(Color.BLACK);
            }
            else {
                SharedPreferences C_Gender = getSharedPreferences("childFemale", Context.MODE_PRIVATE);
                SharedPreferences.Editor C_Gender_Editor = C_Gender.edit();
                C_Gender_Editor.putString("childFemale", "Female");
                C_Gender_Editor.apply();
                childFemale.setTextColor(Color.BLACK);
            }
        }
        else {
            childMale.setTextColor(Color.RED);
            childFemale.setTextColor(Color.RED);
            allFilled = false;
        }


        if(allFilled) {
            SharedPreferences introFirstTime = getSharedPreferences("introInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor firstTimeEditor = introFirstTime.edit();

            firstTimeEditor.putBoolean("introInfo", true);

            firstTimeEditor.apply();
            Intent i = new Intent(this, HomeScreen.class);
            startActivity(i);
        }
        else {
            Toast.makeText(MakeAccount.this, "Fill out all fields", Toast.LENGTH_SHORT).show();
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
