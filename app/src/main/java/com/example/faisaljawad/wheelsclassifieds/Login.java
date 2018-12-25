package com.example.faisaljawad.wheelsclassifieds;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText userEmail,userPassword;

    public void change_to_forget_activitiy()
    {
        Intent intention = new Intent(this, forgetpassword.class);
        startActivity(intention);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userEmail = findViewById(R.id.edtEmail);
        userPassword = findViewById(R.id.edtPassWord);
        Button forget_btn = (Button) findViewById(R.id.btnForgetPassword);
        forget_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                change_to_forget_activitiy();
            }
        });
    }

    public void logIn(View view) {
        SharedPreferences login = getSharedPreferences("Info", Context.MODE_PRIVATE);

        String email = login.getString("email1", "");
        String pass = login.getString("password1", "");

        if (email.equals("") && pass.equals(""))
        {
            Toast.makeText(this, "No Data Present Currently, Please SignUp Instead", Toast.LENGTH_LONG).show();
        }
        else
        {
            if (email.equals(userEmail.getText().toString()) && pass.equals(userPassword.getText().toString())) {
                Intent intention = new Intent(this, SplashScreen.class);
                startActivity(intention);
            }
            else
            {
                Toast.makeText(this, "Wrong Username/Passowrd", Toast.LENGTH_LONG).show();
            }
        }
    }
    public void RedirectSignUP(View view)
    {
        Intent i = new Intent(this,SignUp.class);
        startActivity(i);
    }
}
