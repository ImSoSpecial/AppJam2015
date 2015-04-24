package jwake.myapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TaskDataProvider {

    public static HashMap<String, List<String>> getInfo() {
        HashMap<String, List<String>> taskDetails = new HashMap<String, List<String>>();


        List<String> shopping = new ArrayList<String>();
        shopping.add("Know what he/she is shopping for");
        shopping.add("Grab shopping cart of basket depending on number of items");
        shopping.add("Search for item");
        shopping.add("Social Interaction");
        shopping.add("Wait in line");
        shopping.add("Load items onto conveyor belt");
        shopping.add("Purchase item");
        shopping.add("Return Item");
        shopping.add("Remember where he/she parked");
        shopping.add("Return to car");

        List<String> bank = new ArrayList<String>();
        bank.add("The Conjuring");
        bank.add("Despicable Me 2");
        bank.add("Turbo");
        bank.add("Grown Ups 2");
        bank.add("Red 2");
        bank.add("The Wolverine");

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
