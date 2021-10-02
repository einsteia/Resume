/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletondesignpattern;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author adameinstein
 */
public class Patient {
    /**
     * Corresponding attributes for Patient
     */
    private final int id;
    private final String firstName;
    private final String lastName;
    private final ArrayList<String> allergies = new ArrayList<>();
    /**
     * Constructor
     * @param id
     * @param firstName
     * @param LastName 
     */
    public Patient(int id, String firstName, String LastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = LastName;
    }
    /**
     * Adds an allergy to the ArrayList of allergies
     * @param allergy
     */
    public void addAllergy(String allergy) {
        allergies.add(allergy);
    }
    /**
     * @return the String representation of the patient
     * Note: We display the id as one higher (id+1)
     */
    @Override
    public String toString() {
       String data = allergies.size() > 0 ?("     Allergies: " + allergies):"";
       return "Patient: " + (id + 1) + ": " + firstName + " " + lastName + "\n" + data + "\n";
    }   
}
