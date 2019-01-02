package com.example.faisaljawad.wheelsclassifieds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class Vehicle_Ad extends AppCompatActivity {

    /*String[] Header = {"Location","Car Detail","Price","Registration City","Mileage","Body Color","Assembly","Description"};
    String[] txtViewHints = {"Select City","Add Details","Add Price","Select City","Enter Mileage","Select Body Color","Select Assembly","For Example: Alloy Rims, Painted etc"};
    */@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_ad);

        /*ListView list = (ListView)findViewById(R.id.lstAds);
        CustomAdapter customAdapter = new CustomAdapter();

        list.setAdapter(customAdapter);*/
    }

    /*class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return Header.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            view = getLayoutInflater().inflate(R.layout.custom_ad_adapter,null);
            TextView headers = (TextView)findViewById(R.id.txtHeader);
            EditText Details = (EditText)findViewById(R.id.edtDetails);

            headers.setText(Header[position]);
            Details.setHint(txtViewHints[position]);

            return null;
        }
    }*/
}
