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
        bank.add("Opening a new bank account");
        bank.add("Closing a bank account");

        List<String> airport = new ArrayList<String>();
        airport.add("Remember the essentials before leaving the house");
        airport.add("Getting to the airport");
        airport.add("Purchasing a plane ticket");
        airport.add("At the check-in gate");
        airport.add("Security");
        airport.add("Waiting at your gate");
        airport.add("Boarding the plane");

        List<String> movies = new ArrayList<String>();
        movies.add("Picking a movie ahead of time");
        movies.add("Searching for movie theater and time");
        movies.add("Purchasing a ticket");
        movies.add("Purchasing food or snacks");
        movies.add("Find the room where your movie is showing");

        List<String> restaurant = new ArrayList<String>();
        restaurant.add("Make a reservation ahead of time if necessary");
        restaurant.add("Waiting for a table");
        restaurant.add("How to order");
        restaurant.add("Properly eating our food");
        restaurant.add("Asking for the check");
        restaurant.add("How to politely make a complaint if needed");

        List<String> job = new ArrayList<String>();
        job.add("List out all of your skills");
        job.add("Build your resume");
        job.add("Looking for places that are hiring");
        job.add("Prepare for an interview");
        job.add("How to handle acceptance / rejection");

        //all the tasks put together
        taskDetails.put("Shopping", shopping);
        taskDetails.put("Bank", bank);
        taskDetails.put("Airport", airport);
        taskDetails.put("Movies", movies);
        taskDetails.put("Restaurant", restaurant);
        taskDetails.put("Job", job);

        return taskDetails;
    }



}
