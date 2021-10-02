package housingapplication2.pkg0;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LeaseAgreement {
	private static final String FILE_READER_NAME = "src/leaseAgreement.txt";
	private static final String FILE_WRITE_NAME = "newLease.txt";
	private static final String DATE = "<DATE>";
	private static final String LANDLORD = "<LANDLOARD>";
	private static final String TENANTS = "<TENANT(s)>";
	private static final String BEDS = "<NUM_BED>";
	private static final String BATHS = "<NUM_BATH>";
	private static final String PROPERTY_ADDRESS = "<PROPERTY_ADDRESS>";
	private static final String ZIP = "<ZIP>";
	private static final String START_DATE = "<START DATE>";
	private static final String END_DATE = "<END DATE>";
	private static final String RENT = "<RENT>";
	private static final String PAYMENT_ADDRESS = "<PAYMENT ADDRESS>";
	private static final String DAMAGE_COST = "<DAMAGE COST>";
	private static final String FIRST_TENANT = "<TENANT 1>";
	private static final String SECOND_TENANT = "TENANT X";
	
	
	private String firstTenant = "";
	private String secondTenant = "";
	private String landlord;
	private String propertyAddress = "";
	private String paymentAddress = "";
	private int num_bed;
	private int num_bath;
	private String sczip;
	private String currentDate;
    private String startdate;
    private String endDate;
    private double rent;
	private double damage = 3000.00;

	public LeaseAgreement(String tenant1, String tenant2, HousingListing housingListing, 
			              String currentDate, String startDate, String endDate) {
		this.firstTenant = tenant1;
		this.secondTenant = tenant2;
		this.landlord = housingListing.getManagerName();
		this.propertyAddress = housingListing.getAddress();
		this.paymentAddress = housingListing.getPaymentAddress();
		this.num_bed = housingListing.getBedrooms();
		this.num_bath = housingListing.getBathrooms();
		this.sczip = housingListing.getZip();
		this.currentDate = currentDate;
		this.startdate = startDate;
		this.endDate = endDate;
		this.rent = housingListing.getPrice();
	}
	
	public void generateLeaseAgreement() {
		File oglease = new File(FILE_READER_NAME);
		String oldLease = "";
		BufferedReader reader = null;
		FileWriter writer = null;
		
		try {
		reader = new BufferedReader(new FileReader(oglease));
		
		writer = new FileWriter(FILE_WRITE_NAME);
		String line = reader.readLine();
		while(line != null) {
			oldLease = oldLease + line + System.lineSeparator();
	
			line = reader.readLine();
		}
		
		String newLease = fillLease(oldLease);
		
		writer.write(newLease);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private String fillLease(String oldLease) {
		oldLease = oldLease.replace("CURRDATE", this.currentDate);
		oldLease = oldLease.replace("LANDLORD", this.landlord);
		if(this.secondTenant.isEmpty()) {
			oldLease = oldLease.replaceAll("TENANTS", this.firstTenant);
		} else {
			oldLease = oldLease.replaceAll("TENANTS", this.firstTenant + ", " + this.secondTenant);
		}
		oldLease = oldLease.replaceAll("NUM_BED", String.valueOf(this.num_bed));
		oldLease = oldLease.replaceAll("NUM_BATH", String.valueOf(this.num_bath));
		oldLease = oldLease.replaceAll("PROPERTY_ADDRESS", this.propertyAddress);
		oldLease = oldLease.replaceAll("ZIP", this.sczip);
		oldLease = oldLease.replaceAll("START_DATE", this.startdate);
		oldLease = oldLease.replaceAll("END_DATE", this.endDate);
		oldLease = oldLease.replaceAll("RENT", String.valueOf(this.rent));
		oldLease = oldLease.replaceAll("PAYMENT_ADDRESS", this.paymentAddress);
		oldLease = oldLease.replaceAll("DAMAGE_COST", String.valueOf(this.damage));
		oldLease = oldLease.replaceAll(FIRST_TENANT, this.firstTenant);
		oldLease = oldLease.replaceAll(LANDLORD, this.landlord);
		if(this.secondTenant.isEmpty()) {
			oldLease = oldLease.replaceAll(SECOND_TENANT, "");
		} else {
			oldLease = oldLease.replaceAll(SECOND_TENANT, this.secondTenant);
		}
		
		return oldLease;
	}
}