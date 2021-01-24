/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletondesignpattern;

/**
 *
 * @author adameinstein
 */
public class HospitalDriver {

	public void runHospital() {
		HospitalSystem hospital = HospitalSystem.getInstance();
		
		System.out.println("**** Welcome to Our Patient Allergy Tracking System ****\n");
		
		int amyId = hospital.addPatient("Amy", "Smith");
		int billId = hospital.addPatient("Bill", "Clapson");
		int carlId = hospital.addPatient("Carl", "Davidson");
		
		//adding allergies
		hospital.addAllergy(amyId, "Strawberries");
		hospital.addAllergy(amyId, "Mellon");
		hospital.addAllergy(amyId, "Grass");
		hospital.addAllergy(billId, "Bees");
		
		System.out.println("Displaying Patient:\n");		
		System.out.println(hospital.getAllPatientsData());
		
	}

	public static void main(String[] args) {
		HospitalDriver hDriver = new HospitalDriver();
		hDriver.runHospital();
	}
}
