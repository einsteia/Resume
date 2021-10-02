package com.example.LIFTR;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Opening4 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Button start2;
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
        setContentView(R.layout.activity_opening4);


        theGoal = (Spinner) findViewById(R.id.goalQ);
        start2 = (Button) findViewById(R.id.start2);
        start2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain();
            }
        });

        Spinner goalQ = findViewById(R.id.goalQ);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.goalOptions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        goalQ.setAdapter(adapter);
        goalQ.setOnItemSelectedListener(this);
        
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //String text = parent.getItemAtPosition(position).toString();
        //Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void openMain(){
        user.setGoal(theGoal.getSelectedItem().toString());
        user.init = true;
        saveData();
        Intent intent = new Intent(this, HomeScreen1.class);
        startActivity(intent);
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
