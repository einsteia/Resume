package com.example.LIFTR;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
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

import java.io.Serializable;
import java.util.ArrayList;

public class AddFood extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {

    EditText addFoodName;
    EditText addFoodCal;
    EditText addFoodPro;
    EditText addFoodCarb;
    EditText addFoodFat;
    EditText addFoodSize;
    Button addFoodbutton;
    Button button3;
    Food food;
    Intent foodListIntent;
    Bundle foodListBundle;
    Spinner serveSpin;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("LIFTR");
        toolbar.setTitleTextColor(Color.WHITE);
        foodListIntent = this.getIntent();
        Bundle foodListBundle = foodListIntent.getBundleExtra(("BUNDLE"));
        //foodList = (ArrayList<Food>) foodListBundle.getSerializable(("foodList"));

        addFoodName = (EditText) findViewById(R.id.textFood01);
        addFoodCal = (EditText) findViewById(R.id.textFood02);
        addFoodPro = (EditText) findViewById(R.id.textFood03);
        addFoodCarb = (EditText) findViewById(R.id.textFood04);
        addFoodFat = (EditText) findViewById(R.id.textFood05);
        // Input6 = (EditText) findViewById(R.id.textFood06);
        serveSpin = (Spinner) findViewById(R.id.textFood06);
        addFoodSize = (EditText) findViewById(R.id.textFood07);

        final Spinner serveSpin = findViewById(R.id.textFood06);
        ArrayAdapter<CharSequence> serveAdapter = ArrayAdapter.createFromResource(this, R.array.ServingTypeOptions, android.R.layout.simple_spinner_item);
        serveAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        serveSpin.setAdapter(serveAdapter);
        serveSpin.setOnItemSelectedListener(this);

        addFoodbutton = (Button) findViewById(R.id.AddFoodButton);
        addFoodbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(addFoodName.getText().toString().equals("")) {
                    Toast.makeText(getBaseContext(), "Please enter a valid Food Name.", Toast.LENGTH_LONG).show();
                } else if(addFoodCal.getText().toString().equals("")) {
                        Toast.makeText(getBaseContext(), "Please enter a valid Calorie Value.", Toast.LENGTH_LONG).show();
                } else if(addFoodPro.getText().toString().equals("")) {
                    Toast.makeText(getBaseContext(), "Please enter a valid Protein Value.", Toast.LENGTH_LONG).show();
                } else if(addFoodCarb.getText().toString().equals("")) {
                    Toast.makeText(getBaseContext(), "Please enter a valid Carb Value.", Toast.LENGTH_LONG).show();
                } else if(addFoodFat.getText().toString().equals("")) {
                    Toast.makeText(getBaseContext(), "Please enter a valid Fat Value.", Toast.LENGTH_LONG).show();
                } else if(addFoodSize.getText().toString().equals("")) {
                    Toast.makeText(getBaseContext(), "Please enter a valid Size Value.", Toast.LENGTH_LONG).show();
                } else {
                String getAddFoodName = addFoodName.getText().toString();
                int getAddFoodCal = Integer.parseInt(addFoodCal.getText().toString());
                double getAddFoodPro = Double.parseDouble(addFoodPro.getText().toString());
                double getAddFoodCarb = Double.parseDouble(addFoodCarb.getText().toString());
                double getAddFoodFat = Double.parseDouble(addFoodFat.getText().toString());
                String getAddServeT = serveSpin.getSelectedItem().toString();
                int getFoodSize = Integer.parseInt(addFoodSize.getText().toString());

                Food food = new Food(getAddFoodName, getAddFoodCal, getAddFoodPro,
                                        getAddFoodCarb, getAddFoodFat, getAddServeT, getFoodSize);
                addFood(v, food);
                }
            }
        });
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
                Intent home_intent = new Intent(AddFood.this, HomeScreen1.class);
                startActivity(home_intent);
                return true;

            case R.id.nutrition_menu:
                Intent nutr_intent = new Intent(AddFood.this, ETestActivity.class);
                startActivity(nutr_intent);
                return true;

            case R.id.workout_menu:
                Intent work_intent = new Intent(AddFood.this, Workout.class);
                startActivity(work_intent);
                return true;

            case R.id.settings_menu:
                Intent settings_intent = new Intent(AddFood.this, MainActivity.class);
                startActivity(settings_intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void addFood(View view, Food newFood){

        Log.d("TAG","inaddFoodFunction");
        Log.d("TAG", String.valueOf(newFood));
        Log.d("TAG", String.valueOf(user.foodList));

        user.foodList.add(newFood);
        Intent intent = new Intent (this, FoodListMain.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("foodList", (Serializable) user.foodList);
        intent.putExtra("BUNDLE", bundle);
        startActivity(intent);
    }
    public void gotoFoodList (View view){
        Intent intent = new Intent (this, FoodListMain.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("foodList", (Serializable) user.foodList);
        intent.putExtra("BUNDLE", bundle);

        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
