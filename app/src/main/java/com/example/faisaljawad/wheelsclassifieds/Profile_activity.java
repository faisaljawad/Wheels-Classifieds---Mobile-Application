package com.example.faisaljawad.wheelsclassifieds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Profile_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_activity);

        String [] options = {"My Ads","Chats","Saved Ads","My Cart"};

        ArrayAdapter myArrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,options);

        /*ListView myListView = findViewById(R.id.lst_profile);

        myListView.setAdapter(myArrayAdapter);

        myListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String option = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(Profile_activity.this,option,Toast.LENGTH_LONG).show();
                    }
                }
        );*/
    }
}
