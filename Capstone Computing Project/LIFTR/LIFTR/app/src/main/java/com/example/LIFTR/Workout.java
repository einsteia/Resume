package com.example.LIFTR;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuInflater;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import android.content.Intent;
import android.widget.CheckBox;
import android.widget.TextView;


public class Workout extends AppCompatActivity {
    Button btn;
    TextView txt3;
    TextView txt4;
    TextView txt5;
    TextView txt6;
    TextView txt7;


    String[] Beginner1 = {"20 Bodyweight squats", "20 Knee Push-ups", "20 Chin-ups", "10 Dips", "30 Jumping jacks"};
    String[] Beginner2 = {"10 Push-ups", "10 Regular Lunges","10 Dips","20 Jump Step-ups","10 Bodyweight squats"};
    String[] Beginner3 = {"10 Walking lunges (each leg)", "10 Burpees","Jump rope 10 minutes","10 One arm rows (each arm)","10 Push-ups"};
    String[] Beginner4 = {"15 Second Plank", "10 One arm rows (each arm)","20 Jump Step-ups","10 Pull-ups","30 Jumping jacks"};

    String[] Novice1 = {"30 Bodyweight squats", "20 Jump Step-ups","3 sets of 10 Squats","3 sets of 10 Bench Press","3 sets of 10 Leg Press"};
    String[] Novice2 = {"10 Pull-ups", "10 Chin-ups","3 sets of 10 Incline Bench Press","3 sets of 10 Leg Curl","3 sets of 10 Machine Chest Fly"};
    String[] Novice3 = {"10 Dips", "30 Jumping jacks","30 Minutes of Cardio","10 One arm rows (each arm)","3 sets of 10 Squats"};
    String[] Novice4 = {"30 Second Plank", "20 Second Side Plank (each side)","15 Second Plank","10 Push-ups","20 Bodyweight squats"};

    String[] Intermediate1 = {"3 sets of 10 Squats", "3 sets of 10 Bench Press","30 Bodyweight squats","20 Jump Step-ups","3 sets of 10 Bench Press"};
    String[] Intermediate2 = {"3 sets of 10 Leg Press", "3 sets of 10 Incline Bench Press","10 Pull-ups","10 Chin-ups","3 sets of 10 Incline Bench Press"};
    String[] Intermediate3 = {"3 sets of 10 Leg Curl", "3 sets of 10 Machine Chest Fly","10 Dips","30 Jumping jacks","10 One arm rows (each arm)"};
    String[] Intermediate4 = {"30 Minutes of Cardio", "30 Second Plank","30 Bodyweight squats","10 Pull-ups","10 Dips"};

    String[] Advanced1 = {"3-4 sets of 10 Squats", "3-4 sets of 10 Bench Press","30 Bodyweight squats","20 Jump Step-ups","3 sets of 10 Bench Press"};
    String[] Advanced2 = {"3-4 sets of 10 Leg Curl", "3-4 sets of 10 Incline Bench Press","10 Pull-ups","10 Chin-ups","3 sets of 10 Incline Bench Press"};
    String[] Advanced3 = {"3-4 sets of 10 Leg Extension", "3-4 sets of 10 Machine Chest Fly","30 Minutes of Cardio","10 One arm rows (each arm)"};
    String[] Advanced4 = {"45 Minutes of Cardio", "45 Minutes of Cardio","15 Second Plank","10 Push-ups","20 Bodyweight squats"};

    String[] Elite1 = {"4 sets of 10 Squats", "4 sets of 10 Bench Press","30 Bodyweight squats","20 Jump Step-ups","3 sets of 10 Bench Press"};
    String[] Elite2 = {"4 sets of 10 Leg Curl", "4 sets of 10 Incline Bench Press","20 Jump Step-ups","10 Pull-ups","30 Jumping jacks"};
    String[] Elite3 = {"4 sets of 10 Leg Extension", "4 sets of 10 Machine Chest Fly","30 Minutes of Cardio","25 One arm rows (each arm)","3 sets of 10 Squats"};
    String[] Elite4 = {"1 Hour of Cardio", "50 Pull-ups","1 Minute Plank","50 Push-ups","30 Bodyweight squats"};

    String[] Cardio1 = {"Burpees 30 minutes", "4 sets of 10 Bench Press","Squat jumps","Arm circles","3 sets of 10 Bench Press"};
    String[] Cardio2 = {"Jumping jacks 30 minutes", "4 sets of 10 Incline Bench Press","20 Jump Step-ups","10 Pull-ups","30 Jumping jacks"};
    String[] Cardio3 = {"Jump rope 30 minutes", "4 sets of 10 Machine Chest Fly","Running in place 30 Minutes","25 One arm rows (each arm)","3 sets of 10 Squats"};
    String[] Cardio4 = {"1 Hour of Cardio", "1 Hour of Cardio","1 Hour of Cardio","1 Hour of Cardio","1 Hour of Cardio"};

    int counter = -1;


    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("LIFTR");
        toolbar.setTitleTextColor(Color.WHITE);

        txt3 = (TextView) findViewById(R.id.textView3);
        txt4 = (TextView) findViewById(R.id.textView4);
        txt5 = (TextView) findViewById(R.id.textView5);
        txt6 = (TextView) findViewById(R.id.textView6);
        txt7 = (TextView) findViewById(R.id.textView7);
        final CheckBox checkBox4 = (CheckBox) findViewById(R.id.Workout_checkBox4);
        final CheckBox checkBox3 = (CheckBox) findViewById(R.id.Workout_checkBox3);
        final CheckBox checkBox5 = (CheckBox) findViewById(R.id.Workout_checkBox5);
        final CheckBox checkBox6 = (CheckBox) findViewById(R.id.Workout_checkBox6);

