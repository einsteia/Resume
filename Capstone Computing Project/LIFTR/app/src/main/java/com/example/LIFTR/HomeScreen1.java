package com.example.LIFTR;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuInflater;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class HomeScreen1 extends AppCompatActivity {

    ArrayList<Food> foodList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("LIFTR");
        toolbar.setTitleTextColor(Color.WHITE);
        TextView welcome;
        welcome = findViewById(R.id.textViewJT6);
        welcome.setText("Hello, " + user.getName() + "!");
        TextView calGoal;
        TextView calBurn;
        calGoal = findViewById((R.id.textViewCalGoal));
        calBurn = findViewById((R.id.textViewCalBurn));
        int calRet = (int) Math.round(user.calculateCalories());
        int calBurnRet = (int) Math.round(user.calculateBurn());
        calGoal.setText(Integer.toString(calRet));
        calBurn.setText(Integer.toString(calBurnRet));
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home_menu:
                Intent home_intent = new Intent(HomeScreen1.this, HomeScreen1.class);
                startActivity(home_intent);
                return true;

            case R.id.nutrition_menu:
                Intent nutr_intent = new Intent(HomeScreen1.this, ETestActivity.class);
                startActivity(nutr_intent);
                return true;

            case R.id.workout_menu:
                Intent work_intent = new Intent(HomeScreen1.this, Workout.class);
                startActivity(work_intent);
                return true;

            case R.id.settings_menu:
                Intent settings_intent = new Intent(HomeScreen1.this, MainActivity.class);
                startActivity(settings_intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void goToNat(View view) {
        Intent intent = new Intent(this, adamMainActivity.class);
        startActivity(intent);
    }

    public void goToTrack(View view) {
        Intent intent = new Intent(this, ETestActivity.class);
        startActivity(intent);
    }

    public void goToWorkout(View view) {
        Intent intent = new Intent(this, Workout.class);
        startActivity(intent);
    }

    public void goToSetting(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void goToFoodList (View view){
        Intent intent = new Intent (this, FoodListMain.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("foodList", (Serializable) foodList);
        intent.putExtra("BUNDLE", bundle);
        startActivity(intent);
    }
    public void gotoAddFood (View view) {
        Intent intent = new Intent(this, AddFood.class);
        startActivity(intent);
    }
}

