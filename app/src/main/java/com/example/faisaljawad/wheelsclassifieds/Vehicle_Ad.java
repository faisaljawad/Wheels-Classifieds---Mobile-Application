package com.example.faisaljawad.wheelsclassifieds;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Vehicle_Ad extends AppCompatActivity {

    EditText location,price,registration,mileage,body_color,assembly,description;
    DatabaseReference Car_Ads = FirebaseDatabase.getInstance().getReference("Car_Ads");
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_ad);
        location = (EditText)findViewById(R.id.edtLocation);
        price = (EditText)findViewById(R.id.edtPrice);
        registration = (EditText)findViewById(R.id.edtRegistration);
        mileage = (EditText)findViewById(R.id.edtMileage);
        body_color = (EditText)findViewById(R.id.edtBodyColor);
        assembly = (EditText)findViewById(R.id.edtAssembly);
        description = (EditText)findViewById(R.id.edtDescription);
        if(Validate())
        {
            add_new_ad();
        }
        else
        {
            Toast.makeText(this, "Not all valid inputs are Entered. Please Try Again!",Toast.LENGTH_LONG).show();
        }
    }
    private boolean Validate() // This Function will have all validation check
    {
        return true;
    }

    private void add_new_ad()
    {
        String location_in = location.getText().toString().trim();
        String price_in = price.getText().toString().trim();
        String registration_in = registration.getText().toString().trim();
        String mileage_in = mileage.getText().toString().trim();
        String body_color_in = body_color.getText().toString().trim();
        String assembly_in = assembly.getText().toString().trim();
        String description_in = description.getText().toString().trim();
        String id = Car_Ads.push().getKey();
        Ads_info_class user_obj = new Ads_info_class(location_in,price_in,registration_in,mileage_in,body_color_in,assembly_in,description_in);
        Car_Ads.child(id).setValue(user_obj);
    }

}
