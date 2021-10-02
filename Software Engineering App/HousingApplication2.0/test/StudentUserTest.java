/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 
import housingapplication2.pkg0.StudentUser;
import housingapplication2.pkg0.HousingListing;
import housingapplication2.pkg0.HousingType;
import housingapplication2.pkg0.Amenities;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

/** 
* StudentUser Tester. 
* 
* @author <Authors name> 
* @since <pre>11/ 15, 2020</pre>
* @version 1.0 
*/ 
public class StudentUserTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: addFavorites(HousingListing listing) 
* 
*/ 
@Test
public void testAddFavorites() throws Exception { 
    StudentUser testUser = new StudentUser("id", "first", "last", "user", "pass", "phone", "email");
    ArrayList<Amenities> list = new ArrayList<>();
    HousingListing testListing = new HousingListing("title", "add", "bill", "zip",
                                                    "desc", 12, 12, HousingType.HOUSE, list, "name", 4, 4, 4);
    testUser.addFavorites(testListing);
} 

/** 
* 
* Method: getFavorites() 
* 
*/ 
@Test
public void testGetFavorites() throws Exception { 
    StudentUser testUser = new StudentUser("id", "first", "last", "user", "pass", "phone", "email");
    ArrayList<Amenities> list = new ArrayList<>();
    HousingListing testListing = new HousingListing("title", "add", "bill", "zip",
                                                    "desc", 12, 12, HousingType.HOUSE, list, "name", 4, 4, 4);
    testUser.addFavorites(testListing);
    testUser.getFavorites();
    
} 

/** 
* 
* Method: getFavoriteIDs() 
* 
*/ 
@Test
public void testGetFavoriteIDs() throws Exception { 
    StudentUser testUser = new StudentUser("id", "first", "last", "user", "pass", "phone", "email");
    ArrayList<Amenities> list = new ArrayList<>();
    HousingListing testListing = new HousingListing("title", "add", "bill", "zip",
                                                    "desc", 12, 12, HousingType.HOUSE, list, "name", 4, 4, 4);
    testUser.addFavorites(testListing);
    testUser.getFavoriteIDs();
} 

/** 
* 
* Method: setRatingInfo(int rating, int ratingCount) 
* 
*/ 
@Test
public void testSetRatingInfo() throws Exception { 
    StudentUser testUser = new StudentUser("id", "first", "last", "user", "pass", "phone", "email");
    testUser.setRatingInfo(8, 7);
    assertEquals(testUser.getRating(), 8);
    assertEquals(testUser.getRatingCount(), 7);
} 

/** 
* 
* Method: getStudentID() 
* 
*/ 
@Test
public void testGetStudentID() throws Exception { 
    StudentUser testUser = new StudentUser("id", "first", "last", "user", "pass", "phone", "email");
    assertEquals(testUser.getStudentID(), "id");
} 

/** 
* 
* Method: toString() 
* 
*/ 
@Test
public void testToString() throws Exception { 
    StudentUser testUser = new StudentUser("id", "first", "last", "user", "pass", "phone", "email");
    assertEquals(testUser.toString(), "first last\nuserid\nphone");
} 


} 
