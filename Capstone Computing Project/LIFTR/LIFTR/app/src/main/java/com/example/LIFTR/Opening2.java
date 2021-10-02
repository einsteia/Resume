package com.example.LIFTR;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Opening2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Button button;
    EditText theName;
    Spinner theSex;
    EditText theAge;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening2);

        button = (Button) findViewById(R.id.start1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOpening3();
            }
        });

        theName = (EditText) findViewById(R.id.nameQ);
        theSex = (Spinner) findViewById(R.id.sexQ);
        theAge = (EditText) findViewById(R.id.ageQ);

        Spinner sexQ = findViewById(R.id.sexQ);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sexOptions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sexQ.setAdapter(adapter);
        sexQ.setOnItemSelectedListener(this);
    }
    public void openOpening3() {
        if(theName.getText().toString().equals("") || theName.getText().toString().length() > 12)
            Toast.makeText(getBaseContext(), "Please enter a valid name.", Toast.LENGTH_LONG).show();
        else if (theAge.getText().toString().equals("") || Integer.parseInt(theAge.getText().toString()) < 12 || Integer.parseInt(theAge.getText().toString()) > 110)
            Toast.makeText(getBaseContext(), "Please enter a valid age.", Toast.LENGTH_LONG).show();
        else {
            user.setName(theName.getText().toString());
            user.setSex(theSex.getSelectedItem().toString());
            user.setAge(Integer.parseInt(theAge.getText().toString()));
            Intent intent = new Intent(this, com.example.LIFTR.Opening3.class);
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
