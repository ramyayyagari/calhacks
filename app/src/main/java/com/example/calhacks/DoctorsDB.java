package com.example.calhacks;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoctorsDB {

    static List<Doctor> DOCTORS = new ArrayList<>();


    static final Map<String, Doctor> DOCTORS_MAP = new HashMap<String, Doctor>();


    private static void addDoctor(Doctor item) {
        DOCTORS_MAP.put(item.getDocName(), item);
    }

    private DoctorsDB() {

    }


    static void readData(Context context) {

        if (!DOCTORS.isEmpty()) {
            return;
        }

        InputStream is = context.getResources().openRawResource(R.raw.doctor_db);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8")));
        String line = "";

        try {
            while ((line = reader.readLine()) != null) {
                // Split the line into different tokens (using the comma as a separator).
                String[] tokens = line.split(",");

                Doctor doc = new Doctor();
                doc.setDocName(tokens[0]);
                doc.setDocPhone(tokens[1]);
                doc.setWebsite(tokens[2]);
                doc.setYpURL(tokens[3]);
                doc.setAddress(tokens[4]);
                doc.setCity(tokens[5]);
                doc.setState(tokens[6]);
                doc.setZip(tokens[7]);
                doc.setCounty(tokens[8]);
                doc.setNpiType(tokens[9]);
                doc.setNpiStatus(tokens[10]);
                doc.setNpi(tokens[11]);
                doc.setSpecialty(tokens[12]);
                doc.setFax(tokens[13]);

                Log.d("MainActivity" ,"Just Created " + doc);

                DOCTORS.add(doc);
                addDoctor(doc);

            }
        } catch (IOException e1) {
            Log.e("MainActivity", "Error" + line, e1);
            e1.printStackTrace();
        }

    }


}
