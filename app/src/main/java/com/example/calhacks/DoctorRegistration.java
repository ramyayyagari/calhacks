package com.example.calhacks;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

import static com.example.calhacks.DoctorsDB.DOCTORS;


public class DoctorRegistration extends AppCompatActivity implements OnItemSelectedListener {
    public Spinner spinner1;
    public Spinner spinner2;
    public EditText txtname;
    public String docName;
    String TAG ="main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_registration);

        spinner1 = (Spinner) findViewById(R.id.CountyMenu);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.county_array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner2 = (Spinner) findViewById(R.id.SpecialtyMenu);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.specialty_array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //num1
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(this);

        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        txtname = findViewById(R.id.EditName);
        docName =  txtname.getText().toString();
        submit();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //nothing
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    public void submit(){
        Button doctorSubmit = findViewById(R.id.submitDoctor);
        doctorSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent SignUp = new Intent(getApplicationContext(), SignupActivity.class);
                Intent Welcome = new Intent(getApplicationContext(), MainActivity.class);
                if(checkName(docName)){
                    startActivity(SignUp);
                }
                else{
                    System.out.println("Sorry! Your Name is Not Registered in Our Directory. For More Help, Please Contact Us at menah9@gmail.com");
                    startActivity(Welcome);
                }
            }
        });
    }

    public boolean checkName(String d){
        boolean result = false;
        for (Doctor doc: DOCTORS) {
            if (doc.getDocName().contains(d)){
                result=true;
            }
            else {
                result=false;
            }
        }
        return result;
    }

}

