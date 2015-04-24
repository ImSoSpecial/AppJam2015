package jwake.myapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TaskDataProvider {

    public static HashMap<String, List<String>> getInfo() {
        HashMap<String, List<String>> taskDetails = new HashMap<String, List<String>>();


        List<String> shopping = new ArrayList<String>();
        shopping.add("Know What He/She is Shopping For");
        shopping.add("Remember Parking Location");
        shopping.add("Grab Shopping Cart or Shopping Basket");
        shopping.add("Search for Item(s)");
        shopping.add("Possible Social Interaction");
        shopping.add("Load Items For Purchase");
        shopping.add("Return Item");
        shopping.add("Purchase Item");
        shopping.add("Return to the Car");

        List<String> bank = new ArrayList<String>();
        bank.add("Remember where he/she parked");
        bank.add("Enter the bank and wait in line");
        bank.add("Case 1: Deposit check");
        bank.add("Case 2: Deposit cash");
        bank.add("Case 3: Withdraw cash");
        bank.add("Case 4: Get a new credit/debit card");

        List<String> airport = new ArrayList<String>();
        airport.add("Purchasing a plane ticket");
        airport.add("The Smurfs 2");
        airport.add("The Spectacular Now");
        airport.add("The Canyons");
        airport.add("Europa Report");

        List<String> restaurant = new ArrayList<String>();
        restaurant.add("How to order");
        restaurant.add("Asking for the check");
        restaurant.add("Making a reservation");


        //all the tasks put together
        taskDetails.put("Shopping", shopping);
        taskDetails.put("Bank", bank);
        taskDetails.put("Airport", airport);
        taskDetails.put("Restaurant", restaurant);

        return taskDetails;
    }



}
