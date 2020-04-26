package com.example.calhacks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button signupButton = findViewById(R.id.signup);
        signupButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activity2Intent = new Intent(getApplicationContext(), DoctorPatientSelect.class);
                startActivity(activity2Intent);
            }
        });

        Button loginButton = findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent Login = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(Login);
            }
        });

        DoctorsDB.readData(this);
    }


}
