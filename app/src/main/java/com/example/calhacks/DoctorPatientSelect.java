package com.example.calhacks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DoctorPatientSelect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_patient_select);

        Button patientButton = findViewById(R.id.patientbutton);
        patientButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activity2Intent = new Intent(getApplicationContext(), PatientRegistration.class);
                startActivity(activity2Intent);
            }
        });

        Button doctorButton = findViewById(R.id.doctorbutton);
        doctorButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activity2Intent = new Intent(getApplicationContext(), DoctorRegistration.class);
                startActivity(activity2Intent);
            }
        });
    }

}
