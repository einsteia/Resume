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
import android.widget.TextView;

import org.w3c.dom.Text;

public class ETestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("LIFTR");
        toolbar.setTitleTextColor(Color.WHITE);
        TextView recCals;
        TextView recProt;
        TextView recCarbs;
        TextView aCals;
        TextView aCarbs;
        TextView aProt;
        TextView analysis;

        recCals = findViewById(R.id.textView9);
        aCals = findViewById(R.id.textView16);
        recCarbs = findViewById(R.id.textView17);
        aCarbs = findViewById(R.id.textView18);
        recProt = findViewById(R.id.textView21);
        aProt = findViewById(R.id.textView22);
        analysis = findViewById(R.id.textView24);

        int count1 = 0;
        double count2 = 0;
        double count3 = 0;
        for(int q=0; q<user.foodList.size(); q++){
                count1 = count1 + user.foodList.get(q).getCal()*user.foodList.get(q).getServingSize();
                count2 = count2 + user.foodList.get(q).getCarbs()*user.foodList.get(q).getServingSize();
                count3 = count3 + user.foodList.get(q).getProtein()*user.foodList.get(q).getServingSize();
        }
        recCals.setText("Recommended Calories: "+ Integer.toString((int) Math.round(user.calculateCalories())));
        recProt.setText("Recommended Protein (g): "+ Integer.toString((int) Math.round(user.calculateProtein())));
        recCarbs.setText("Recommended Carbs (g): "+ Integer.toString((int) Math.round(user.calculateCarbs())));
        aCals.setText("Actual Calories: "+ Integer.toString(count1));
        aProt.setText("Actual Protein (g): "+ Double.toString(count2));
        aCarbs.setText("Actual Carbs (g): "+ Double.toString(count3));

        if (Math.abs(user.calculateCalories() - count1) > 200)
            analysis.setText("Hmm, looks like your calories are off by a good bit!");
        else
            analysis.setText("Your calories are looking pretty good; keep it up!");
        if (Math.abs(user.calculateCarbs() - count2) > 25)
            analysis.append("\nIt looks like your carbs could use some improvement.");
        else
            analysis.append("\nYour carbs are on point, nice job!");
        if (Math.abs(user.calculateProtein() - count3) > 20)
            analysis.append("\nFinally, your protein could use some help too. Try to fix that for optimal gains!");
        else
            analysis.append("\nLastly, your protein is spot on! Keep hitting the gym for maximizing those gains!");
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
                Intent home_intent = new Intent(ETestActivity.this, HomeScreen1.class);
                startActivity(home_intent);
                return true;

            case R.id.nutrition_menu:
                Intent nutr_intent = new Intent(ETestActivity.this, ETestActivity.class);
                startActivity(nutr_intent);
                return true;

            case R.id.workout_menu:
                Intent work_intent = new Intent(ETestActivity.this, Workout.class);
                startActivity(work_intent);
                return true;

            case R.id.settings_menu:
                Intent settings_intent = new Intent(ETestActivity.this, MainActivity.class);
                startActivity(settings_intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}