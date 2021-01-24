/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletondesignpattern;

import java.util.ArrayList;

/**
 *
 * @author adameinstein
 */
public class HospitalSystem {
    /**
     * Corresponding attributes for HospitalSystem
     */
    private final ArrayList<Patient> patients =new ArrayList<>();
    private static HospitalSystem hospitalSystem;
    /**
     * Privatized constructor for singleton
     */
    private HospitalSystem() {}
    /**
     * @return instance of the class and 
     * uses privatized class constructor for singleton
     * Ensures there are only one hospitalSystem
     */
    public static HospitalSystem getInstance() {
        if (hospitalSystem == null) {
           hospitalSystem = new HospitalSystem();
        }
        return hospitalSystem;
    }
    /**
     * Create a new patient with given first and last name
     * @param firstName
     * @param LastName
     * @return id of patient as it's numerical 
     * representation in the ArrayList
     */
    public int addPatient(String firstName, String LastName) {
       int id =patients.size();
       Patient patient = new Patient(id, firstName, LastName);
       patients.add(patient);
       return id;
    }
    /**
     * @param id
     * @return the patient which corresponds with the given id
     */
    public Patient getRecord(int id) {
       return patients.get(id);   
    }
    /**
     * @param id
     * @param allergy is added to the patient specified by id 
     */
    public void addAllergy(int id, String allergy) {
       Patient patient=patients.get(id);
       patient.addAllergy(allergy);
    }
    /**
     * Utilizes each patients toString()
     * @return a string representation of all the patients data
     * Sending patient file to toString
     */
    public String getAllPatientsData() {
       StringBuilder string = new StringBuilder();
       patients.forEach((patient) -> {
           string.append(patient.toString().replace("[", "").replace("]", "")).append("\n");
        });
       return string.toString();
    }
}