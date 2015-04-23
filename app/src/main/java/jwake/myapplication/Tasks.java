package jwake.myapplication;


public class Tasks {

    private int ID;
    private String Task;
    private String Image_Path;

    public Tasks() {
    }

    public Tasks(String task, String image_Path) {
        Task = task;
        Image_Path = image_Path;
    }

    public Tasks(int ID, String task, String image_Path) {
        this.ID = ID;
        Task = task;
        Image_Path = image_Path;
    }

    //Getters
    public int getID() {
        return ID;
    }

    public String getTask() {
        return Task;
    }

    public String getImage_Path() {
        return Image_Path;
    }

    //Setters
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setTask(String task) {
        Task = task;
    }

    public void setImage_Path(String image_Path) {
        Image_Path = image_Path;
    }
}
