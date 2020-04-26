package com.example.calhacks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class RequestForm extends AppCompatActivity implements OnItemSelectedListener {
    public String description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_form);

        Spinner spinner2 = (Spinner) findViewById(R.id.SpecialtyMenu);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.specialty_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //nothing
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void submit(){
        Button submitRequest = findViewById(R.id.submitRequest);
        submitRequest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent PatientConfirm = new Intent(getApplicationContext(), PatientConfirm.class);
                    startActivity(PatientConfirm);
                }
        });
    }
}
