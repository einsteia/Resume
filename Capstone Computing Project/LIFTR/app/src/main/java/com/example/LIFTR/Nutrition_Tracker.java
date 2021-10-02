package com.example.LIFTR;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Nutrition_Tracker extends AppCompatActivity {
    private Button button1;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition__tracker);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("LIFTR");
        toolbar.setTitleTextColor(Color.WHITE);

        button1 = (Button) findViewById(R.id.nthome);
        button2 = (Button) findViewById(R.id.ntlog);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHome();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goLog();
            }
        });

        TextView recCal;
        TextView recProt;
        TextView recCarb;
        TextView flCal;
        TextView flProt;
        TextView flCarb;

        recCal = findViewById(R.id.reccal);
        recProt = findViewById(R.id.recprot);
        recCarb = findViewById(R.id.reccarb);
        flCal = findViewById(R.id.ntlogcal);
        flProt = findViewById(R.id.ntlogprot);
        flCarb = findViewById(R.id.ntlogcarb);

        recCal.setText("Recommended Calories: "+ Integer.toString((int) Math.round(user.calculateCalories())));
        recProt.setText("Recommended Protein (g): "+ Integer.toString((int) Math.round(user.calculateProtein())));
        recCarb.setText("Recommended Carbs (g): "+ Integer.toString((int) Math.round(user.calculateCarbs())));
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
                Intent home_intent = new Intent(Nutrition_Tracker.this, HomeScreen1.class);
                startActivity(home_intent);
                return true;

            case R.id.nutrition_menu:
                Intent nutr_intent = new Intent(Nutrition_Tracker.this, ETestActivity.class);
                startActivity(nutr_intent);
                return true;

            case R.id.workout_menu:
                Intent work_intent = new Intent(Nutrition_Tracker.this, Workout.class);
                startActivity(work_intent);
                return true;

            case R.id.settings_menu:
                Intent settings_intent = new Intent(Nutrition_Tracker.this, MainActivity.class);
                startActivity(settings_intent);
                return true;


            default: return super.onOptionsItemSelected(item);
        }
    }

    public void goHome(){
        Intent intent = new Intent(this, HomeScreen1.class);
        startActivity(intent);
    }
    public void goLog(){
        Intent intent = new Intent(this, adamMainActivity.class);
        startActivity(intent);
    }
}
