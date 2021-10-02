/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package housingapplication2.pkg0;

/**
 *
 * @author adameinstein
 */
import java.util.ArrayList;
import java.util.Scanner;

public class HousingUI {
    private static final String  WELCOME_MESSAGE = "Welcome to Team India Housing system";
    private static final String ChoiceByNumber = "Please choose by command number " ;
    private static final String[] MainMenuOptions = {"Search for housing","Log in as Student User",
    		                            "Login as Property Manager","Create an account","Post listing",
    		                            "Create a lease agreement", "Quit"};
    private static final String[] accountCreationMenu = {"Create a student account" , "Sign Up as Property Managers"};
    private static final String[] FindListings = {"View all listings","Search listings using filters" , "Go back to main menu"};
    private static final String[] searchOptions = {"Include housing type", "Include amenities", "Include number of bedrooms",
    		                          "Include number of bathrooms", "Include maximum price", "Include maximum distance from campus",
    		                          "Search with selected options"};
    private static final String[] housingTypes = {"Apartment", "Condo", "Co-op", "Duplex", "House", "Loft", "Studio", "Townhome"};
    private static final String[] houseAmenities = {"Bike Racks", "Cats allowed", "Dogs allowed", "Furnished", "Garbage Pickup",
    		                          "On-site laundromat", "Parking", "Pool", "Washer and Dryer Connections",
    		                          "Washer and Dryer included", "Wheelchair Accessible", "Done adding amenities"};
    
    private Scanner sc;
    private HousingSystem housingSystem;
    private StudentUser studentUser;
    private LeasingUser leasingUser;
    private boolean isStudentUser;
    private boolean isPropertyUser;



    HousingUI(){
    	sc = new Scanner(System.in);
    	housingSystem = new HousingSystem();
    	isStudentUser = false;
    	isPropertyUser = false;
    }



    public void run(){
        System.out.println(WELCOME_MESSAGE);
        
        while(true) {
            displayMenu(MainMenuOptions);
            
            int command = getCommand(MainMenuOptions.length);

            if(command == -1) {
            	System.out.println("Not a valid command\n");
            	continue;
            }
            
            //exits system if last option is selected
            if(command == MainMenuOptions.length - 1) break;
            
            switch (command){
            	case(0):
            		FindListings();
            		break;
            	case(1):
	                studentLogin();
	                break;
	            case(2):
	            	leaserLogin();
	            	break;
	            case(3):
	            	createAccount();
	            	break;
	            case(4):
	            	postListing();
	            	break;
	            case(5):
	            	createLease();
	            	break;
	            case(6):
	            	System.out.println("Thank you for using Team India's housing search system. Goodbye!");
	            	break;
	            default:
	            	continue;
            }
        }     
        
        housingSystem.saveOnExit();
    }


    public void displayMenu(String[] menu){
    	
        for (int i = 0; i < menu.length; i++){
            System.out.println((i+1) + ". " + menu[i]);
        }
        System.out.println("\n");
    }

    private int getCommand(int numCommands) {
        System.out.println("Please select an option: ");
        
        String input = sc.nextLine();
        int command = Integer.parseInt(input) - 1;
        if(command >= 0 && command <= numCommands -1) return command;

        return -1;
    }

    public void studentLogin() {
    	String username;
    	String password;
    	
    	System.out.println("Please enter your username (case sensitive):");
    	username = sc.nextLine();
    	
    	System.out.println("Please enter your password (case sensitive): ");
    	password = sc.nextLine();
    	
    	if(housingSystem.studentUserLogin(username, password)) {
    		this.isStudentUser = true;
    		this.studentUser = housingSystem.getStudentUser(username, password);
    	} else {
    		System.out.println("Invalid login. Returning to main menu");
    	}
    }
    
    public void leaserLogin() {
    	String username;
    	String password;
    	
    	System.out.println("Please enter your username (case sensitive):");
    	username = sc.nextLine();
    	
    	System.out.println("Please enter your password (case sensitive): ");
    	password = sc.nextLine();
    	
    	if(housingSystem.leasingUserLogin(username, password)) {
    		this.isPropertyUser = true;
    		leasingUser = housingSystem.getLeasingUser(username ,password);
    	} else {
    		System.out.println("Invalid login. Returning to main menu");
    	}
    	
    }
    
