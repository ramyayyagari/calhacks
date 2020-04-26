package com.example.calhacks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class PatientRegistration extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_registration);

        spinner1 = (Spinner) findViewById(R.id.StatesMenu);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.states_array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //num1
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(this);

        Button submitButton = findViewById(R.id.submitPatient);
        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent doctorListActivity = new Intent(getApplicationContext(), DoctorListActivity.class);
                startActivity(doctorListActivity);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //nothing
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
