package housingapplication2.pkg0;

import java.util.ArrayList;

public class HousingListings {
	private static HousingListings housingListings;
	private ArrayList<HousingListing> housingListingList;
	
	private HousingListings() {
		housingListingList = DataLoader.loadListings();
	}
	
	public static HousingListings getInstance() {
		if(housingListings == null) {
			housingListings = new HousingListings();
		}
		
		return housingListings;
	}
	
	public HousingListing retreiveByID(String listingID) {
		 for(int i = 0; i < housingListingList.size(); ++i) {
			 if(housingListingList.get(i).getListingID().contains(listingID)) {
				 //System.out.println("There's a match");
				 return housingListingList.get(i);
			 }
		 }
		 return null;
	}
	
	public boolean haveListingName(String listingTitle, int index) {
		if(housingListingList.get(index).getListingTitle().contains(listingTitle)) {
			return true;
		}
		
		return false;
	}
	
	public boolean haveListingType(HousingType housingType, int index) {
		if(housingListingList.get(index).getHousingType().equals(housingType)) {
			return true;
		}
		
		return false;
	}
	
	public boolean haveListingUnderPrice(double price, int index) {
		if(this.housingListingList.get(index).getPrice() <= price) {
			return true;
		}
		return false;
	}
	
	public boolean haveListingBathrooms(int numOfBathrooms, int index) {
		if(this.housingListingList.get(index).getBathrooms() == numOfBathrooms) {
			return true;
		}
		return false;
	}
	
	public boolean haveListingBedrooms(int numOfBedrooms, int index) {
		if(this.housingListingList.get(index).getBedrooms() == numOfBedrooms) {
			return true;
		}
		return false;
	}
	
	public boolean haveListingsUnderDistance(double distance, int index) {
		if(this.housingListingList.get(index).getDistance() <= distance) {
			return true;
		}
		return false;
	}
	
	public boolean hasListingAmenities(ArrayList<Amenities> amenities, int index) {
		ArrayList<Amenities> compareList = this.housingListingList.get(index).getAmenities();
		
		if(compareList.containsAll(amenities)) {
			return true;
		}
		
		return false;
	}
	
	public HousingListing getListing(String listingTitle) {
		return null;
	}
	
	public String generateListingID() {
		String newID = String.valueOf(housingListingList.size());
		return newID;
	}
	
	public void addListing(HousingListing listing) {
		housingListingList.add(listing);
	}
	
	public void removeListing(HousingListing listing) {
		housingListingList.remove(listing);
	}
	
	public ArrayList<HousingListing> getAllListings() {
		return this.housingListingList;
	}
	
	public HousingListing getNewestListing() {
		return this.housingListingList.get(this.housingListingList.size()-1);
	}
	
	public HousingListing getListingByID(String id) {
		for(int i = 0; i < this.housingListingList.size(); ++i) {
			if(this.housingListingList.get(i).getListingID().contentEquals(id)) {
				return this.housingListingList.get(i);
			}
		}
		
		return null;
	}
	
