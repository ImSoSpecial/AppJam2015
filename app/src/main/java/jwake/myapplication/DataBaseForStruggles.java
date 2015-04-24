package jwake.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
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
    public static final String COLUMN_TASK_TITLE = "taskTitle";
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
            COLUMN_TASK_TITLE + " TEXT," +
            COLUMN_TASK + " TEXT," +
            COLUMN_IMAGE_PATH + " INTEGER " +
            ");";

    private SQLiteDatabase dbase;
    Resources res;
    String res2;

    public DataBaseForStruggles(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
        res = context.getResources();
        res2 = context.getPackageName();
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
        Tasks something1 = new Tasks("Know What He/She is Shopping For", "To keep your child focused on the task at hand, be sure to have him/her write down a shopping list of items he/she plans to buy from the supermarket. Try to keep the items organized by their categories such as dairy and meat.", res.getIdentifier("list1", "drawable", res2));
        this.addTasks(something1);
        Tasks something2 = new Tasks("Know What He/She is Shopping For", "When you feel that he/she is mentally ready, your child can start to memorize the shopping list without the need to record it on paper. Start off with fewer items and gradually increase the number of items to remember.", res.getIdentifier("kidthinking", "drawable", res2));
        this.addTasks(something2);

        Tasks something3 = new Tasks("Remember Parking Location", "Have your child take a mental note of where you two parked. Be ready to test him/her when you leave to return to your vehicle.", res.getIdentifier("parkinglot", "drawable", res2));
        this.addTasks(something3);

        Tasks something4 = new Tasks("Grab Shopping Cart or Shopping Basket", "Teach your child to be able to choose between a shopping cart and a shopping basket depending on how many items he plans to buy.", res.getIdentifier("chart1", "drawable", res2));
        this.addTasks(something4);

        Tasks something5 = new Tasks("Search for Item(s)", "Teach your child to find items by understanding the category in which the items belong in. Have him/her search for the category by reading the aisle labels.", res.getIdentifier("search1", "drawable", res2));
        this.addTasks(something5);
        Tasks something6 = new Tasks("Search for Item(s)", "When an item is found, have your child place the item in the cart/basket.", res.getIdentifier("fullshoppingcart", "drawable", res2));
        this.addTasks(something6);
        Tasks something7 = new Tasks("Search for Item(s)", "Once it is confirmed that your child has obtained an item on the shopping list, make sure that he/she remembers to check it off.", res.getIdentifier("shoppinglist", "drawable", res2));
        this.addTasks(something7);
        Tasks something8 = new Tasks("Search for Item(s)", "If all items are checked off, it is time to head to the cash register for purchase.", res.getIdentifier("list3", "drawable", res2));
        this.addTasks(something8);
        Tasks something9 = new Tasks("Search for Item(s)", "If your child has trouble finding the item or requires any help in general, have him/her ask for help from an employee who works there.", res.getIdentifier("search2", "drawable", res2));
        this.addTasks(something9);

        Tasks something10 = new Tasks("Possible Social Interaction", "If your child requires the assistance of an employee of the building, make sure he/she approaches with “Excuse me,” following with a polite and respectful request for help.", res.getIdentifier("supermarketshoppinghelp", "drawable", res2));
        this.addTasks(something10);
        Tasks something11 = new Tasks("Possible Social Interaction", "After your child has received help, make sure that he/she thanks the helper.", res.getIdentifier("shakinghands", "drawable", res2));
        this.addTasks(something11);

        Tasks something12 = new Tasks("Load Items For Purchase", "Have your child wait patiently in line without getting impatient and causing any unpleasantness to his/her surroundings.", res.getIdentifier("waitinginline", "drawable", res2));
        this.addTasks(something12);
        Tasks something13 = new Tasks("Load Items For Purchase", "Before loading items, be sure that your child separates his items from other people’s items with the separator bar.", res.getIdentifier("grocery2", "drawable", res2));
        this.addTasks(something13);
        Tasks something14 = new Tasks("Load Items For Purchase", "Have your child load all items onto the conveyor belt.", res.getIdentifier("grocery3", "drawable", res2));
        this.addTasks(something14);

        Tasks something15 = new Tasks("Return Item", "Have your child approach the clerk to present the item to return.", res.getIdentifier("return2", "drawable", res2));
        this.addTasks(something15);
        Tasks something16 = new Tasks("Return Item", "Your child should then present the receipt containing the record of the item's purchase. Make sure your child checks that he/she received the right amount of money back by checking the receipt.", res.getIdentifier("return3", "drawable", res2));
        this.addTasks(something16);

        Tasks something17 = new Tasks("Purchase Item", "If paying with cash, make sure your child gives enough cash to the clerk.", res.getIdentifier("paycash", "drawable", res2));
        this.addTasks(something17);
        Tasks something18 = new Tasks("Purchase Item", "If paying with a credit/debit card, make sure your child is able to swipe and sign his/her signature correctly.", res.getIdentifier("paycard", "drawable", res2));
        this.addTasks(something18);
        Tasks something19 = new Tasks("Purchase Item", "If there is left over change, make sure your child collects the change and is able to verify that the correct value was received.", res.getIdentifier("getchange", "drawable", res2));
        this.addTasks(something19);

        Tasks something20 = new Tasks("Return to the Car", "Test to see if your child remembers where the vehicle is parked and have him/her find it.", res.getIdentifier("returnparking", "drawable", res2));
        this.addTasks(something20);
        Tasks something21 = new Tasks("Return to the Car", "Have your child load the items from the shopping cart/basket into the car.", res.getIdentifier("loadcar", "drawable", res2));
        this.addTasks(something21);
    }

    private void addTasks(Tasks t) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_TASK_TITLE, t.getTaskTitle());
        values.put(COLUMN_TASK, t.getTask());
        values.put(COLUMN_IMAGE_PATH, t.getImage_Path());
        dbase.insert(TABLE_TASKINFO, null, values);
    }

    public ArrayList<Tasks> getAllTasksArray() {
        ArrayList<Tasks> tasksDetail = new ArrayList<Tasks>();

        //select all query
        String selectQuery = "SELECT * FROM " + TABLE_TASKINFO;
        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()) {
            do {
                Tasks quest = new Tasks();
                quest.setID(cursor.getInt(0));
                quest.setTaskTitle(cursor.getString(1));
                quest.setTask(cursor.getString(2));
                quest.setImage_Path(cursor.getInt(3));
                tasksDetail.add(quest);
            } while (cursor.moveToNext());
        }

        return tasksDetail;
    }

    ///////////


    public void addQuestions() {
        ////// Maladaptive Behavior
        SurveyQuestions MBIqI1 = new SurveyQuestions("Maladaptive Behavior Index", "Internalizing", "1. Is overly dependent, clings on to people", "1");
        this.addQuestions(MBIqI1);
        SurveyQuestions MBIqI2 = new SurveyQuestions("Maladaptive Behavior Index", "Internalizing", "2. Avoids others, prefers to be alone", "2");
        this.addQuestions(MBIqI2);
        SurveyQuestions MBIqI3 = new SurveyQuestions("Maladaptive Behavior Index", "Internalizing", "3. Is overly anxious, nervous", "2");
        this.addQuestions(MBIqI3);
        SurveyQuestions MBIqI4 = new SurveyQuestions("Maladaptive Behavior Index", "Internalizing", "4. Cries or laughs too easily", "1");
        this.addQuestions(MBIqI4);
        SurveyQuestions MBIqI5 = new SurveyQuestions("Maladaptive Behavior Index", "Internalizing", "5. Has poor eye contact", "2");
        this.addQuestions(MBIqI5);
        SurveyQuestions MBIqI6 = new SurveyQuestions("Maladaptive Behavior Index", "Internalizing", "6. Is sad for no clear reason", "2");
        this.addQuestions(MBIqI6);
        SurveyQuestions MBIqI7 = new SurveyQuestions("Maladaptive Behavior Index", "Internalizing", "7. Avoids social interaction", "2");
        this.addQuestions(MBIqI7);
        SurveyQuestions MBIqI8 = new SurveyQuestions("Maladaptive Behavior Index", "Internalizing", "8. Lacks energy", "2");
        this.addQuestions(MBIqI8);



        SurveyQuestions MBIqE1 = new SurveyQuestions("Maladaptive Behavior Index", "Externalizing", "9. Is impulsive and acts without thinking", "2");
        this.addQuestions(MBIqE1);
        SurveyQuestions MBIqE2 = new SurveyQuestions("Maladaptive Behavior Index", "Externalizing", "10. Has temper tantrums", "2");
        this.addQuestions(MBIqE2);
        SurveyQuestions MBIqE3 = new SurveyQuestions("Maladaptive Behavior Index", "Externalizing", "11. Intentionally disobeys and defies those in authority", "2");
        this.addQuestions(MBIqE3);
        SurveyQuestions MBIqE4 = new SurveyQuestions("Maladaptive Behavior Index", "Externalizing", "12. Taunts, teases, bullies", "2");
        this.addQuestions(MBIqE4);
        SurveyQuestions MBIqE5 = new SurveyQuestions("Maladaptive Behavior Index", "Externalizing", "13. Is inconsiderate, insensitive to others", "2");
        this.addQuestions(MBIqE5);
        SurveyQuestions MBIqE6 = new SurveyQuestions("Maladaptive Behavior Index", "Externalizing", "14. Lies, cheats, steals", "2");
        this.addQuestions(MBIqE6);
        SurveyQuestions MBIqE7 = new SurveyQuestions("Maladaptive Behavior Index", "Externalizing", "15. Is physically aggressive", "2");
        this.addQuestions(MBIqE7);
        SurveyQuestions MBIqE8 = new SurveyQuestions("Maladaptive Behavior Index", "Externalizing", "16. Says / asks embarrassing things in public", "2");
        this.addQuestions(MBIqE8);


        SurveyQuestions MBIqO1 = new SurveyQuestions("Maladaptive Behavior Index", "Other", "17. Sucks thumb / fingers", "1");
        this.addQuestions(MBIqO1);
        SurveyQuestions MBIqO2 = new SurveyQuestions("Maladaptive Behavior Index", "Other", "18. Acts overly familiar with strangers", "1");
        this.addQuestions(MBIqO2);
        SurveyQuestions MBIqO3 = new SurveyQuestions("Maladaptive Behavior Index", "Other", "19. Bites fingernails", "1");
        this.addQuestions(MBIqO3);
        SurveyQuestions MBIqO4 = new SurveyQuestions("Maladaptive Behavior Index", "Other", "20. Has ticks (twitching, head shaking, etc.)", "1");
        this.addQuestions(MBIqO4);
        SurveyQuestions MBIqO5 = new SurveyQuestions("Maladaptive Behavior Index", "Other", "21. Grinds his teeth", "1");
        this.addQuestions(MBIqO5);
        SurveyQuestions MBIqO6 = new SurveyQuestions("Maladaptive Behavior Index", "Other", "22. Hard time paying attention", "1");
        this.addQuestions(MBIqO6);
        SurveyQuestions MBIqO7 = new SurveyQuestions("Maladaptive Behavior Index", "Other", "23. More active / restless than others of the same ag", "1");
        this.addQuestions(MBIqO7);
        SurveyQuestions MBIqO8 = new SurveyQuestions("Maladaptive Behavior Index", "Other", "24. Swears", "1");
        this.addQuestions(MBIqO8);
        SurveyQuestions MBIqO9 = new SurveyQuestions("Maladaptive Behavior Index", "Other", "25. Ignores or doesn’t pay attention to others around him/her", "1");
        this.addQuestions(MBIqO9);



        SurveyQuestions MBIqC1 = new SurveyQuestions("Maladaptive Behavior Index", "Critical Items", "26. Is obsessed with objects, activities", "2");
        this.addQuestions(MBIqC1);
        SurveyQuestions MBIqC2 = new SurveyQuestions("Maladaptive Behavior Index", "Critical Items", "27. Consistently prefers objects to people", "2");
        this.addQuestions(MBIqC2);
        SurveyQuestions MBIqC3 = new SurveyQuestions("Maladaptive Behavior Index", "Critical Items", "28. Displays behaviors that cause injury to self", "2");
        this.addQuestions(MBIqC3);
        SurveyQuestions MBIqC4 = new SurveyQuestions("Maladaptive Behavior Index", "Critical Items", "29. Destroys his/her own/other’s possessions on purpose", "2");
        this.addQuestions(MBIqC4);
        SurveyQuestions MBIqC5 = new SurveyQuestions("Maladaptive Behavior Index", "Critical Items", "30. Uses bizarre speech, conversations with self, sentences with no meaning, repetition in public", "2");
        this.addQuestions(MBIqC5);
        SurveyQuestions MBIqC6 = new SurveyQuestions("Maladaptive Behavior Index", "Critical Items", "31. Is unaware of what is happening around him/her", "2");
        this.addQuestions(MBIqC6);
        SurveyQuestions MBIqC7 = new SurveyQuestions("Maladaptive Behavior Index", "Critical Items", "32. Is unusually fearful of ordinary sounds, objects, or situations", "2");
        this.addQuestions(MBIqC7);



        ////// Communication
        SurveyQuestions CDqR1 = new SurveyQuestions("Communication Domain", "Receptive", "1. Responds to his/her name spoken", "1");
        this.addQuestions(CDqR1);
        SurveyQuestions CDqR2 = new SurveyQuestions("Communication Domain", "Receptive", "2. Demonstrates understanding of the meaning of “yes” and “no”", "1");
        this.addQuestions(CDqR2);
        SurveyQuestions CDqR3 = new SurveyQuestions("Communication Domain", "Receptive", "3. Listens to instructions", "1");
        this.addQuestions(CDqR3);



        SurveyQuestions CDqE1 = new SurveyQuestions("Communication Domain", "Expressive", "4. Smiles when you smile at him/her", "1");
        this.addQuestions(CDqE1);
        SurveyQuestions CDqE2 = new SurveyQuestions("Communication Domain", "Expressive", "5. Waves goodbye when another person waves", "1");
        this.addQuestions(CDqE2);
        SurveyQuestions CDqE3 = new SurveyQuestions("Communication Domain", "Expressive", "6. Points to object he/she wants that is out of reach", "1");
        this.addQuestions(CDqE3);
        SurveyQuestions CDqE4 = new SurveyQuestions("Communication Domain", "Expressive", "7. Points or gestures to indicate preference when offered a choice", "1");
        this.addQuestions(CDqE4);
        SurveyQuestions CDqE5 = new SurveyQuestions("Communication Domain", "Expressive", "8. Answers or tries to answer when asked a question correctly", "1");
        this.addQuestions(CDqE5);
        SurveyQuestions CDqE6 = new SurveyQuestions("Communication Domain", "Expressive", "9. Asks questions that people can understand", "1");
        this.addQuestions(CDqE6);
        SurveyQuestions CDqE7 = new SurveyQuestions("Communication Domain", "Expressive", "10. Can properly use good grammar", "1");
        this.addQuestions(CDqE7);
        SurveyQuestions CDqE8 = new SurveyQuestions("Communication Domain", "Expressive", "11. Pronounces words clearly", "1");
        this.addQuestions(CDqE8);
        SurveyQuestions CDqE9 = new SurveyQuestions("Communication Domain", "Expressive", "12. Speaks in detail", "1");
        this.addQuestions(CDqE9);
        SurveyQuestions CDqE10 = new SurveyQuestions("Communication Domain", "Expressive", "13. Appropriate tone and volume", "1");
        this.addQuestions(CDqE10);
        SurveyQuestions CDqE11 = new SurveyQuestions("Communication Domain", "Expressive", "14. Can carry conversation", "1");
        this.addQuestions(CDqE11);



        SurveyQuestions CDqW1 = new SurveyQuestions("Communication Domain", "Written", "15. Identify words in text correctly", "1");
        this.addQuestions(CDqW1);
        SurveyQuestions CDqW2 = new SurveyQuestions("Communication Domain", "Written", "16. Can read and understand all directions", "1");
        this.addQuestions(CDqW2);
        SurveyQuestions CDqW3 = new SurveyQuestions("Communication Domain", "Written", "17. Can write legibly", "1");
        this.addQuestions(CDqW3);

        ////// Daily Living Skills
        SurveyQuestions DLSqW1 = new SurveyQuestions("Daily Living Skills", "Community", "1. Understands how money works and how to use it", "1");
        this.addQuestions(DLSqW1);
        SurveyQuestions DLSqW2 = new SurveyQuestions("Daily Living Skills", "Community", "2. Follows rules", "1");
        this.addQuestions(DLSqW2);
        SurveyQuestions DLSqW3 = new SurveyQuestions("Daily Living Skills", "Community", "3. Identifies penny, nickel, dime, and quarter and knows the value differences", "1");
        this.addQuestions(DLSqW3);
        SurveyQuestions DLSqW4 = new SurveyQuestions("Daily Living Skills", "Community", "4. Looks both ways when crossing streets or roads", "1");
        this.addQuestions(DLSqW4);
        SurveyQuestions DLSqW5 = new SurveyQuestions("Daily Living Skills", "Community", "5. Identifies between bills of different values and understands their value differences", "1");
        this.addQuestions(DLSqW5);
        SurveyQuestions DLSqW6 = new SurveyQuestions("Daily Living Skills", "Community", "6. Demonstrates understanding that some items cost more than others (Example: “Which eraser costs less?” “I have enough for item 1 but not for item 2”)", "1");
        this.addQuestions(DLSqW6);
        SurveyQuestions DLSqW7 = new SurveyQuestions("Daily Living Skills", "Community", "7. Carries or stores money safely (in a wallet, purse, money belt, etc.)", "1");
        this.addQuestions(DLSqW7);
        SurveyQuestions DLSqW8 = new SurveyQuestions("Daily Living Skills", "Community", "8. Can count change", "1");
        this.addQuestions(DLSqW8);
        SurveyQuestions DLSqW9 = new SurveyQuestions("Daily Living Skills", "Community", "9. Evaluates quality and price when selecting items to purchase", "1");
        this.addQuestions(DLSqW9);
        SurveyQuestions DLSqW10 = new SurveyQuestions("Daily Living Skills", "Community", "10. Manages own money (EX: pays for expenses, uses checks or money as needed)", "1");
        this.addQuestions(DLSqW10);


        SurveyQuestions DLSqC1 = new SurveyQuestions("Daily Living Skills", "Community", "11. Understands how money works and how to use it", "1");
        this.addQuestions(DLSqC1);
        SurveyQuestions DLSqC2 = new SurveyQuestions("Daily Living Skills", "Community", "12. Says “thank you” when given something", "1");
        this.addQuestions(DLSqC2);
        SurveyQuestions DLSqC3 = new SurveyQuestions("Daily Living Skills", "Community", "13. Says “please” when asking for something", "1");
        this.addQuestions(DLSqC3);
        SurveyQuestions DLSqC4 = new SurveyQuestions("Daily Living Skills", "Community", "14. Says that he or she is “sorry” for unintended mistakes", "1");
        this.addQuestions(DLSqC4);
        SurveyQuestions DLSqC5 = new SurveyQuestions("Daily Living Skills", "Community", "15. Acts appropriately when introduced to strangers (nods, smiles, shakes hands, greets them, etc.)", "1");
        this.addQuestions(DLSqC5);
        SurveyQuestions DLSqC6 = new SurveyQuestions("Daily Living Skills", "Community", "16. Shows respect for workers (does not distract or interrupt them while they are working, etc.)", "1");
        this.addQuestions(DLSqC6);


        ////// Socialization
        SurveyQuestions SqW1 = new SurveyQuestions("Socialization", "", "question1 here", "1");
        this.addQuestions(SqW1);

        ////// Motor Skills
        SurveyQuestions MSqF1 = new SurveyQuestions("Motor Skills", "Fine", "1. Picks up and carries objects without any problems", "1");
        this.addQuestions(MSqF1);


        SurveyQuestions MSqG1 = new SurveyQuestions("Motor Skills", "Gross", "2. Runs without any problems", "1");
        this.addQuestions(MSqG1);
        SurveyQuestions MSqG2 = new SurveyQuestions("Motor Skills", "Gross", "3. Walks without any problems", "1");
        this.addQuestions(MSqG2);
    }

    public void addQuestions(SurveyQuestions q) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_CATEGORY, q.getCategory());
        values.put(COLUMN_SUBCATEGORY, q.getSubCategory());
        values.put(COLUMN_QUESTION, q.getQuestion());
        values.put(COLUMN_WORTH, q.getAnswer());
        //Get the value?
        dbase.insert(TABLE_STRUGGLEINFO, null, values);
    }
/*
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
                quest.setQuestion(cursor.getString(4));
                quest.setAnswer(cursor.getString(5));
                surQuest.add(quest);
            } while (cursor.moveToNext());
        }

        return surQuest;
    }*/


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
                quest.setQuestion(cursor.getString(4));
                quest.setAnswer(cursor.getString(5));
                surQuest.add(quest);
            } while (cursor.moveToNext());
        }

        return surQuest;
    }

}
