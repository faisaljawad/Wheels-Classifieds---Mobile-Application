package com.example.faisaljawad.wheelsclassifieds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Ad_Category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_category);
    }

    public void OpenDetails(View view)
    {
        Intent i = new Intent(Ad_Category.this,Vehicle_Ad.class);
        startActivity(i);
    }
}