	/**
	 * Main HousingListings search algorithm.
	 * @param housingType the type of property for the listing; HousingType
	 * @param amenities List of amenities to be searched for; Amenities
	 * @param numberOfBedrooms Number of bedrooms desired; int
	 * @param numberOfBathrooms Number of bathrooms desired; int
	 * @param price Ceiling of prices to be searched; double
	 * @param maxDistance Ceiling of distance to be searched, double
	 * @return
	 */
	public ArrayList<HousingListing> housingSearch(HousingType housingType, ArrayList<Amenities> amenities,
			                                       int numberOfBedrooms, int numberOfBathrooms,
			                                       double price, double maxDistance) {
		ArrayList<HousingListing> results = new ArrayList<HousingListing>();
		boolean housingTypeMatch = true;
		boolean amenitiesMatch = true;
		boolean priceMatch = true;
		boolean bedroomMatch = true;
		boolean bathroomMatch = true;
		boolean distanceMatch = true;
		
		// Housing Type Search
		if(housingType != null) {
			for(int i = 0; i < this.housingListingList.size(); ++i) {
				if(this.haveListingType(housingType, i)) {
					results.add(this.housingListingList.get(i));
				}
			}
			if(results.isEmpty()) {
				housingTypeMatch = false;
			}
		}
		if(!housingTypeMatch) {
			return results;
		}
		// Price Search
		if(price != 0) {
			if(results.isEmpty()) {
				for(int i = 0; i < this.housingListingList.size(); ++i) {
					if(this.haveListingUnderPrice(price, i)) {
						results.add(this.housingListingList.get(i));
					}
				}
				if(results.isEmpty()) {
					priceMatch = false;
				}
			} else {
				for(int i = 0; i < results.size(); ++i) {
					if(results.get(i).getPrice() <= price) {
						continue;
					} else {
						results.remove(i);
						--i;
					}
				}
			}
			
			if(results.isEmpty()) {
				priceMatch = false;
			}
		}
	
		if(!priceMatch) {
			return results;
		}
		// Distance Search
		
		if(maxDistance != 0) {
			if(results.isEmpty()) {
				for(int i = 0; i < this.housingListingList.size(); ++i) {
					if(this.haveListingsUnderDistance(maxDistance, i)) {
						results.add(this.housingListingList.get(i));
					}
				}
				if(results.isEmpty()) {
					distanceMatch = false;
				}
			} else {
				for(int i = 0; i < results.size(); ++i) {
					if(results.get(i).getDistance() <= maxDistance) {
						continue;
					} else {
						results.remove(i);
						--i;
					}
				}
			}
			
			if(results.isEmpty()) {
				distanceMatch = false;
			}
		}
	
		if(!distanceMatch) {
			return results;
		}
		// Bedrooms Search
		if(numberOfBedrooms != 0) {
			if(results.isEmpty()) {
				for(int i = 0; i < this.housingListingList.size(); ++i) {
					if(this.haveListingBedrooms(numberOfBedrooms, i)) {
						results.add(this.housingListingList.get(i));
					}
				}
				if(results.isEmpty()) {
					bedroomMatch = false;
				}
			} else {
				for(int i = 0; i < results.size(); ++i) {
					if(results.get(i).getBedrooms() == numberOfBedrooms) {
						continue;
					} else {
						results.remove(i);
						--i;
					}
				}
			}
			
			if(results.isEmpty()) {
				bedroomMatch = false;
			}
		}
	
		if(!bedroomMatch) {
			return results;
		}
		// Bathrooms Search
		if(numberOfBathrooms != 0) {
			if(results.isEmpty()) {
				for(int i = 0; i < this.housingListingList.size(); ++i) {
					if(this.haveListingBathrooms(numberOfBathrooms, i)) {
						results.add(this.housingListingList.get(i));
					}
				}
				if(results.isEmpty()) {
					bathroomMatch = false;
				}
			} else {
				for(int i = 0; i < results.size(); ++i) {
					if(results.get(i).getBathrooms() == numberOfBathrooms) {
						continue;
					} else {
						results.remove(i);
						--i;
					}
				}
			}
			
			if(results.isEmpty()) {
				bathroomMatch = false;
			}
		}
	
		if(!bathroomMatch) {
			return results;
		}
		// Amenities Search
		if(!amenities.isEmpty()) {
			if(results.isEmpty()) {
				for(int i = 0; i < this.housingListingList.size(); ++i) {
					if(this.hasListingAmenities(amenities, i)) {
						results.add(this.housingListingList.get(i));
					}
				}
				if(results.isEmpty()) {
					amenitiesMatch = false;
				}
			} else {
				for(int i = 0; i < results.size(); ++i) {
					if(results.get(i).getAmenities().containsAll(amenities)) {
						continue;
					} else {
						results.remove(i);
						--i;
					}
				}
			}
			
			if(results.isEmpty()) {
				amenitiesMatch = false;
			}
		}
	
		if(!amenitiesMatch) {
			return results;
		}
		
		return results;
	}
	
	public void saveListings() {
		DataWriter.saveHousingListings();
	}
}