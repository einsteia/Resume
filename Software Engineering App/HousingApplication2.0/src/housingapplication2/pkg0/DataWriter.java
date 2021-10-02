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
//make sure to download the json-simple so all this can compile and build path
import java.io.FileWriter; 
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
	
	public static void saveStudents() {
		
		Users user = Users.getInstance();
		ArrayList<StudentUser> students = user.getStudentList();
		JSONArray jsonStudents = new JSONArray();
	
		//creating all json objects
		for(int i = 0; i < students.size(); i++) {
				jsonStudents.add(getStudentJSON(students.get(i)));
		}
			
		try (FileWriter file = new FileWriter(USERS_FILE_NAME)) {
				
			file.write(jsonStudents.toJSONString());
			file.flush();
				
		} catch (IOException e) {
				
			e.printStackTrace();
				
		}
	}
	
	public static JSONObject getStudentJSON(StudentUser student) {
		
		JSONObject studentDetails = new JSONObject();
		studentDetails.put(STUDENTS_ID, student.getStudentID());
		studentDetails.put(USERS_FIRST_NAME, student.getFirstName());
		studentDetails.put(USERS_LAST_NAME, student.getLastName());
		studentDetails.put(USERS_USERNAME, student.getUsername());
		studentDetails.put(USERS_PASSWORD, student.getPassword());
		studentDetails.put(USERS_PHONE, student.getPhone());
		studentDetails.put(USERS_EMAIL, student.getEmail());
		studentDetails.put(USERS_RATING, String.valueOf(student.getRating()));
		studentDetails.put(USERS_RATING_COUNT, String.valueOf(student.getRatingCount()));
		studentDetails.put(STUDENTS_FAVORITES, student.getFavoriteIDs());
		
		return studentDetails;
	}
	
	public static void saveLeasers() {
		
		Users user = Users.getInstance();
		ArrayList<LeasingUser> leasers = user.getLeaserList();
		JSONArray jsonLeasers = new JSONArray();
	
		//creating all json objects
		for(int i = 0; i < leasers.size(); i++) {
				jsonLeasers.add(getLeaserJSON(leasers.get(i)));
		}
			
		try (FileWriter file = new FileWriter(LEASERS_FILE_NAME)) {
				
			file.write(jsonLeasers.toJSONString());
			file.flush();
				
		} catch (IOException e) {
				
			e.printStackTrace();
				
		}
	}

	public static JSONObject getLeaserJSON(LeasingUser leaser) {
	
		JSONObject leaserDetails = new JSONObject();
		leaserDetails.put(USERS_ID, leaser.getID());
		leaserDetails.put(USERS_FIRST_NAME, leaser.getFirstName());
		leaserDetails.put(USERS_LAST_NAME, leaser.getLastName());
		leaserDetails.put(USERS_USERNAME, leaser.getUsername());
		leaserDetails.put(USERS_PASSWORD, leaser.getPassword());
		leaserDetails.put(USERS_PHONE, leaser.getPhone());
		leaserDetails.put(USERS_EMAIL, leaser.getEmail());
		leaserDetails.put(LEASERS_ADDRESS, leaser.getAddress());
		leaserDetails.put(USERS_RATING, String.valueOf(leaser.getRating()));
		leaserDetails.put(USERS_RATING_COUNT, String.valueOf(leaser.getRatingCount()));
		leaserDetails.put(LEASERS_PROPERTIES, leaser.getPropertyIDs());
		
		return leaserDetails;
	}

	
public static void saveHousingListings() {
		HousingListings housingListings = null;
		housingListings = housingListings.getInstance();
		ArrayList<HousingListing> listings = housingListings.getAllListings();
		JSONArray jsonListings = new JSONArray();
	
		//creating all json objects
		for(int i = 0; i < listings.size(); i++) {
				jsonListings.add(getListingJSON(listings.get(i)));
		}
			
		try (FileWriter file = new FileWriter(LISTINGS_FILE_NAME)) {
				
			file.write(jsonListings.toJSONString());
			file.flush();
				
		} catch (IOException e) {
				
			e.printStackTrace();
				
		}
	}
	
	
	public static JSONObject getListingJSON(HousingListing listing) {
		
		JSONObject listingDetails = new JSONObject();
		
		listingDetails.put(LISTINGS_ID, listing.getListingID());
		listingDetails.put(LISTINGS_TITLE, listing.getListingTitle());
		listingDetails.put(LISTINGS_ADDRESS, listing.getAddress());
		listingDetails.put(LISTINGS_ZIP, listing.getZip());
		listingDetails.put(LISTINGS_BILLING_ADDRESS, listing.getPaymentAddress());
		listingDetails.put(LISTINGS_DESCRIPTION, listing.getDescription());
		listingDetails.put(LISTINGS_PRICE, String.valueOf(listing.getPrice()));
		listingDetails.put(LISTINGS_DISTANCE, String.valueOf(listing.getDistance()));
		listingDetails.put(LISTINGS_TYPE, listing.getHousingTypeString());
		listingDetails.put(LISTINGS_MANAGER_NAME, listing.getManagerName());
		listingDetails.put(LISTINGS_BEDROOMS, String.valueOf(listing.getBedrooms()));
		listingDetails.put(LISTINGS_BATHROOMS, String.valueOf(listing.getBathrooms()));
		listingDetails.put(LISTINGS_UNITS, String.valueOf(listing.getAvailableUnits()));
		listingDetails.put(LISTINGS_AMENITIES, listing.getAmenitiesString());
		listingDetails.put(LISTINGS_RATING, String.valueOf(listing.getRating()));
		listingDetails.put(LISTINGS_RATING_COUNT, String.valueOf(listing.getRatingCount()));
		
		return listingDetails;
	}
	
	public static void saveReviews() {
		
		Reviews reviews = Reviews.getInstance();
		ArrayList<Review> reviewList = reviews.getReviewList();
		JSONArray jsonReviews = new JSONArray();
	
		//creating all json objects
		for(int i = 0; i < reviewList.size(); i++) {
				jsonReviews.add(getReviewJSON(reviewList.get(i)));
		}
			
		try (FileWriter file = new FileWriter(REVIEWS_FILE_NAME)) {
				
			file.write(jsonReviews.toJSONString());
			file.flush();
				
		} catch (IOException e) {
				
			e.printStackTrace();
				
		}
	}
	
	public static JSONObject getReviewJSON(Review review) {
		
		JSONObject reviewDetails = new JSONObject();
		//reviewDetails.put(REVIEWS_TITLE, review.getListingTitle());
		reviewDetails.put(REVIEWS_AUTHOR, review.getAuthor());
		reviewDetails.put(REVIEWS_RATING, String.valueOf(review.getRating()));
		reviewDetails.put(REVIEWS_COMMENT, review.getComment());
		reviewDetails.put(REVIEWS_LISTING_ID, review.getReviewID());
		
		return reviewDetails;
	}
}