package jwake.myapplication;


public class SurveyQuestions {

    /*
    public String[] category = {"Maladaptive Behavior Index",
            "Communication Domain",
            "Daily Living Skills Domain",
            "Socialization Domain",
            "Motor Skills Domain"};

    public String[][] subCategoryAndQuestions = {
            {"Internalizing", ""}, {"Externalizing", ""}, {"Other", ""}, {"Critical Items", " "},
            {"Receptive", ""}, {"Expressive", ""}, {"Written", ""},


            {"Fine", ""}, {"Gross", ""}};
    */


    private int ID;
    private String Question;
    private String Category;
    private String SubCategory;
    private String SubSubCategory;
    private int Answer;     //value of the response they chose
    private int Sum;

    public SurveyQuestions() {
        ID = 0;
        Category = "";
        SubCategory = "";
        SubSubCategory = "";
        Question = "";
        Answer = 0;
        Sum = 0;
    }

    public SurveyQuestions(String c, String sc, String ssc, String q, int a) {
        Category = c;
        SubCategory = sc;
        SubSubCategory = ssc;
        Question = q;
        Answer = a;
    }

    //Getters
    public int getSum() {
        return Sum;
    }

    public int getID() {
        return ID;
    }

    public String getQuestion() {
        return Question;
    }

    public String getCategory() {
        return Category;
    }

    public String getSubCategory() {
        return SubCategory;
    }

    public String getSubSubCategory() {
        return SubSubCategory;
    }

    public int getAnswer() {
        return Answer;
    }

    //Setters
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setSubCategory(String subCategory) {
        SubCategory = subCategory;
    }

    public void setSubSubCategory(String subSubCategory) {
        SubSubCategory = subSubCategory;
    }

    public void setAnswer(int answer) {
        Answer = answer;
    }

    public void setSum(int sum) {
        Sum = sum;
    }


    /*
    *
    * Maladaptive Behavior Index
    *   •	Internalizing
    *   •	Externalizing
    *   •	Other
    *   •	Critical Items
    *
    * Communication Domain
    *   •	Receptive
    *   •	Expressive
    *   •	Written
    *
    * Motor Skills
    *   •	Fine
    *   •	Gross
    *
    *
    * */




}
