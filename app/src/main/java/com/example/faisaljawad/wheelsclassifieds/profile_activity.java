package com.example.faisaljawad.wheelsclassifieds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class profile_activity extends AppCompatActivity {

    int [] images1 = {R.drawable.img_profile_myads,R.drawable.img_profile_chats,R.drawable.img_profile_fav,R.drawable.img_profile_alerts};

    int [] images2 = {R.drawable.img_profile_cart,R.drawable.img_profile_settings,R.drawable.img_profile_logout,R.drawable.img_prof_cancel};

    String [] options1 = {"My Ads","Chats","Saved Ads","Alerts"};

    String [] options2 = {"My Cart","Settings","Log Out","Delete Account"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_activity);

        ListView listView1 = findViewById(R.id.lst_prof_1);
        ListView listView2 = findViewById(R.id.lst_prof_2);

        CustomAdapter customAdapter1 = new CustomAdapter();
        CustomAdapter2 customAdapter2 = new CustomAdapter2();

        listView1.setAdapter(customAdapter1);
        listView2.setAdapter(customAdapter2);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent myAds = new Intent(view.getContext(),myAds.class);
                    startActivity(myAds);
                }
                if(position == 1){
                    Intent myChats = new Intent(view.getContext(),myChats.class);
                    startActivity(myChats);
                }
                if(position == 2){
                    Intent savedAds = new Intent(view.getContext(),savedAds.class);
                    startActivity(savedAds);
                }
                if(position == 3){
                    Intent alerts = new Intent(view.getContext(),prof_alerts.class);
                    startActivity(alerts);
                }
            }
        });

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent myCart = new Intent(view.getContext(),my_cart.class);
                    startActivity(myCart);
                }
                if(position == 1){
                    Intent settings = new Intent(view.getContext(),settings.class);
                    startActivity(settings);
                }
                if(position == 2){
                    Intent signOut = new Intent(view.getContext(),SplashScreen.class);
                    startActivity(signOut);
                }
                if(position == 3){
                    Intent delAcc = new Intent(view.getContext(),prof_del_account.class);
                    startActivity(delAcc);
                }
            }
        });
    }

    class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return images1.length;
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
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.custom_adapter_prof_1,null);

            ImageView imageView1 = convertView.findViewById(R.id.img_cst_adp_prof1);
            TextView textView1 = convertView.findViewById(R.id.txt_cst_adp_1);

            imageView1.setImageResource(images1[position]);
            textView1.setText(options1[position]);

            return convertView;
        }
    }

    class CustomAdapter2 extends BaseAdapter {
        @Override
        public int getCount() {
            return images2.length;
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
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.custom_adapter_prof2,null);

            ImageView imageView1 = convertView.findViewById(R.id.img_cst_adp_prof2);
            TextView textView1 = convertView.findViewById(R.id.txt_cst_adp_2);

            imageView1.setImageResource(images2[position]);
            textView1.setText(options2[position]);

            return convertView;
        }
    }
}
