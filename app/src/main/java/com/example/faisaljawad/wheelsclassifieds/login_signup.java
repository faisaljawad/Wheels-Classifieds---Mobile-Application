package com.example.faisaljawad.wheelsclassifieds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class login_signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);
    }
    public void Redirect_Login(View view)
    {
        Intent i = new Intent(login_signup.this,Login.class);
        startActivity(i);
    }
}
