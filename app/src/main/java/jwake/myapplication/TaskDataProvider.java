package jwake.myapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TaskDataProvider {

    public static HashMap<String, List<String>> getInfo() {
        HashMap<String, List<String>> taskDetails = new HashMap<String, List<String>>();

        List<String> shopping = new ArrayList<String>();
        shopping.add("The Shawshank Redemption");
        shopping.add("The Godfather");
        shopping.add("The Godfather: Part II");
        shopping.add("Pulp Fiction");
        shopping.add("The Good, the Bad and the Ugly");
        shopping.add("The Dark Knight");
        shopping.add("12 Angry Men");

        List<String> bank = new ArrayList<String>();
        bank.add("The Conjuring");
        bank.add("Despicable Me 2");
        bank.add("Turbo");
        bank.add("Grown Ups 2");
        bank.add("Red 2");
        bank.add("The Wolverine");

        List<String> airport = new ArrayList<String>();
        airport.add("2 Guns");
        airport.add("The Smurfs 2");
        airport.add("The Spectacular Now");
        airport.add("The Canyons");
        airport.add("Europa Report");

        taskDetails.put("Shopping", shopping);
        taskDetails.put("Bank", bank);
        taskDetails.put("Airport", airport);

        return taskDetails;
    }



}
