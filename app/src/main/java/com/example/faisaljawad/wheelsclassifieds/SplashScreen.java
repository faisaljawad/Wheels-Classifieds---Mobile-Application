package com.example.faisaljawad.wheelsclassifieds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.Signup)
        {
            Toast.makeText(this, "Signup Activity", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, SignUp.class);
            startActivity(i);
        }
        if (item.getItemId() == R.id.Login)
        {
            Toast.makeText(this, "Login Activity", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, Login.class);
            startActivity(i);
        }
        if(item.getItemId()==R.id.help)
        {
            Toast.makeText(this, "Help Activity", Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId()==R.id.about)
        {
            Toast.makeText(this, "About Activity", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
