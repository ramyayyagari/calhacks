package com.example.calhacks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DoctorHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_home);

        Button declinePatientButton = findViewById(R.id.declinePatientButton);
        declinePatientButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activity2Intent = new Intent(getApplicationContext(), DoctorHome.class);
                startActivity(activity2Intent);
            }
        });
        Button acceptPatientButton = findViewById(R.id.acceptPatientButton);
        acceptPatientButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activity2Intent = new Intent(getApplicationContext(), ViewPatientContact.class);
                startActivity(activity2Intent);
            }
        });
    }
}
