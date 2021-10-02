package com.example.LIFTR;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Button updateStuff;
    private Button cancelStuff;
    private Button fitnessSettings;
    private EditText theName;
    private Spinner theSex;
    private EditText theAge;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("LIFTR");
        toolbar.setTitleTextColor(Color.WHITE);

        updateStuff = (Button) findViewById(R.id.updatee);
        cancelStuff = (Button) findViewById(R.id.cancele);
        fitnessSettings = (Button) findViewById(R.id.fitnesse);
        theName = (EditText) findViewById(R.id.theNamee);
        theSex = (Spinner) findViewById(R.id.sexQe);
        theAge = (EditText) findViewById(R.id.theAgee);

        updateStuff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateSettings();
            }
        });
        cancelStuff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelSettings();
            }
        });
        fitnessSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fitnessSettings();
            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sexOptions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        theSex.setAdapter(adapter);
        theSex.setOnItemSelectedListener(this);

        theName.setText(user.getName());
        if (user.getSex().equals("Male"))
            theSex.setSelection(0);
        else if (user.getSex().equals("Female"))
            theSex.setSelection(1);
        else
            theSex.setSelection(2);
        theAge.setText(String.valueOf(user.getAge()));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.home_menu:
                Intent home_intent = new Intent(MainActivity.this, HomeScreen1.class);
                startActivity(home_intent);
                return true;

            case R.id.nutrition_menu:
                Intent nutr_intent = new Intent(MainActivity.this, ETestActivity.class);
                startActivity(nutr_intent);
                return true;

            case R.id.workout_menu:
                Intent work_intent = new Intent(MainActivity.this, Workout.class);
                startActivity(work_intent);
                return true;

            case R.id.settings_menu:
                Intent settings_intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(settings_intent);
                return true;


            default: return super.onOptionsItemSelected(item);
        }
    }

    public void updateSettings() {
        if(theName.getText().toString().equals(""))
            Toast.makeText(getBaseContext(), "Please enter a name.", Toast.LENGTH_LONG).show();
        else if (theAge.getText().toString().equals("") || Integer.parseInt(theAge.getText().toString()) < 12 || Integer.parseInt(theAge.getText().toString()) > 110)
            Toast.makeText(getBaseContext(), "Please enter a valid age.", Toast.LENGTH_LONG).show();
        else {
            user.setName(theName.getText().toString());
            user.setSex(theSex.getSelectedItem().toString());
            user.setAge(Integer.parseInt(theAge.getText().toString()));
            saveData();
            Toast.makeText(this, "Data Saved!", Toast.LENGTH_SHORT).show();
        }
    }
    public void cancelSettings() {
            Intent intent = new Intent(this, com.example.LIFTR.HomeScreen1.class);
            startActivity(intent);
    }
    public void fitnessSettings() {
        if(theName.getText().toString().equals(""))
            Toast.makeText(getBaseContext(), "Please enter a name.", Toast.LENGTH_LONG).show();
        else if (theAge.getText().toString().equals("") || Integer.parseInt(theAge.getText().toString()) < 12 || Integer.parseInt(theAge.getText().toString()) > 110)
            Toast.makeText(getBaseContext(), "Please enter a valid age.", Toast.LENGTH_LONG).show();
        else {
            user.setName(theName.getText().toString());
            user.setSex(theSex.getSelectedItem().toString());
            user.setAge(Integer.parseInt(theAge.getText().toString()));
            Intent intent = new Intent(this, com.example.LIFTR.MyOtherActivity.class);
            startActivity(intent);
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //String text = parent.getItemAtPosition(position).toString();
        //Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(USER_NAME, user.name);
        editor.putInt(USER_AGE, user.age);
        editor.putInt(USER_HEIGHT, user.height);
        editor.putInt(USER_WEIGHT, user.weight);
        editor.putString(USER_FITNESS, user.fitness);
        editor.putString(USER_GOAL, user.goal);
        editor.putString(USER_SEX, user.sex);
        editor.putString(USER_TYPE, user.type);
        editor.putBoolean(USER_INIT, user.init);
        editor.commit();
        editor.apply();
    }

}
