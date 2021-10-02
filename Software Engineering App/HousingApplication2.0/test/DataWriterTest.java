/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import housingapplication2.pkg0.StudentUser;
import housingapplication2.pkg0.Users;
import java.util.ArrayList;
import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import static org.junit.Assert.*; 

/** 
* DataWriter Tester. 
* 
* @author <Authors name> 
* @since <pre>11/ 15, 2020</pre>
* @version 1.0 
*/ 
public class DataWriterTest { 

    private Users students = Users.getInstance();
    //private ArrayList<StudentUser> studentList = Users.getStudent();
    
@After
public void after() throws Exception { 
   /**
    studentList.clear();
    studentList.add(lastName, firstName, age, phone number);
    studentList.add(same as line above (whatever order you have this method as));
    DataWriter.saveStudents();
    **/
} 

public void before() throws Exception {
    
}

public void tearDown() {
    /**
    Users.getInstance().getStudent.clear();
    DataWriter.saveStudent();
    **/
}
/** 
* 
* Method: saveStudents() 
* 
*/ 
@Test
public void testSaveStudents() throws Exception { 
//TODO: Test goes here... 
} 


/** 
* 
* Method: saveLeasers() 
* 
*/ 
@Test
public void testSaveLeasers() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: saveHousingListings() 
* 
*/ 
@Test
public void testSaveHousingListings() throws Exception { 
//TODO: Test goes here... 
} 


/** 
* 
* Method: saveReviews() 
* 
*/ 
@Test
public void testSaveReviews() throws Exception { 
//TODO: Test goes here... 
} 

} 
