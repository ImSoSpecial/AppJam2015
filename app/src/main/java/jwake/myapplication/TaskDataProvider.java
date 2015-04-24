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
        bank.add("Remember where he/she parked");
        bank.add("Enter the bank and wait in line");
        bank.add("Case 1: Deposit check");
        bank.add("Case 2: Deposit cash");
        bank.add("Case 3: Withdraw cash");
        bank.add("Case 4: Get a new credit/debit card");

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
