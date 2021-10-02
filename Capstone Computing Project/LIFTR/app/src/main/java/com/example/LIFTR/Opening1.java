package com.example.LIFTR;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Opening1 extends AppCompatActivity {
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String USER_AGE = "age";
    public static final String USER_NAME = "name";
    public static final String USER_HEIGHT = "height";
    public static final String USER_WEIGHT = "weight";
    public static final String USER_TYPE = "type";
    public static final String USER_GOAL = "goal";
    public static final String USER_FITNESS = "fitness";
    public static final String USER_SEX = "sex";
    public static final String USER_INIT = "init";
    public static final String USER_TRACKER = "tracker";
    private Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening1);
        loadData();
        if (user.init == true)
            openMain();
        button1 = (Button) findViewById(R.id.start1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOpening2();
            }
        });
    }

    public void openOpening2(){
        Intent intent = new Intent(this, Opening2.class);
        startActivity(intent);
    }
    public void openMain(){
        Intent intent = new Intent(this, HomeScreen1.class);
        startActivity(intent);
    }
    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        user.setAge(sharedPreferences.getInt(USER_AGE, 0));
        user.setHeight(sharedPreferences.getInt(USER_HEIGHT, 0));
        user.setWeight(sharedPreferences.getInt(USER_WEIGHT, 0));
        user.setType(sharedPreferences.getString(USER_TYPE, ""));
        user.setFitness(sharedPreferences.getString(USER_FITNESS, ""));
        user.setSex(sharedPreferences.getString(USER_SEX, ""));
        user.setGoal(sharedPreferences.getString(USER_GOAL, ""));
        user.setName(sharedPreferences.getString(USER_NAME, ""));
        user.init = (sharedPreferences.getBoolean(USER_INIT, false));
        //Set<String> set = sharedPreferences.getStringSet(USER_TRACKER, null);
        //List<Food> stuff = new ArrayList<>(set);
        //user.tracker.addAll(set)
    }
}
