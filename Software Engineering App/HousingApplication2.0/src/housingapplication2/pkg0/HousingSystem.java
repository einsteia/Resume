/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package housingapplication2.pkg0;

import java.io.IOException;
import java.util.ArrayList;

public class HousingSystem {
    private Users users;
    private Reviews reviews;
    private HousingListings housingListings;
      
    public HousingSystem() {
        reviews = reviews.getInstance();
        housingListings = housingListings.getInstance();
        users = users.getInstance();
    }
    
    public boolean studentUserLogin(String username, String password) {
    	if(users.studentLogin(username, password)) {
    		return true;
    	}
    	
    	return false;
    }
    
    public StudentUser getStudentUser(String username,String password) {
    	return users.getStudentAtLogin(username, password);
    }
    
    public void createStudentUser(String id, String firstName, String lastName, String username,
    		                      String password, String phone, String email) {
    	StudentUser newStudentUser = new StudentUser(id, firstName, lastName, username, password, phone, email);
    	users.addStudent(newStudentUser);
    }
    
    public boolean leasingUserLogin(String username, String password) {
    	if(users.leaserLogin(username, password)) {
    		return true;
    	}
    	
    	return false;
    }
    
    public LeasingUser getLeasingUser(String username, String password) {
    	return users.getLeaserAtLogin(username, password);
    }
    
    public void createLeasingUser(String firstName, String lastName, String username, String password,
	                              String phone, String email, String address) {
    	LeasingUser newLeasingUser = new LeasingUser(firstName, lastName, username, password,
    			                                     phone, email, address);
    	users.addLeaser(newLeasingUser);
    }
    
    public ArrayList<HousingListing> getAllListings() {
    	return housingListings.getAllListings();
    }
    
    public HousingListing getListingByID(String listingID) {
    	return housingListings.getListingByID(listingID);
    }
    
    public ArrayList<HousingListing> getSearchResults(HousingType housingType, ArrayList<Amenities> amenities,
    		                                          int numberOfBedrooms, int numberOfBathrooms,
    		                                          double price, double maxDistance) {
    	
    	return housingListings.housingSearch(housingType, amenities, numberOfBedrooms, numberOfBathrooms, price, maxDistance);
    }
    
    public void createListing(LeasingUser manager, String listingTitle, String streetAddress, String billingAddress, String zipcode, String description, double distance,
            double price, HousingType housingType, ArrayList<Amenities> amenities,
            String managerName, int bedrooms, int bathrooms, int availableUnits) {
    	
    	manager.createListing(listingTitle, streetAddress, billingAddress, zipcode, description, distance,
    			              price, housingType, amenities, managerName, bedrooms, bathrooms, availableUnits);
    	
    	System.out.println(housingListings.getNewestListing().toString());
    	
    	
    }
    
    public void createLease(String firstTenant, String secondTenant, HousingListing leaseListing,
    		                String currentDate, String startDate, String endDate) {
    	LeaseAgreement newLease = new LeaseAgreement(firstTenant, secondTenant, leaseListing,
    			                                     currentDate, startDate, endDate);
    	newLease.generateLeaseAgreement();
    }
    
    public void saveOnExit() {
    	reviews.saveReviews();
    	housingListings.saveListings();
    	users.saveLeasers();
    	users.saveStudents();
    }
}	