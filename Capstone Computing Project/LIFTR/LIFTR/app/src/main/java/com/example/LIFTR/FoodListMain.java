package com.example.LIFTR;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;


public class FoodListMain extends AppCompatActivity {
    EditText searchFoodInput;
    Button searchFoodButton;
    Button gotoaddFood;
    private static final String TAG = "FoodListMain";

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gotoaddFood = (Button) findViewById(R.id.fab);
        setContentView(R.layout.activity_food_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("LIFTR");
        toolbar.setTitleTextColor(Color.WHITE);
        ListView aListView = (ListView) findViewById(R.id.foodList);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getBundleExtra(("BUNDLE"));

        if (bundle != null) {
            //      foodList = (ArrayList<Food>) bundle.getSerializable(("foodList"));
            Log.d(TAG, String.valueOf(user.foodList));
//            if (user.foodList.size() <= 0) {
//                Food redApple = new Food("Red Apple", 95,
//                        0.3, 25,
//                        0.2, "Whole", 1);
//
//                Food orange = new Food("Orange", 62,
//                        1.2, 15,
//                        0.2, "Whole", 1);
//
//                Food mango = new Food("Mango", 201,
//                        2.8 , 50,
//                        1.3, "Whole", 1);
//
//                Food banana = new Food("Whole", 105,
//                        1.3, 27,
//                        0.4, "Whole", 1);
//
//                Food yPotato = new Food("Yellow Potato", 87,
//                        1.9, 20,
//                        0.1, "Whole", 1);
//
//                Food chicken = new Food("Chicken Breast", 231,
//                        43, 0,
//                        5, "Pounds", 1);
//
//                Food pineapple = new Food("Pineapple", 95,
//                        0.3, 25,
//                        0.2, "Cups", 1);
//
//                Food peach = new Food("Peach", 62,
//                        1.2, 15,
//                        0.2, "Whole", 1);
//
//                Food wBread = new Food("White Bread", 201,
//                        2.8 , 50,
//                        1.3, "Slice", 1);
//
//                Food pb = new Food("Peanut Butter", 105,
//                        1.3, 27,
//                        0.4, "Tbsp", 1);
//
//                Food cheddar = new Food("Cheddar", 87,
//                        1.9, 20,
//                        0.1, "Slice", 1);
//
//                Food broccoli= new Food("Broccoli", 231,
//                        43, 0,
//                        5, "oz", 6);
//
//
//                user.foodList.add(redApple);
//                user.foodList.add(orange);
//                user.foodList.add(mango);
//                user.foodList.add(banana);
//                user.foodList.add(yPotato);
//                user.foodList.add(chicken);
//                user.foodList.add(peach);
//                user.foodList.add(wBread);
//                user.foodList.add(pb);
//                user.foodList.add(cheddar);
//                user.foodList.add(pineapple);
//                user.foodList.add(broccoli);            }

            searchFoodButton = (Button) findViewById(R.id.searchFoodButton);

            searchFoodButton.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void onClick(View v) {
                    Food searchedFood = null;
                    searchFoodInput = (EditText) findViewById(R.id.searchFoodInput);
                    String searchedFoodInputText = searchFoodInput.getText().toString();
                    ArrayList<Food> searchedFoodList = new ArrayList<Food>();

                    for (int i = 0; i < user.foodList.size() - 1; i++) {
                        Food currFood = user.foodList.get(i);

                        if (currFood.getName().equalsIgnoreCase(searchedFoodInputText)) {
                            searchedFoodList.add(currFood);
                        }
                    }

                    if (searchedFoodList.size() > 0) {
                        user.foodList.sort(new Comparator<Food>() {
                            @Override
                            public int compare(Food o1, Food o2) {
                                return o1.getName().compareTo(o2.getName());
                            }
                        });

                        ListView aListView = (ListView) findViewById(R.id.foodList);
                        FoodListAdapter adapter= new FoodListAdapter(FoodListMain.this, R.layout. activity_food_list_adapter, searchedFoodList);
                        aListView.setAdapter(adapter);
                    }
                }
            });

            user.foodList.sort(new Comparator<Food>() {
                @Override
                public int compare(Food o1, Food o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });

            FoodListAdapter adapter= new FoodListAdapter(this, R.layout. activity_food_list_adapter, user.foodList);
            aListView.setAdapter(adapter);
        }
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
                Intent home_intent = new Intent(FoodListMain.this, HomeScreen1.class);
                startActivity(home_intent);
                return true;

            case R.id.nutrition_menu:
                Intent nutr_intent = new Intent(FoodListMain.this, ETestActivity.class);
                startActivity(nutr_intent);
                return true;

            case R.id.workout_menu:
                Intent work_intent = new Intent(FoodListMain.this, Workout.class);
                startActivity(work_intent);
                return true;

            case R.id.settings_menu:
                Intent settings_intent = new Intent(FoodListMain.this, MainActivity.class);
                startActivity(settings_intent);
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void gotoAddFood(View view){
        Intent intent = new Intent(this, AddFood.class);
        startActivity(intent);

    }
}
