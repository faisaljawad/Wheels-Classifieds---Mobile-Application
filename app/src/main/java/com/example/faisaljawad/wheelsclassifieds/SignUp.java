package com.example.faisaljawad.wheelsclassifieds;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    EditText name,email,password,confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = findViewById(R.id.editText1);
        email = findViewById(R.id.editText2);
        password = findViewById(R.id.editText3);
        confirmPassword = findViewById(R.id.editText4);

        //signUp();
    }

    public void signUp()
    {
        //Toast.makeText(this,password.getText(),Toast.LENGTH_LONG).show();

    }

    public void saveSignUpInfo(View view)
    {

        if(password.getText().toString().equals(confirmPassword.getText().toString()))
        {
            SharedPreferences userSignUp = getSharedPreferences("Info", Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = userSignUp.edit();

            edit.putString("username", name.getText().toString());
            edit.putString("email", email.getText().toString());
            edit.putString("password", password.getText().toString());

            edit.apply();

            Toast.makeText(this, "Sign-Up Successful", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this,"Password mismatched. Please Try again!",Toast.LENGTH_LONG).show();
        }
    }
}
