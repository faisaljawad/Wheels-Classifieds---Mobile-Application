package com.example.faisaljawad.wheelsclassifieds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class ContactUs_Activity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us_);
        Spinner spinner=findViewById(R.id.spinnercontactus);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(ContactUs_Activity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.Subject));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }


}
