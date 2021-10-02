/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 
import housingapplication2.pkg0.Review;
import housingapplication2.pkg0.Reviews;
import static org.junit.Assert.*;
import java.util.ArrayList;

/** 
* Reviews Tester. 
* 
* @author <Authors name> 
* @since <pre>11/ 15, 2020</pre>
* @version 1.0 
*/ 
public class ReviewsTest { 

    
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getInstance() 
* 
*/ 
@Test
public void testGetInstance() throws Exception { 
    Reviews instance = Reviews.getInstance();
} 

/** 
* 
* Method: getReviewList() 
* 
*/ 
@Test
public void testGetReviewList() throws Exception { 
    ArrayList<Review> testList = new ArrayList<>();
    Review testReview = new Review("author", 8, "comment", "id");
    testList.add(testReview);
    Reviews instance = Reviews.getInstance();
    assertEquals(instance.getReviewList(), testList);
} 

/** 
* 
* Method: getReviews(String listingID) 
* 
*/ 
@Test
public void testGetReviews() throws Exception { 
    ArrayList<Review> testList = new ArrayList<>();
    Review testReview = new Review("author", 8, "comment", "id");
    testList.add(testReview);
    Reviews instance = Reviews.getInstance();
    assertEquals(instance.getReviews("id"), testReview);
} 

/** 
* 
* Method: saveReviews() 
* 
*/ 
@Test
public void testSaveReviews() throws Exception { 
    Reviews instance = Reviews.getInstance();
    instance.saveReviews();
} 


} 
