package housingapplication2.pkg0;

public class Review {
    private String listingTitle;
    private String author;
    private int rating;
    private String comment;
    private String listingID;
    
    public Review(String author, int rating, String comment, String listingID) {
        this.author = author;
        this.rating = rating;
        this.comment = comment;
        this.listingID = listingID;
    }
    
    public String getListingTitle() {
    	return this.listingTitle;
    }
    
   
    public String getAuthor() {
    	return this.author;
    }
    
    public int getRating() {
        return (int) rating;
    }
    
    public String getComment() {
        return comment;
    }
    
    public void setReviewID(String listingID) {
    	this.listingID = listingID;
    }
    
    public String getReviewID() {
    	return this.listingID;
    }
 
    
    @Override
    public String toString() {
        return "Review by: " + this.author + "\nRating: " + this.rating + "\n" + this.comment;
    }
}