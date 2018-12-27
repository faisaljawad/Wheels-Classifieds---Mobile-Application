package com.example.faisaljawad.wheelsclassifieds;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    EditText name,email,password,confirmPassword;
    FirebaseDatabase object = FirebaseDatabase.getInstance();
    DatabaseReference root_ref = object.getReference();
    DatabaseReference child_ref = root_ref.child("Hello");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name = findViewById(R.id.edtName);
        email = findViewById(R.id.edtEmail);
        password = findViewById(R.id.edtPassWord);
        confirmPassword = findViewById(R.id.edtPassword2);
    }

    public void saveSignUpInfo(View view)
    {
        if(name.getText().toString().matches("") && email.getText().toString().matches("") && password.getText().toString().matches("") && confirmPassword.getText().toString().matches(""))
        {
            name.setError("Name Field is Empty!");
            email.setError("Email Field is Empty!");
            password.setError("Password Field is Empty!");
            confirmPassword.setError("Confirm Password Field is Empty!");
            return;
        }
        else if (name.getText().toString().matches("")) {
            name.setError("Name Field is Empty!");
            return;
        }
        else if (email.getText().toString().matches("")) {
            //Toast.makeText(this, "Email Field is left empty. Please Enter a valid Name", Toast.LENGTH_SHORT).show();
            email.setError("Email Field is Empty");
            return;
        }
        else if(password.getText().toString().matches(""))
        {
            password.setError("Password Field is Empty!");
            return;
        }
        else if(confirmPassword.getText().toString().matches(""))
        {
            confirmPassword.setError("Confirm Password Field is Empty!");
            return;
        }
        else if(password.getText().toString().equals(confirmPassword.getText().toString()))
        {
            SharedPreferences userSignUp = getSharedPreferences("Info", Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = userSignUp.edit();

            edit.putString("username", name.getText().toString());
            edit.putString("email1", email.getText().toString());
            edit.putString("password1", password.getText().toString());

            edit.apply();

            Toast.makeText(this, "Sign-Up Successful", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, Login.class);
            startActivity(i);
        }

        else
        {
            //Toast.makeText(this,"Password mismatched. Please Try again!",Toast.LENGTH_LONG).show();
            password.setError("Password mismatched");
            confirmPassword.setError("Confirm Password misamtched!");
        }
    }
}
