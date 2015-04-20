package jwake.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STRUGGLEINFO);
        onCreate(db);
    }
}