    public void FindListings(){
        int command;
        while(true) {
	        displayMenu(FindListings);
	        
	        command = getCommand(FindListings.length);
	        
	        if(command == -1) {
	        	System.out.println("Not a valid command");
	        	continue;
	        }
	
	        switch (command){
	            case(0):
	                viewAllListings();
	                break;
	            case(1):
	                searchListings();
	                break;
	            case(2):
	            	return;
	            default:
	            	continue;
	         }
        }
    }
    
    public void viewAllListings() {
    	System.out.println("\n*****Displaying all available housing listings*****");
    	
    	ArrayList<HousingListing> listings = housingSystem.getAllListings();
    	
    	for(int i = 0; i < listings.size(); ++i) {
    		System.out.println(listings.get(i).toString());
    	}
    	
    	System.out.println("End of listings");
    }

    
    public void searchListings() {
    	int command;
    	HousingType housingType = null;
    	ArrayList<Amenities> amenities = new ArrayList<Amenities>();
    	int numberOfBedrooms = 0;
    	int numberOfBathrooms = 0;
    	double price = 0;
    	double maxDistance = 0;
    	
    	while(true) {
	    	displayMenu(searchOptions);
	    	
	    	command = getCommand(searchOptions.length);
	    	
	    	if(command == -1) {
	    		System.out.println("Not a valid command");
	    		continue;
	    	}
	    	
	    	// Done selection search parameters
	    	if(command == searchOptions.length -1) break;
	    	
	    	switch(command) {
	    		case(0):
	    			housingType = housingTypePrompt();
	    			continue;
	    		case(1):
	    			amenities = amenitiesPrompt();
	    			continue;
	    		case(2):
	    			System.out.println("Number of Bedrooms to be searched for?:");
	    			String bedrooms = sc.nextLine();
	    			numberOfBedrooms = Integer.parseInt(bedrooms);
	    			continue;
	    		case(3):
	    			System.out.println("Number of Bathrooms to be searched for?:");
	    			String bathrooms = sc.nextLine();
	    			numberOfBathrooms = Integer.parseInt(bathrooms);
	    			continue;
	    		case(4):
	    			System.out.println("Maximum price?:");
	    			String priceInput = sc.nextLine();
	    			price = Double.parseDouble(priceInput);
	    			continue;
	    		case(5):
	    			System.out.println("Maxiumum distance?:");
	    			String distanceInput = sc.nextLine();
	    			maxDistance = Double.parseDouble(distanceInput);
	    			continue;
	    		case(6):
	    			System.out.println("Search with selected parameters");
	    			break;
	    		default:
	    			continue;
	    	}
	    	break;
    	}
    	
    	this.displaySearchResults(housingType, amenities, numberOfBedrooms, numberOfBathrooms, price, maxDistance);
    }
    
    public void displaySearchResults(HousingType housingType, ArrayList<Amenities> amenities,
    		                         int numberOfBedrooms, int numberOfBathrooms, double price,
    		                         double maxDistance) {
    	ArrayList<HousingListing> searchResults;
    	searchResults = housingSystem.getSearchResults(housingType, amenities, numberOfBedrooms, numberOfBathrooms,
    			                       price, maxDistance);
    	
    	for(int i = 0; i < searchResults.size(); ++i) {
    		System.out.println(searchResults.get(i).toString());
    	}
    	
    	System.out.println("\nSearch Complete!");
    	
    }
    
