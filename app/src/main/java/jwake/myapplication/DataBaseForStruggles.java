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
    public static final String COLUMN_TASK = "task";

    private static final String TAG = "DBManagerMessage";

    public DataBaseForStruggles(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
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
        SurveyQuestions q1 = new SurveyQuestions("Maladaptive Behavior Index", "Internalizing", "", "question1 here", 1);
        SurveyQuestions q2 = new SurveyQuestions("Maladaptive Behavior Index", "Internalizing", "", "question2 here", 2);
        SurveyQuestions q3 = new SurveyQuestions("Maladaptive Behavior Index", "Internalizing", "", "question3 here", 2);

        SurveyQuestions q4 = new SurveyQuestions("Maladaptive Behavior Index", "Externalizing", "", "question1 here", 2);

        SurveyQuestions qx = new SurveyQuestions("Maladaptive Behavior Index", "Other", "", "question1 here", 1);

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

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_STRUGGLEINFO, null, values);
        db.close();
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
