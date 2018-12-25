package com.example.faisaljawad.wheelsclassifieds;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Home extends AppCompatActivity {

    private static int splash_time_out = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splash = new Intent(Home.this,New_HomePage.class);
                startActivity(splash);
                finish();
            }
        },splash_time_out);
    }

}
