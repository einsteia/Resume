package com.example.LIFTR;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class adamMainActivity extends AppCompatActivity {
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String USER_TRACKER = "tracker";
    String foodName;
    int serving;

    EditText Input1;
    EditText Input2;
    ListView show;

    Button submit;
    Button gotoList;

  //  ArrayList<String> tracker = new ArrayList<String>();
  //  ArrayList<Food> foodList = new ArrayList<Food>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adam_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("LIFTR");
        toolbar.setTitleTextColor(Color.WHITE);

        Input1 = (EditText) findViewById(R.id.ae_Input1);
        Input2 = (EditText) findViewById(R.id.ae_Input2);
        show = (ListView) findViewById(R.id.tracker);
        gotoList = (Button) findViewById(R.id.ae_button1);

        submit = (Button) findViewById(R.id.ae_button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = Input1.getText().toString();
                String getServing = Input2.getText().toString();

                foodName = Input1.getText().toString();
                serving = Integer.valueOf(Input2.getText().toString());

                if (user.tracker.contains(getInput)) {
                    Toast.makeText(getBaseContext(), "Are you sure you want to add this food again?", Toast.LENGTH_LONG).show();
                } else if (getInput == null || getInput.trim().equals("")) {
                    Toast.makeText(getBaseContext(), "Please enter food name", Toast.LENGTH_LONG).show();
                } else {
                    user.tracker.add(getInput);
                    user.tracker.add(getServing);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(adamMainActivity.this, android.R.layout.simple_list_item_1, user.tracker);
                    show.setAdapter(adapter);
                    ((EditText) findViewById(R.id.ae_Input1)).setText(" ");
                    saveData();
                    gotoHome(v);
                }
            }
        });
    }

    public void gotoFoodList(View view) {
        Intent currentIntent = this.getIntent();
        Bundle currentBundle = currentIntent.getBundleExtra(("BUNDLE"));
        if (currentBundle != null) {
            user.foodList = (ArrayList<Food>) currentBundle.getSerializable(("foodList"));
        }

        Intent intent = new Intent(this, FoodListMain.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("foodList", (Serializable) user.foodList);
        intent.putExtra("BUNDLE", bundle);
        startActivity(intent);
    }





    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.home_menu:
                Intent home_intent = new Intent(adamMainActivity.this, HomeScreen1.class);
                startActivity(home_intent);
                return true;

            case R.id.nutrition_menu:
                Intent nutr_intent = new Intent(adamMainActivity.this, ETestActivity.class);
                startActivity(nutr_intent);
                return true;

            case R.id.workout_menu:
                Intent work_intent = new Intent(adamMainActivity.this, Workout.class);
                startActivity(work_intent);
                return true;

            case R.id.settings_menu:
                Intent settings_intent = new Intent(adamMainActivity.this, MainActivity.class);
                startActivity(settings_intent);
                return true;


            default: return super.onOptionsItemSelected(item);
        }
    }

    public void gotoHome (View view){
        Intent currentIntent = this.getIntent();
        Bundle currentBundle = currentIntent.getBundleExtra(("BUNDLE"));
        if (currentBundle != null) {
            user.tracker = (ArrayList<String>) currentBundle.getSerializable(("foodList"));
        }
        Intent intent = new Intent(this, HomeScreen1.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("foodList", (Serializable) user.tracker);
        intent.putExtra("BUNDLE", bundle);
        startActivity(intent);
    }
    public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        HashSet<String> set = new HashSet<String>();
        set.addAll(user.tracker);
        editor.putStringSet(USER_TRACKER, set);
        editor.commit();
        editor.apply();
    }
}