    public void postListing() {
    	if(!this.isPropertyUser) {
    		System.out.println("Must be logged in with a property management account in order "
    		    + "to create a housing listing.\n");
    		return;
    	}
    	
    	String listingTitle;
    	String listingAddress;
    	String billingAddress = leasingUser.getAddress();
    	String zipcode;
    	String description;
    	String managerName = leasingUser.getFirstName() + " " + leasingUser.getLastName();
    	String input;
    	double distance;
    	double price;
    	int numberOfBedrooms;
    	int numberOfBathrooms;
    	int availableUnits;
    	
    	
    	System.out.println("Enter a title for the listing:\n");
    	listingTitle = sc.nextLine();
    	System.out.println("Enter the street address of the property: \n");
    	listingAddress = sc.nextLine();
    	System.out.println("Enter the zipcode for the property: \n");
    	zipcode = sc.nextLine();
    	System.out.println("Set the monthly rate for the property: \n");
    	input = sc.nextLine();
    	price = Double.parseDouble(input);
    	System.out.println("Distance from campus?: \n");
    	input = sc.nextLine();
    	distance = Double.parseDouble(input);
    	System.out.println("How many bedrooms does the property have?: \n");
    	input = sc.nextLine();
    	numberOfBedrooms = Integer.parseInt(input);
    	System.out.println("How many bathrooms does the property have?: \n");
    	input = sc.nextLine();
    	numberOfBathrooms = Integer.parseInt(input);
    	System.out.println("How many units are available?: \n");
    	input = sc.nextLine();
    	availableUnits = Integer.parseInt(input);
    	System.out.println("Please enter a description for the property: \n");
    	description = sc.nextLine();
    	
    	HousingType housingType = housingTypePrompt();
    	ArrayList<Amenities> amenities = amenitiesPrompt();
    	
    	housingSystem.createListing(this.leasingUser, listingTitle, listingAddress, billingAddress, zipcode,
				   description, distance, price, housingType, amenities, managerName,
                   numberOfBedrooms, numberOfBathrooms, availableUnits);
    	
    }
    
    public HousingType housingTypePrompt() {
    	int command;
    	HousingType returnType;
    	displayMenu(housingTypes);
    	
    	command = getCommand(housingTypes.length);
    	
    	if(command == -1) {
    		System.out.println("No type selected");
    		return returnType = null;
    	}
    	
    	switch(command) {
    		case(0):
    			returnType = HousingType.APARTMENT;
    			break;
    		case(1):
    			returnType = HousingType.CONDO;
    			break;
    		case(2):
    			returnType = HousingType.COOP;
    			break;
    		case(3):
    			returnType = HousingType.DUPLEX;
    			break;
    		case(4):
    			returnType = HousingType.HOUSE;
    			break;
    		case(5):
    			returnType = HousingType.LOFT;
    			break;
    		case(6):
    			returnType = HousingType.STUDIO;
    			break;
    		case(7):
    			returnType = HousingType.TOWNHOME;
    			break;
    		default:
    			returnType = null;
    			break;	
    	}
    	
    	return returnType;
    }
    
    public ArrayList<Amenities> amenitiesPrompt() {
    	int command;
    	ArrayList<Amenities> amenities = new ArrayList<Amenities>();
    	while(true) {
	    	displayMenu(houseAmenities);
	    	
	    	command = getCommand(houseAmenities.length);
	    	
	    	if(command == -1) {
	    		System.out.println("Invalid command");
	    	}
	    	
	    	// Done adding amenities
	    	if(command == houseAmenities.length) break;
	    	
	    	switch(command) {
	    		case(0):
	    			amenities.add(Amenities.BIKE_RACKS);
	    			break;
	    		case(1):
	    			amenities.add(Amenities.CATS);
	    			break;
	    		case(2):
	    			amenities.add(Amenities.DOGS);
	    			break;
	    		case(3):
	    			amenities.add(Amenities.FURNISHED);
	    			break;
	    		case(4):
	    			amenities.add(Amenities.GARBAGE_PICKUP);
	    			break;
	    		case(5):
	    			amenities.add(Amenities.ONSITE_LAUNDRY);
	    			break;
	    		case(6):
	    			amenities.add(Amenities.PARKING);
	    			break;
	    		case(7):
	    			amenities.add(Amenities.POOL);
	    			break;
	    		case(8):
	    			amenities.add(Amenities.WASHER_DRYER_CONNECTIONS);
	    			break;
	    		case(9):
	    			amenities.add(Amenities.WASHER_DRYER_INCLUDED);
	    			break;
	    		case(10):
	    			amenities.add(Amenities.WHEELCHAIR_ACCESSIBLE);
	    			break;
	    		case(11):
	    			return amenities;
	    		default:
	    			break;	
	    	}
    	}
    	
    	return amenities;
    }
    
