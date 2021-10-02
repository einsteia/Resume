/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package housingapplication2.pkg0;

import java.util.ArrayList;

public class LeasingUser extends RegisteredUser {
	private String address;
	private ArrayList<HousingListing> listings;
	
	public LeasingUser(String firstName, String lastName, String username, String password,
			           String phone, String email, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.address = address;
		listings = new ArrayList<HousingListing>();
	}
	
	/**
	 * Generates a new house listing by filling in the same attributes
	 */
	public void createListing(String listingTitle, String streetAddress, String billingAddress, String zipcode, String description, double distance,
			                  double price, HousingType housingType, ArrayList<Amenities> amenities,
			                  String managerName, int bedrooms, int bathrooms, int availableUnits) {
		
		HousingListing newListing = new HousingListing(listingTitle, streetAddress, billingAddress, zipcode,
													   description, distance, price, housingType, amenities, managerName,
				                                       bedrooms, bathrooms, availableUnits);
		HousingListings housingListings = null;
		housingListings = housingListings.getInstance();
		
		newListing.setListingID(housingListings.generateListingID());
		
		listings.add(newListing);
		housingListings.addListing(newListing);
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void addProperty(HousingListing listing) {
		this.listings.add(listing);
	}
	
	public void deleteListing(String listingID, HousingListing listing, HousingListings housingListings) {
		this.listings.remove(listing);
		housingListings.removeListing(listing);
	}
	
	/** Creates an array that identifies the properties */
	public ArrayList<String> getPropertyIDs() {
		ArrayList<String> propertyIDs = new ArrayList<String>();
		
		for(int i = 0; i < this.listings.size(); ++i) {
			propertyIDs.add(this.listings.get(i).getListingID());
		}
		return propertyIDs;
	}
	
	
	public void setRatingInfo(int rating, int ratingCount) {
    	this.rating = rating;
    	this.ratingCount = ratingCount;
    }
	
}