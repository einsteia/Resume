package housingapplication2.pkg0;

public class RegisteredUser extends User {
    	protected String userID;
    	protected String firstName;
    	protected String lastName;
    	protected String username;
    	protected String password;
    	protected String phone;
    	protected String email;
    	protected int rating;
    	protected int ratingCount;
    
	  public String getFirstName() {
		  return this.firstName;
	  }

	  public String getLastName() {
		  return this.lastName;
	  }

	  public String getFullName() {
		  return this.firstName + " " + this.lastName;
	  }
	  
	  public String getUsername() {
		  return this.username;
	  }

	  public String getPassword() {
		  return this.password;
	  }

	  public String getPhone() {
		  return this.phone;
	  }

	  public String getEmail() {
		  return this.email;
	  }

	  public int getRating() {
		  return this.rating;
	  }

	  public int getRatingCount() {
		  return this.ratingCount;
	  }

	  public void setID(String id) {
		  this.userID = id;
	  }

	  public String getID() {
		  return this.userID;
	  }
}