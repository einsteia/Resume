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
* DataLoader Tester. 
* 
* @author <Authors name> 
* @since <pre>11/ 15, 2020</pre>
* @version 1.0 
*/ 
public class DataLoaderTest{ 

    private Users students = Users.getInstance();
    //private ArrayList<StudentUser> studentList = Users.getStudent();
    
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
   /**
    studentList.clear();
    studentList.add(lastName, firstName, age, phone number);
    studentList.add(same as line above (whatever order you have this method as));
    DataWriter.saveStudents();
    **/
} 

public void tearDown() {
    /**
    Users.getInstance().getStudent.clear();
    DataWriter.saveStudent();
    **/
    
}
/** 
* 
* Method: loadStudents() 
* 
*/ 
@Test
public void testLoadStudents() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: loadLeasers() 
* 
*/ 
@Test
public void testLoadLeasers() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: loadListings() 
* 
*/ 
@Test
public void testLoadListings() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getHousingType(String housingType) 
* 
*/ 

@Test
public void testLoadReviews() throws Exception { 
//TODO: Test goes here... 
} 


/** 
* 
* Method: mapStudentFavorites(StudentUser student, ArrayList<String> favoriteIDs, HousingListings housingListings) 
* 
*/ 
@Test
public void testMapStudentFavorites() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = DataLoader.getClass().getMethod("mapStudentFavorites", StudentUser.class, ArrayList<String>.class, HousingListings.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: mapLeaserProperties(LeasingUser leaser, ArrayList<String> propertyIDs, HousingListings housingListings) 
* 
*/ 
@Test
public void testMapLeaserProperties() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = DataLoader.getClass().getMethod("mapLeaserProperties", LeasingUser.class, ArrayList<String>.class, HousingListings.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: mapListingReviews(HousingListing listing, String listingID) 
* 
*/ 
@Test
public void testMapListingReviews() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = DataLoader.getClass().getMethod("mapListingReviews", HousingListing.class, String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 