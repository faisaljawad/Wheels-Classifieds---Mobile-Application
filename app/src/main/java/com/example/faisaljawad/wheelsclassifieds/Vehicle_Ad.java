package com.example.faisaljawad.wheelsclassifieds;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
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
    public static final int gallery_request = 10000;
    private int CAMERA_PERMISSION = 1;
    private int GALLERY_PERMISSION = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_ad);
        transmission =(Spinner)findViewById(R.id.spnTransmission);
        fuel = (Spinner)findViewById(R.id.spnFuelType);
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
       else if (location.getText().toString().equals(null) || location.getText().toString().matches("[0-9.]+")) {
            location.setError("Location Field is Empty!");
            location.setError("Location Field must have alphabetical characters only!");
            return false;
        }
        else if (price.getText().toString().equals(null) || price.getText().toString().matches("[a-zA-Z\\s]+")) {
            price.setError("Price Field is Empty!");
            price.setError("Price Field must have Numerical values only!");
            return false;
        }
        else if (registration.getText().toString().equals(null) || registration.getText().toString().matches("[0-9\\s]+")) {
            registration.setError("Registration Field is Empty!");
            registration.setError("Registration Location Field must have alphabetical characters only!");
            return false;
        }
        else if (mileage.getText().toString().equals(null) || mileage.getText().toString().matches("[a-zA-Z\\s]+")) {
            mileage.setError("Mileage Field is Empty!");
            mileage.setError("Registration Field must have Numerical values only!");
            return false;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btnForward:
                add_new_ad();
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
            String transmission_in = transmission.getSelectedItem().toString().trim();
            String fuel_in = fuel.getSelectedItem().toString().trim();
            String id = Vehicle_Ads.push().getKey();
            Ads_info_class car_obj = new Ads_info_class(location_in,price_in,registration_in,mileage_in,body_color_in,assembly_in,description_in,modelno_in,transmission_in,fuel_in);
            Vehicle_Ads.child(id).setValue(car_obj);
        }
        else
        {
            Toast.makeText(this, "Not all valid inputs are Entered. Please Try Again!",Toast.LENGTH_LONG).show();
        }
    }

    public void get_permissons(View view){
        android.app.AlertDialog.Builder builder = new AlertDialog.Builder(Vehicle_Ad.this);
        builder.setTitle("Permissions");
        builder.setMessage("Choose one..");
        builder.setPositiveButton("Camera", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(ContextCompat.checkSelfPermission(Vehicle_Ad.this,Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                    Intent intention = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intention,camera_request);
                }
                else
                {
                    requestCameraPermission();
                }
            }
        });

        builder.setNegativeButton("Gallery", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(ContextCompat.checkSelfPermission(Vehicle_Ad.this,Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                    Intent intention = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                    startActivityForResult(intention,gallery_request);
                }
                else
                {
                    requestGalleryPermission();
                }
            }
        });
        builder.show();


    }

    private void requestCameraPermission(){
        ActivityCompat.requestPermissions(Vehicle_Ad.this,new String[]{Manifest.permission.CAMERA},CAMERA_PERMISSION);
    }

    private void requestGalleryPermission(){
        ActivityCompat.requestPermissions(Vehicle_Ad.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},GALLERY_PERMISSION);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == CAMERA_PERMISSION){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intention = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intention,camera_request);
            }
        }
        else if(requestCode == GALLERY_PERMISSION){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intention = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(intention,gallery_request);
            }
        }
    }
}
