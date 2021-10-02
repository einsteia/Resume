/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 
import java.util.ArrayList;
import housingapplication2.pkg0.Users;
import housingapplication2.pkg0.StudentUser;
import static org.junit.Assert.*;
import housingapplication2.pkg0.LeasingUser;
/** 
* Users Tester. 
* 
* @author <Authors name> 
* @since <pre>11/ 15, 2020</pre>
* @version 1.0 
*/ 
public class UsersTest { 

    
    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: addStudent(StudentUser student) 
    * 
    */ 
    @Test
    public void testAddStudent() throws Exception { 
        System.out.println("addStudent");
        StudentUser testUser = new StudentUser("id", "first", "last", "user", "pass", "phone", "email");
        Users instance = Users.getInstance();
        instance.addStudent(testUser);
    } 

    /** 
    * 
    * Method: haveStudent(String username, int index) 
    * 
    */ 
    @Test
    public void testHaveStudent() throws Exception { 
        System.out.println("haveStudent");
        StudentUser testUser = new StudentUser("id", "first", "last", "user", "pass", "phone", "email");
        Users instance = Users.getInstance();
        instance.addStudent(testUser);
        assertEquals(instance.haveStudent("user", 0), true);
    } 

    /** 
    * 
    * Method: studentLogin(String username, String password) 
    * 
    */ 
    @Test
    public void testStudentLogin() throws Exception { 
        System.out.println("studentLogin");
        StudentUser testUser = new StudentUser("id", "first", "last", "user", "pass", "phone", "email");
        Users instance = Users.getInstance();
        instance.addStudent(testUser);
        assertEquals(instance.studentLogin("user", "pass"), true);
    }

    /** 
    * 
    * Method: haveLeaser(String username, int index) 
    * 
    */ 
    @Test
    public void testHaveLeaser() throws Exception { 
        System.out.println("haveLeaser");
        LeasingUser testUser = new LeasingUser("first", "last", "user", "pass", "phone", "email", "add");
        Users instance = Users.getInstance();
        instance.addLeaser(testUser);
        assertEquals(instance.haveLeaser("user", 0), true);
    }

    /** 
    * 
    * Method: addLeaser(LeasingUser leaser) 
    * 
    */ 
    @Test
    public void testAddLeaser() throws Exception { 
        System.out.println("haveLeaser");
        LeasingUser testUser = new LeasingUser("first", "last", "user", "pass", "phone", "email", "add");
        Users instance = Users.getInstance();
        instance.addLeaser(testUser);
    } 

    /** 
    * 
    * Method: leaserLogin(String username, String password) 
    * 
    */ 
    @Test
    public void testLeaserLogin() throws Exception { 
        System.out.println("haveLeaser");
        LeasingUser testUser = new LeasingUser("first", "last", "user", "pass", "phone", "email", "add");
        Users instance = Users.getInstance();
        instance.addLeaser(testUser);
        assertEquals(instance.leaserLogin("user", "pass"), true);
    }

} 