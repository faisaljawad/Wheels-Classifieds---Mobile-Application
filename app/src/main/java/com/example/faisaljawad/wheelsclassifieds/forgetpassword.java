package com.example.faisaljawad.wheelsclassifieds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class forgetpassword extends AppCompatActivity {

    EditText user_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);
        user_email=findViewById(R.id.emailforgetpassword);
        Button submitbtn=(Button)findViewById(R.id.btnForgetPassword);


    }

}
