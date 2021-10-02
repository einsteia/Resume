package housingapplication2.pkg0;

import java.util.ArrayList;

public class HousingListing {
	
    private String listingID;
    private String listingTitle;
    private String address;
    private String zipcode;
    private String billingAddress;
    private String description;
    private int rating;
    private int ratingCount;
    private double distance;
    private double price;
    private ArrayList<Review> reviews;
    private HousingType housingType;
    private ArrayList<Amenities> amenities;
    private String managerName;
    private int bedrooms;
    private int bathrooms;
    private int availableUnits;
    
    public HousingListing(String listingTitle, String address, String billingAddress, String zipcode, String description, 
			              double distance, double price, HousingType housingType, 
			              ArrayList<Amenities> amenities, String managerName, int bedrooms, int bathrooms,
			              int availableUnits) {
            
        this.listingTitle = listingTitle;
        this.address = address;
        this.billingAddress = billingAddress;
        this.zipcode = zipcode;
        this.description = description;
        this.distance = distance;
        this.price = price;
        this.housingType = housingType;
        this.amenities = amenities;
        this.managerName = managerName;
        this.bedrooms =  bedrooms;
        this.bathrooms = bathrooms;
        this.availableUnits = availableUnits;
	}
    
	
    public String getListingID() {
	return this.listingID;
    }
	
    public void setListingID(String id) {
	this.listingID = id;
    }
    public String getListingTitle() {
        return this.listingTitle;
    }
	
    public void setListingTitle(String title) {
	this.listingTitle = title;
    }
	
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
    	this.address = address;
  
    }
    
    public void setZip(String zipcode) {
    	this.zipcode = zipcode;
    }
    
    public String getZip() {
    	return this.zipcode;
    }
    
    public String getPaymentAddress() {
    	return this.billingAddress;
    }
    
    public void setBillingAddress(String address) {
    	
    }
	
    public void setManagerName(String firstName, String lastName) {
    	this.managerName = firstName + " " + lastName;
    }
    
    public String getManagerName() {
    	return this.managerName;
    }
    
    public String getDescription() {
        return this.description;
    }
	
    public void setDescription(String description) {
    	this.description = description;	
    }
	
    public int getRating() {
        return (int) rating;
    }
	
    public void setRating(int rating) {
    	this.rating = rating;	
    }
	
    public int getRatingCount() {
        return (int) ratingCount;
    }
	
    public void setRatingCount(int ratingCount) {
    	this.ratingCount = ratingCount;
    }
    
    public double getDistance() {
        return this.distance;
    }
	
    public double getPrice() {
        return price;
    }
	
    public void setPrice(double price) {
    	this.price = price;	
    }
    
    public void setBedrooms(int bedrooms) {
    	this.bedrooms = bedrooms;
    }
    
    public int getBedrooms() {
    	return this.bedrooms;
    }
    
    public void setBathrooms(int bathrooms) {
    	this.bathrooms = bathrooms;
    }
    
    public int getBathrooms() {
    	return this.bathrooms;
    }
    
    public int getAvailableUnits() {
    	return this.availableUnits;
    }
    
    public void setAvailableUnits(int availableUnits) {
    	this.availableUnits = availableUnits;
    }
    
    public HousingType getHousingType() {
    	return this.housingType;
    }
	
    public ArrayList<Review> getReviews() {
        ArrayList<Review> reviews = new ArrayList<Review>();
        return reviews;
    }
	
    public void addReview(Review review) {
    	this.reviews.add(review);
    }
    
    public String getHousingTypeString() {
    	return this.housingType.name();
    }
    
    public ArrayList<Amenities> getAmenities() {
        return this.amenities;
    }
    
    public ArrayList<String> getAmenitiesString() {
    	ArrayList<String> amenitiesList = new ArrayList<String>();
    	
    	for(int i = 0; i < this.amenities.size(); ++i) {
    		amenitiesList.add(this.amenities.get(i).name());
    	}
    	
    	return amenitiesList;
    }
    
    public void setAmenities(ArrayList<Amenities> amenities) {
    	this.amenities = amenities;
    }
    
    public void addAmenity(Amenities amenity) {
    	this.amenities.add(amenity);
    }
	
    public String toString() {
    	return "\n----------\n" + "Listing ID: " + this.listingID +"\n"
                + this.listingTitle + "\n" + this.address + "\nZipcode: " + this.zipcode +
                "\nProperty Manager: " + this.managerName +
    			"\n$" + this.price + " per month\n" + this.distance + " miles from campus\n" +
    			"Type of housing: " + this.housingType.name() + "\nNumber of bedrooms: " + this.bedrooms +
    			"\nNumber of Bathrooms: " + this.bathrooms + "\nAvailable units: " + this.availableUnits +
    			"\nAmenities: " + this.amenities.toString().join(", ", amenities.toString()) +
    			"\n" + this.description + "\n----------\n";
    }
	
}