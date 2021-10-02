package com.example.LIFTR;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Button;

public class Opening3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Button button1;
    EditText theWeight;
    Spinner theFitness;
    EditText theHeight;
    Spinner theBody;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening3);

        theWeight = (EditText) findViewById(R.id.weightQ);
        theFitness = (Spinner) findViewById(R.id.fitnessQ);
        theHeight = (EditText) findViewById(R.id.heightQ);
        theBody = (Spinner) findViewById(R.id.bodyQ);

        Spinner fitnessQ = findViewById(R.id.fitnessQ);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.fitnessOptions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fitnessQ.setAdapter(adapter);
        fitnessQ.setOnItemSelectedListener(this);

        Spinner bodyQ = findViewById(R.id.bodyQ);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.bodyOptions, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bodyQ.setAdapter(adapter1);
        bodyQ.setOnItemSelectedListener(this);

        button1 = (Button) findViewById(R.id.start1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOpening4();
            }
        });
    }

    public void openOpening4(){
        if(theWeight.getText().toString().equals("") || Integer.parseInt(theWeight.getText().toString()) < 10 || Integer.parseInt(theWeight.getText().toString()) > 1500)
            Toast.makeText(getBaseContext(), "Please enter a valid weight.", Toast.LENGTH_LONG).show();
        else if (theHeight.getText().toString().equals("") || Integer.parseInt(theHeight.getText().toString()) < 24 || Integer.parseInt(theHeight.getText().toString()) > 108)
            Toast.makeText(getBaseContext(), "Please enter a valid height.", Toast.LENGTH_LONG).show();
        else {
            user.setFitness(theFitness.getSelectedItem().toString());
            user.setHeight(Integer.parseInt(theHeight.getText().toString()));
            user.setWeight(Integer.parseInt(theWeight.getText().toString()));
            user.setType(theBody.getSelectedItem().toString());
            Intent intent = new Intent(this, Opening4.class);
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
}
