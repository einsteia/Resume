package com.example.LIFTR;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    
    @Test
    public void user_isCorrect() {
        user test_user = new user(21, 180, 72, "TestName", "TestType", "TestGoal", "TestFitness", "S");
        String test_string = "Name: TestName\nAge: 21\nSex: S\nHeight: 72\nWeight: 180";
        assertEquals(test_user.toString, test_string);
    }
}
