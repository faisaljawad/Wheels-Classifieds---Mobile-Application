package com.example.faisaljawad.wheelsclassifieds;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class profile_activity extends AppCompatActivity {

    int [] images = {R.drawable.img_profile_myads,R.drawable.img_profile_chats,R.drawable.img_profile_fav,R.drawable.img_profile_cart};

    String [] options = {"My Ads","Chats","Favourites","My Cart"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_activity);

        ListView listView = findViewById(R.id.lst_profile);

        CustomAdapter customAdapter = new CustomAdapter();

        listView.setAdapter(customAdapter);
    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return images.length;
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

            convertView = getLayoutInflater().inflate(R.layout.custom_listview,null);

            ImageView image = convertView.findViewById(R.id.img_lst_opt_pic);
            TextView opt_text = findViewById(R.id.txt_lst_opt);

            image.setImageResource(images[position]);
            opt_text.setText(options[position]);

            return convertView;
        }
    }
}
