package jwake.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adrianvazquez on 4/19/15.
 */
public class DataBaseForStruggles extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "struggles.db";
    public static final String TABLE_STRUGGLEINFO = "struggleInfo";
    public static final String TABLE_TASKINFO = "taskInfo";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_CATEGORY = "category";
    public static final String COLUMN_SUBCATEGORY = "subCategory";
    public static final String COLUMN_SUBSUBCATEGORY = "subSubCategory";
    public static final String COLUMN_QUESTION = "question";
    public static final String COLUMN_WORTH = "worth";
    public static final String COLUMN_TASK = "task";
    public static final String COLUMN_IMAGE_PATH = "imagePath";


    private static final String CREATE_TABLE_STRUGGLEINFO = "CREATE TABLE " + TABLE_STRUGGLEINFO + "(" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_CATEGORY + " TEXT," +
            COLUMN_SUBCATEGORY + " TEXT," +
            COLUMN_SUBSUBCATEGORY + " TEXT," +
            COLUMN_QUESTION + " TEXT," +
            COLUMN_WORTH + " TEXT " +
            ");";

    private static final String CREATE_TABLE_TASKINFO = "CREATE TABLE " + TABLE_TASKINFO + "(" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_TASK + " TEXT," +
            COLUMN_IMAGE_PATH + " TEXT " +
            ");";

    private static final String TAG = "DBManagerMessage";
    private SQLiteDatabase dbase;

    public DataBaseForStruggles(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        db.execSQL(CREATE_TABLE_STRUGGLEINFO);
        addQuestions();
        db.execSQL(CREATE_TABLE_TASKINFO);
        addTasks();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STRUGGLEINFO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASKINFO);
        onCreate(db);
    }


    private void addTasks() {
        Tasks something1 = new Tasks("Task Description step 1", "imagePath1");
        this.addTasks(something1);
        Tasks something2 = new Tasks("Task Description step 2", "imagePath2");
        this.addTasks(something2);
    }

    private void addTasks(Tasks t) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_TASK, t.getTask());
        values.put(COLUMN_IMAGE_PATH, t.getImage_Path());
        dbase.insert(TABLE_TASKINFO, null, values);
    }


    public void addQuestions() {
        ////// Maladaptive Behavior
        SurveyQuestions MBIqI1 = new SurveyQuestions("Maladaptive Behavior Index", "Internalizing", "", "Is overly dependent, clings on to people", "1");
        this.addQuestions(MBIqI1);
        SurveyQuestions MBIqI2 = new SurveyQuestions("Maladaptive Behavior Index", "Internalizing", "", "Avoids others, prefers to be alone", "2");
        this.addQuestions(MBIqI2);
        SurveyQuestions MBIqI3 = new SurveyQuestions("Maladaptive Behavior Index", "Internalizing", "", "Is overly anxious, nervous", "2");
        this.addQuestions(MBIqI3);
        SurveyQuestions MBIqI4 = new SurveyQuestions("Maladaptive Behavior Index", "Internalizing", "", "Cries or laughs too easily", "1");
        this.addQuestions(MBIqI4);
        SurveyQuestions MBIqI5 = new SurveyQuestions("Maladaptive Behavior Index", "Internalizing", "", "Has poor eye contact", "2");
        this.addQuestions(MBIqI5);
        SurveyQuestions MBIqI6 = new SurveyQuestions("Maladaptive Behavior Index", "Internalizing", "", "Is sad for no clear reason", "2");
        this.addQuestions(MBIqI6);
        SurveyQuestions MBIqI7 = new SurveyQuestions("Maladaptive Behavior Index", "Internalizing", "", "Avoids social interaction", "2");
        this.addQuestions(MBIqI7);
        SurveyQuestions MBIqI8 = new SurveyQuestions("Maladaptive Behavior Index", "Internalizing", "", "Lacks energy", "2");
        this.addQuestions(MBIqI8);



        SurveyQuestions MBIqE1 = new SurveyQuestions("Maladaptive Behavior Index", "Externalizing", "", "Is impulsive and acts without thinking", "2");
        this.addQuestions(MBIqE1);
        SurveyQuestions MBIqE2 = new SurveyQuestions("Maladaptive Behavior Index", "Externalizing", "", "Has temper tantrums", "2");
        this.addQuestions(MBIqE2);
        SurveyQuestions MBIqE3 = new SurveyQuestions("Maladaptive Behavior Index", "Externalizing", "", "Intentionally disobeys and defies those in authority", "2");
        this.addQuestions(MBIqE3);




        SurveyQuestions MBIqO1 = new SurveyQuestions("Maladaptive Behavior Index", "Other", "", "question1 here", "1");
        this.addQuestions(MBIqO1);

        SurveyQuestions MBIqC1 = new SurveyQuestions("Maladaptive Behavior Index", "Critical Items", "", "question1 here", "2");
        this.addQuestions(MBIqC1);

        ////// Communication
        SurveyQuestions CDqR1 = new SurveyQuestions("Communication Domain", "Receptive", "", "question1 here", "1");
        this.addQuestions(CDqR1);
        SurveyQuestions CDqR2 = new SurveyQuestions("Communication Domain", "Receptive", "", "question2 here", "1");
        this.addQuestions(CDqR2);

        SurveyQuestions CDqE1 = new SurveyQuestions("Communication Domain", "Expressive", "", "question1 here", "1");
        this.addQuestions(CDqE1);

        SurveyQuestions CDqW1 = new SurveyQuestions("Communication Domain", "Written", "", "question1 here", "1");
        this.addQuestions(CDqW1);

        ////// Daily Living Skills
        SurveyQuestions DLSqW1 = new SurveyQuestions("Daily Living Skills", "", "", "question1 here", "1");
        this.addQuestions(DLSqW1);

        ////// Socialization
        SurveyQuestions SqW1 = new SurveyQuestions("Socialization", "", "", "question1 here", "1");
        this.addQuestions(SqW1);

        ////// Motor Skills
        SurveyQuestions MSqF1 = new SurveyQuestions("Motor Skills", "Fine", "", "question1 here", "1");
        this.addQuestions(MSqF1);
        SurveyQuestions MSqG1 = new SurveyQuestions("Motor Skills", "Gross", "", "question1 here", "1");
        this.addQuestions(MSqG1);
    }

    public void addQuestions(SurveyQuestions q) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_CATEGORY, q.getCategory());
        values.put(COLUMN_SUBCATEGORY, q.getSubCategory());
        values.put(COLUMN_SUBSUBCATEGORY, q.getSubSubCategory());
        values.put(COLUMN_QUESTION, q.getQuestion());
        values.put(COLUMN_WORTH, q.getAnswer());
        //Get the value?
        dbase.insert(TABLE_STRUGGLEINFO, null, values);
    }

    public List<SurveyQuestions> getAllQuestions() {
        List<SurveyQuestions> surQuest = new ArrayList<SurveyQuestions>();

        //select all query
        String selectQuery = "SELECT * FROM " + TABLE_STRUGGLEINFO;
        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()) {
            do {
                SurveyQuestions quest = new SurveyQuestions();
                quest.setID(cursor.getInt(0));
                quest.setCategory(cursor.getString(1));
                quest.setSubCategory(cursor.getString(2));
                quest.setSubSubCategory(cursor.getString(3));
                quest.setQuestion(cursor.getString(4));
                quest.setAnswer(cursor.getString(5));
                surQuest.add(quest);
            } while (cursor.moveToNext());
        }

        return surQuest;
    }


    public ArrayList<SurveyQuestions> getAllQuestionsArray() {
        ArrayList<SurveyQuestions> surQuest = new ArrayList<SurveyQuestions>();

        //select all query
        String selectQuery = "SELECT * FROM " + TABLE_STRUGGLEINFO;
        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()) {
            do {
                SurveyQuestions quest = new SurveyQuestions();
                quest.setID(cursor.getInt(0));
                quest.setCategory(cursor.getString(1));
                quest.setSubCategory(cursor.getString(2));
                quest.setSubSubCategory(cursor.getString(3));
                quest.setQuestion(cursor.getString(4));
                quest.setAnswer(cursor.getString(5));
                surQuest.add(quest);
            } while (cursor.moveToNext());
        }

        return surQuest;
    }

    //May not be needed
    public String printSubCategory(String CAT) {
        String FN = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT " + COLUMN_SUBCATEGORY + " FROM " + TABLE_STRUGGLEINFO + " WHERE " + COLUMN_CATEGORY + " = \"" +
                CAT + "\"";

        Cursor c = db.rawQuery(query, null);

        if (c.moveToFirst()) {
            //Look up what the set does
            FN = c.getString(c.getColumnIndex(COLUMN_SUBCATEGORY));
        }

        db.close();
        return FN;
    }


    //Prints each row from the database
    public String databaseToString() {
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_STRUGGLEINFO + " WHERE 1";

        //cursor point to a location in your results
        Cursor c = db.rawQuery(query, null);
        //move to the first row
        c.moveToFirst();

        while (!c.isAfterLast()) {
            Log.i(TAG, c.getString(c.getColumnIndex(COLUMN_CATEGORY)) + " " + c.getString(c.getColumnIndex(COLUMN_SUBCATEGORY)));
            if (c.getString(c.getColumnIndex(COLUMN_CATEGORY)) != null) {
                dbString += c.getString(c.getColumnIndex(COLUMN_CATEGORY));
                dbString += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }

}
