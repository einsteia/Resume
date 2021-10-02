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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Button;

public class MyOtherActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Button cancel;
    private Button updateBut;
    private Button personal;
    EditText theWeight;
    Spinner theFitness;
    EditText theHeight;
    Spinner theBody;
    Spinner theGoal;
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
        setContentView(R.layout.activity_my_other);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("LIFTR");
        toolbar.setTitleTextColor(Color.WHITE);

        theWeight = (EditText) findViewById(R.id.uWeight);
        theFitness = (Spinner) findViewById(R.id.fitnessQQ);
        theHeight = (EditText) findViewById(R.id.uHeight);
        theBody = (Spinner) findViewById(R.id.bodyQQ);
        theGoal = (Spinner) findViewById((R.id.goalQQ));

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.fitnessOptions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        theFitness.setAdapter(adapter);
        theFitness.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.bodyOptions, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        theBody.setAdapter(adapter1);
        theBody.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.goalOptions, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        theGoal.setAdapter(adapter2);
        theGoal.setOnItemSelectedListener(this);

        cancel = (Button) findViewById(R.id.cancell);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMain();
            }
        });

        updateBut = (Button) findViewById(R.id.updateFitness);
        updateBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatess();
            }
        });

        personal = (Button) findViewById(R.id.personalSettings);
        personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPersonal();
            }
        });

        theWeight.setText(String.valueOf(user.getWeight()));
        theHeight.setText(String.valueOf(user.getHeight()));

        if (user.getType().equals("Ectomorph (Smaller muscles in respect to bone)"))
            theBody.setSelection(0);
        else if (user.getType().equals("Mesomorph (Developed athletic musculature)"))
            theBody.setSelection(1);
        else
            theBody.setSelection(2);

        if (user.getGoal().equals("Lose Weight"))
            theGoal.setSelection(0);
        else if (user.getGoal().equals("Maintain Current"))
            theGoal.setSelection(1);
        else
            theGoal.setSelection(2);

        if (user.getFitness().equals("Beginner(maybe once a week, low weights)"))
            theFitness.setSelection(0);
        else if (user.getFitness().equals("Novice(2-3 times a week, low to med weights)"))
            theFitness.setSelection(1);
        else if (user.getFitness().equals("Intermediate(4 times a week)"))
            theFitness.setSelection(2);
        else if (user.getFitness().equals("Advanced(5-6 times a week)"))
            theFitness.setSelection(3);
        else
            theFitness.setSelection(4);
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
                Intent home_intent = new Intent(MyOtherActivity.this, HomeScreen1.class);
                startActivity(home_intent);
                return true;

            case R.id.nutrition_menu:
                Intent nutr_intent = new Intent(MyOtherActivity.this, ETestActivity.class);
                startActivity(nutr_intent);
                return true;

            case R.id.workout_menu:
                Intent work_intent = new Intent(MyOtherActivity.this, Workout.class);
                startActivity(work_intent);
                return true;

            case R.id.settings_menu:
                Intent settings_intent = new Intent(MyOtherActivity.this, MainActivity.class);
                startActivity(settings_intent);
                return true;

            default: return super.onOptionsItemSelected(item);
        }
    }

    public void goToMain(){
        Intent intent = new Intent(this, com.example.LIFTR.HomeScreen1.class);
        startActivity(intent);
    }
    public void goToPersonal(){
        boolean valid_weight = true;
        boolean valid_height = true;
        try{
            int temp_w = Integer.parseInt(theWeight.getText().toString());
            if(temp_w < 10 || temp_w > 1500) {
                valid_weight = false;
            }
        }
        catch(NumberFormatException e) {
            valid_weight = false;
        }
        try{
            int temp_h = Integer.parseInt(theHeight.getText().toString());
            if(temp_h < 24 || temp_h > 108) {
                valid_height = false;
            }
        }
        catch(NumberFormatException e) {
            valid_height = false;
        }
        if(theWeight.getText().toString().equals("") || !valid_weight)
            Toast.makeText(getBaseContext(), "Please enter a valid weight.", Toast.LENGTH_LONG).show();
        else if (theHeight.getText().toString().equals("") || !valid_height)
            Toast.makeText(getBaseContext(), "Please enter a valid height.", Toast.LENGTH_LONG).show();
        else {
            user.setFitness(theFitness.getSelectedItem().toString());
            user.setHeight(Integer.parseInt(theHeight.getText().toString()));
            user.setWeight(Integer.parseInt(theWeight.getText().toString()));
            user.setType(theBody.getSelectedItem().toString());
            user.setGoal(theGoal.getSelectedItem().toString());
            saveData();
            Intent intent = new Intent(this, com.example.LIFTR.MainActivity.class);
            startActivity(intent);
        }
    }
    public void updatess(){
        boolean valid_weight = true;
        boolean valid_height = true;
        try{
            int temp = Integer.parseInt(theWeight.getText().toString());
            if(temp < 10 || temp > 1500) {
                valid_weight = false;
            }
        }
        catch(NumberFormatException e) {
            valid_weight = false;
        }
        try{
            int temp_h = Integer.parseInt(theHeight.getText().toString());
            if(temp_h < 24 || temp_h > 108) {
                valid_height = false;
            }
        }
        catch(NumberFormatException e) {
            valid_height = false;
        }
        if(theWeight.getText().toString().equals("") || !valid_weight)
            Toast.makeText(getBaseContext(), "Please enter a valid weight.", Toast.LENGTH_LONG).show();
        else if (theHeight.getText().toString().equals("") || !valid_height)
            Toast.makeText(getBaseContext(), "Please enter a valid height.", Toast.LENGTH_LONG).show();
        else {
            user.setFitness(theFitness.getSelectedItem().toString());
            user.setHeight(Integer.parseInt(theHeight.getText().toString()));
            user.setWeight(Integer.parseInt(theWeight.getText().toString()));
            user.setType(theBody.getSelectedItem().toString());
            user.setGoal(theGoal.getSelectedItem().toString());
            saveData();
            Toast.makeText(this, "Data Saved!", Toast.LENGTH_SHORT).show();

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
