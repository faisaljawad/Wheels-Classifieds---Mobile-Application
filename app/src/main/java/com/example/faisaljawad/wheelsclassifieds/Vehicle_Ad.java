package com.example.faisaljawad.wheelsclassifieds;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.provider.MediaStore;

public class Vehicle_Ad extends AppCompatActivity {
    EditText location,price,registration,mileage,body_color,assembly,description,modelno;
    Spinner transmission, fuel;
    DatabaseReference Vehicle_Ads = FirebaseDatabase.getInstance().getReference("Vehicle_Ads");
    public static final int camera_request = 9999;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_ad);
        transmission =(Spinner)findViewById(R.id.spnTransmission);

        location = (EditText)findViewById(R.id.edtLocation);
        price = (EditText)findViewById(R.id.edtPrice);
        registration = (EditText)findViewById(R.id.edtRegistration);
        mileage = (EditText)findViewById(R.id.edtMileage);
        body_color = (EditText)findViewById(R.id.edtBodyColor);
        assembly = (EditText)findViewById(R.id.edtAssembly);
        description = (EditText)findViewById(R.id.edtDescription);
        modelno=(EditText)findViewById(R.id.edtModel);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_forward,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean Validate() // This Function will have all validation check
    {
        if(location.getText().toString().matches("") && price.getText().toString().matches("") && registration.getText().toString().matches("") && mileage.getText().toString().matches("") && body_color.getText().toString().matches("")&& assembly.getText().toString().matches("") && description.getText().toString().matches(""))
        {
            location.setError("Location Field is Empty!");
            price.setError("Price Field is Empty!");
            registration.setError("Registration Field is Empty!");
            mileage.setError("Mileage Field is Empty!");
            body_color.setError("Body Color Field is Empty!");
            assembly.setError("Assembly Field is Empty!");
            description.setError("Description Field is Empty!");
            modelno.setError("Model Number Field is Empty!");
            return false;
        }
        else if (location.getText().toString().matches("") || location.getText().toString().matches("[a-zA-Z ]+")) {
            location.setError("Location Field is Empty!");
            location.setError("Location Field must have alphabetical characters only!");
            return false;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btnForward:
                Toast.makeText(this, transmission.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
                //add_new_ad();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void add_new_ad()
    {
        if(Validate())
        {
            Toast.makeText(this, "Posting...",Toast.LENGTH_LONG).show();
            String location_in = location.getText().toString().trim();
            String price_in = "PKR " + price.getText().toString().trim();
            String registration_in = registration.getText().toString().trim();
            String mileage_in = mileage.getText().toString().trim() + "kms";
            String body_color_in = body_color.getText().toString().trim();
            String assembly_in = assembly.getText().toString().trim();
            String description_in = description.getText().toString().trim();
            String modelno_in=modelno.getText().toString().trim();
            String id = Vehicle_Ads.push().getKey();
            Ads_info_class car_obj = new Ads_info_class(location_in,price_in,registration_in,mileage_in,body_color_in,assembly_in,description_in,modelno_in);
            Vehicle_Ads.child(id).setValue(car_obj);
        }
        else
        {
            Toast.makeText(this, "Not all valid inputs are Entered. Please Try Again!",Toast.LENGTH_LONG).show();
        }
    }

    public void takePicture(View view){
        Intent intention = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intention,camera_request);
    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == camera_request)
        {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
        }
    }*/
}