        btn = (Button) findViewById(R.id.button);

        if (user.getFitness().equals("Beginner(maybe once a week, low weights)")) {
            txt3.setText(Beginner1[0]);
            txt4.setText(Beginner2[0]);
            txt5.setText(Beginner3[0]);
            txt6.setText(Beginner4[0]);
        }

        if (user.getFitness().equals("Novice(2-3 times a week, low to med weights)")) {
            txt3.setText(Novice1[0]);
            txt4.setText(Novice2[0]);
            txt5.setText(Novice3[0]);
            txt6.setText(Novice4[0]);
        }

        if (user.getFitness().equals("Intermediate(4 times a week)")) {
            txt3.setText(Intermediate1[0]);
            txt4.setText(Intermediate2[0]);
            txt5.setText(Intermediate3[0]);
            txt6.setText(Intermediate4[0]);
        }

        if (user.getFitness().equals("Advanced(5-6 times a week)")) {
            txt3.setText(Advanced1[0]);
            txt4.setText(Advanced2[0]);
            txt5.setText(Advanced3[0]);
            txt6.setText(Advanced4[0]);
        }

        if (user.getFitness().equals("Elite(7 times week, 2 workout a day)")) {
            txt3.setText(Elite1[0]);
            txt4.setText(Elite2[0]);
            txt5.setText(Elite3[0]);
            txt6.setText(Elite4[0]);
        }

        if (user.getGoal().equals("Lose Weight")) {
            txt3.setText(Cardio1[0]);
            txt4.setText(Cardio2[0]);
            txt5.setText(Cardio3[0]);
            txt6.setText(Cardio4[0]);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter == 4) {
                    counter = -1;
                    counter++;
                } else {
                    counter++;
                }
                if (user.getFitness().equals("Beginner(maybe once a week, low weights)")) {
                    if (checkBox3.isChecked()) {
                        txt3.setText(Beginner1[counter]);
                    }
                    if (checkBox4.isChecked()) {
                        txt4.setText(Beginner2[counter]);
                    }
                    if (checkBox5.isChecked()) {
                        txt5.setText(Beginner3[counter]);
                    }
                    if (checkBox6.isChecked()) {
                        txt6.setText(Beginner4[counter]);
                    }
                }
                if (user.getFitness().equals("Novice(2-3 times a week, low to med weights)")) {
                    if (checkBox3.isChecked()) {
                        txt3.setText(Novice1[counter]);
                    }
                    if (checkBox4.isChecked()) {
                        txt4.setText(Novice2[counter]);
                    }
                    if (checkBox5.isChecked()) {
                        txt5.setText(Novice3[counter]);
                    }
                    if (checkBox6.isChecked()) {
                        txt6.setText(Novice4[counter]);
                    }
                }
                if (user.getFitness().equals("Intermediate(4 times a week)")) {
                    if (checkBox3.isChecked()) {
                        txt3.setText(Intermediate1[counter]);
                    }
                    if (checkBox4.isChecked()) {
                        txt4.setText(Intermediate2[counter]);
                    }
                    if (checkBox5.isChecked()) {
                        txt5.setText(Intermediate3[counter]);
                    }
                    if (checkBox6.isChecked()) {
                        txt6.setText(Intermediate4[counter]);
                    }
                }
                if (user.getFitness().equals("Advanced(5-6 times a week)")) {
                    if (checkBox3.isChecked()) {
                        txt3.setText(Advanced1[counter]);
                    }
                    if (checkBox4.isChecked()) {
                        txt4.setText(Advanced2[counter]);
                    }
                    if (checkBox5.isChecked()) {
                        txt5.setText(Advanced3[counter]);
                    }
                    if (checkBox6.isChecked()) {
                        txt6.setText(Advanced4[counter]);
                    }
                }
                if (user.getFitness().equals("Elite(7 times week, 2 workout a day)")) {
                    if (checkBox3.isChecked()) {
                        txt3.setText(Elite1[counter]);
                    }
                    if (checkBox4.isChecked()) {
                        txt4.setText(Elite2[counter]);
                    }
                    if (checkBox5.isChecked()) {
                        txt5.setText(Elite3[counter]);
                    }
                    if (checkBox6.isChecked()) {
                        txt6.setText(Elite4[counter]);
                    }
                }
                if (user.getGoal().equals("Lose Weight")) {
                    if (checkBox3.isChecked()) {
                        txt3.setText(Cardio1[counter]);
                    }
                    if (checkBox4.isChecked()) {
                        txt4.setText(Cardio2[counter]);
                    }
                    if (checkBox5.isChecked()) {
                        txt5.setText(Cardio3[counter]);
                    }
                    if (checkBox6.isChecked()) {
                        txt6.setText(Cardio4[counter]);
                    }
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
        switch(item.getItemId()) {
            case R.id.home_menu:
                Intent home_intent = new Intent(Workout.this, HomeScreen1.class);
                startActivity(home_intent);
                return true;

            case R.id.nutrition_menu:
                Intent nutr_intent = new Intent(Workout.this, ETestActivity.class);
                startActivity(nutr_intent);
                return true;

            case R.id.workout_menu:
                Intent work_intent = new Intent(Workout.this, Workout.class);
                startActivity(work_intent);
                return true;

            case R.id.settings_menu:
                Intent settings_intent = new Intent(Workout.this, MainActivity.class);
                startActivity(settings_intent);
                return true;


            default: return super.onOptionsItemSelected(item);
        }
    }

    public void goToHome (View view){
        Intent intent = new Intent (this, HomeScreen1.class);
        startActivity(intent);
    }

}