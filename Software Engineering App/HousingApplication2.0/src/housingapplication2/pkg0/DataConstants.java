package housingapplication2.pkg0;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adameinstein
 */
public abstract class DataConstants {
	protected static final String USERS_FILE_NAME = "src/students.json";
	protected static final String USERS = "users";
	protected static final String USERS_ID = "id";
	protected static final String USERS_FIRST_NAME = "firstName";
	protected static final String USERS_LAST_NAME = "lastName";
	protected static final String USERS_USERNAME = "username";
	protected static final String USERS_PASSWORD = "password";
	protected static final String USERS_PHONE = "phone";
	protected static final String USERS_EMAIL = "email";
	protected static final String USERS_RATING = "rating";
	protected static final String USERS_RATING_COUNT = "ratingCount";
	
	protected static final String STUDENTS_ID = "studentID";
	protected static final String STUDENTS_FAVORITES = "favorites";
	
	protected static final String LEASERS_FILE_NAME = "src/leasers.json";
	protected static final String LEASERS_ADDRESS = "address";
	protected static final String LEASERS_PROPERTIES = "propertyIDs";
	
	protected static final String LISTINGS_FILE_NAME = "src/listings.json";
	protected static final String LISTINGS_ID = "listingID";
	protected static final String LISTINGS_TITLE = "listingTitle";
	protected static final String LISTINGS_ADDRESS = "address";
	protected static final String LISTINGS_ZIP = "zipcode";
	protected static final String LISTINGS_BILLING_ADDRESS = "billingAddress";
	protected static final String LISTINGS_DESCRIPTION = "description";
	protected static final String LISTINGS_RATING = "rating";
	protected static final String LISTINGS_RATING_COUNT = "ratingCount";
	protected static final String LISTINGS_PRICE = "price";
	protected static final String LISTINGS_DISTANCE = "distance";
	protected static final String LISTINGS_TYPE = "housingType";
	protected static final String LISTINGS_AMENITIES = "amenities";
	protected static final String LISTINGS_MANAGER_USERNAME = "manager";
	protected static final String LISTINGS_MANAGER_NAME = "managerName";
	protected static final String LISTINGS_BEDROOMS = "bedrooms";
	protected static final String LISTINGS_BATHROOMS = "bathrooms";
	protected static final String LISTINGS_UNITS = "units";
	
	protected static final String REVIEWS_FILE_NAME = "src/reviews.json";
	protected static final String REVIEWS_LISTING_ID = "listingID";
	protected static final String REVIEWS_TITLE = "listingTitle";
	protected static final String REVIEWS_AUTHOR = "author";
	protected static final String REVIEWS_RATING = "rating";
	protected static final String REVIEWS_COMMENT = "comment";
}
