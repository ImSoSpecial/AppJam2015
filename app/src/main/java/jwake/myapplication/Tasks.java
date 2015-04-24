package jwake.myapplication;


public class Tasks {

    private int ID;
    private String Task;
    private int Image_Path;

    public Tasks() {
    }

    public Tasks(String task, int image_Path) {
        Task = task;
        Image_Path = image_Path;
    }

    public Tasks(int ID, String task, int image_Path) {
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

    public int getImage_Path() {
        return Image_Path;
    }

    //Setters
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setTask(String task) {
        Task = task;
    }

    public void setImage_Path(int image_Path) {
        Image_Path = image_Path;
    }
}