     public void createAccount(){
        int command;
        displayMenu(accountCreationMenu);
        command = getCommand(accountCreationMenu.length);

        switch (command){
            case (0):
                createStudentAccount();
                break;
            case (1):
                createLeaserAccount();
                break;

            default:
                System.out.println("Wrong choice!" + "\n");
                break;
        }
     }
    

    public void  createStudentAccount(){
        System.out.println("Please enter your first name:\n");
        String firstName = sc.nextLine();
        System.out.println("Please enter your last name: \n");
        String lastName = sc.nextLine();
        System.out.println("Please enter your USC ID" + "\n");
        String id = sc.nextLine();
        System.out.println("Please enter your phone number: \n");
        String phone = sc.nextLine();
        System.out.println("Please enter you email address: \n");
        String email = sc.nextLine();
        System.out.println("Please enter your username: \n");
        String username = sc.nextLine();
        System.out.println("Please enter your password" + "\n");
        String password = sc.nextLine();

        housingSystem.createStudentUser(id, firstName, lastName, username, password, phone, email);

        System.out.println("Welcome" + firstName + " " + lastName + "!\nPlease return to the main menu and login.\n");
    }

     
    public void createLeaserAccount(){
        System.out.println("Please enter your first name" + "\n");
        String firstName = sc.nextLine();
        System.out.println("Please enter your last name" + "\n");
        String lastName = sc.nextLine();
        System.out.println("Please enter your username: \n");
        String username = sc.nextLine();
        System.out.println("Please enter your password" + "\n");
        String password = sc.nextLine();
        System.out.println("Please enter your phone number: \n");
        String phone = sc.nextLine();
        System.out.println("Please enter your email address: \n");
        String email = sc.nextLine();
        System.out.println("Please enter your billing/business address: \n");
        String address = sc.nextLine();

        housingSystem.createLeasingUser(firstName, lastName, username, password, phone, email, address);

        System.out.println("Welcome" + firstName + " " + lastName + "!\nPlease return to the main menu");
    }

    public void createLease() {
    	String currentDate;
    	String startDate;
    	String endDate;
    	String firstTenant = "";
    	String secondTenant = "";
    	String listingID;
    	HousingListing leaseListing;
    	
    	if(!this.isStudentUser) {
    		System.out.println("Please login with a student account, or create a new student account "
    							+ "in order to use this feature.");
    		return;
    	}
    	firstTenant = studentUser.getFullName();
    	
    	System.out.println("Please enter the ID for the listing for which you would like to create a lease agreement: \n");
    	listingID = sc.nextLine();
    	leaseListing = housingSystem.getListingByID(listingID);
    	
    	if(leaseListing == null) {
    		System.out.println("Invalid listing ID. Please try again!");
    		return;
    	}
    	
    	System.out.println("Please enter the current date (DD/MM/YY): \n");
    	currentDate = sc.nextLine();
    	System.out.println("Please enter the day you would like your lease to begin (DD/MM/YY): \n");
    	startDate = sc.nextLine();
    	System.out.println("Please enter the day you would like your lease to end (DD/MM/YY): \n");
    	endDate = sc.nextLine();
    	
    	
    	System.out.println("Would you like to apply with an additional tenant? (yes/no): \n");
    	String input = sc.nextLine();
    		
    	if(input.equalsIgnoreCase("yes")) {
    		System.out.println("Please enter full name of second tenant: \n");
    		secondTenant = sc.nextLine();
    	}
    		
    	housingSystem.createLease(firstTenant, secondTenant, leaseListing,
    				                  currentDate, startDate, endDate);
    		
    	System.out.println("Lease creation successful.");
    	
    	
    	
    	
    }






    public static void main(String[] args) {
        HousingUI housingInterface = new HousingUI();
        housingInterface.run();
    }
}