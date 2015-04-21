package jwake.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by adrianvazquez on 4/19/15.
 */
public class DataBaseForStruggles extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "struggles.db";
    public static final String TABLE_STRUGGLEINFO = "struggleInfo";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_CATEGORY = "category";
    public static final String COLUMN_SUBCATEGORY = "subCategory";
    public static final String COLUMN_SUBSUBCATEGORY = "subSubCategory";
    public static final String COLUMN_QUESTION = "question";
    public static final String COLUMN_TASK = "task";

    private static final String TAG = "DBManagerMessage";
    private SQLiteDatabase dbase;

    public DataBaseForStruggles(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String query = "CREATE TABLE " + TABLE_STRUGGLEINFO + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_CATEGORY + " TEXT," +
                COLUMN_SUBCATEGORY + " TEXT," +
                COLUMN_SUBSUBCATEGORY + " TEXT," +
                COLUMN_TASK + " TEXT," +
                ");";
        db.execSQL(query);
        addQuestions();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STRUGGLEINFO);
        onCreate(db);
    }


    public void addQuestions() {
        ////// Maladaptive Behavior
        SurveyQuestions MBIqI1 = new SurveyQuestions("Maladaptive Behavior Index", "Internalizing", "", "question1 here", 1);
        this.addQuestions(MBIqI1);
        SurveyQuestions MBIqI2 = new SurveyQuestions("Maladaptive Behavior Index", "Internalizing", "", "question2 here", 2);
        this.addQuestions(MBIqI2);
        SurveyQuestions MBIqI3 = new SurveyQuestions("Maladaptive Behavior Index", "Internalizing", "", "question3 here", 2);
        this.addQuestions(MBIqI3);

        SurveyQuestions MBIqE1 = new SurveyQuestions("Maladaptive Behavior Index", "Externalizing", "", "question1 here", 2);
        this.addQuestions(MBIqE1);

        SurveyQuestions MBIqO1 = new SurveyQuestions("Maladaptive Behavior Index", "Other", "", "question1 here", 1);
        this.addQuestions(MBIqO1);

        SurveyQuestions MBIqC1 = new SurveyQuestions("Maladaptive Behavior Index", "Critical Items", "", "question1 here", 2);
        this.addQuestions(MBIqC1);

        ////// Communication
        SurveyQuestions CDqR1 = new SurveyQuestions("Communication Domain", "Receptive", "", "question1 here", 1);
        this.addQuestions(CDqR1);
        SurveyQuestions CDqR2 = new SurveyQuestions("Communication Domain", "Receptive", "", "question2 here", 1);
        this.addQuestions(CDqR2);

        SurveyQuestions CDqE1 = new SurveyQuestions("Communication Domain", "Expressive", "", "question1 here", 1);
        this.addQuestions(CDqE1);

        SurveyQuestions CDqW1 = new SurveyQuestions("Communication Domain", "Written", "", "question1 here", 1);
        this.addQuestions(CDqW1);

        ////// Daily Living Skills


        ////// Socialization


        ////// Motor Skills
        SurveyQuestions MSqF1 = new SurveyQuestions("Motor Skills", "Fine", "", "question1 here", 1);

        SurveyQuestions CDqG1 = new SurveyQuestions("Motor Skills", "Gross", "", "question1 here", 1);
    }

    public void addQuestions(SurveyQuestions q) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_CATEGORY, q.getCategory());
        values.put(COLUMN_SUBCATEGORY, q.getSubCategory());
        values.put(COLUMN_SUBSUBCATEGORY, q.getSubSubCategory());
        values.put(COLUMN_QUESTION, q.getQuestion());
        //Get the value?
        dbase.insert(TABLE_STRUGGLEINFO, null, values);
    }


    public void addInfo(String[] category, String[][] subCategory) {

        ContentValues values = new ContentValues();
        for(int i = 0; i < category.length; i++) {
            values.put(COLUMN_CATEGORY, category[i]);
        }

        for(int j = 0; j < subCategory.length; j++) {
            values.put(COLUMN_SUBCATEGORY, subCategory[j][0]);
            for(int k = 0; k < subCategory[j].length; k++) {
                values.put(COLUMN_SUBSUBCATEGORY, subCategory[j][k+1]);
            }
        }

        dbase.insert(TABLE_STRUGGLEINFO, null, values);
    }


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
