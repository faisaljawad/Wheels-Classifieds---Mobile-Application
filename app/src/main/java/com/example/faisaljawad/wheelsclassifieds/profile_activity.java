package com.example.faisaljawad.wheelsclassifieds;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
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

    public static final int camera_request = 9999;
    public static final int gallery_request = 10000;
    private int CAMERA_PERMISSION = 1;
    private int GALLERY_PERMISSION = 2;

    ImageView profile_picture;

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

        profile_picture = (ImageView) findViewById(R.id.img_prof_pic);
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

    public void get_permissons(View view){
        android.app.AlertDialog.Builder builder = new AlertDialog.Builder(profile_activity.this);
        builder.setTitle("Permissions");
        builder.setMessage("Choose one..");
        builder.setPositiveButton("Camera", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(ContextCompat.checkSelfPermission(profile_activity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                    Intent intention = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intention,camera_request);
                }
                else
                {
                    requestCameraPermission();
                }
            }
        });

        builder.setNegativeButton("Gallery", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(ContextCompat.checkSelfPermission(profile_activity.this,Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                    Intent intention = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                    startActivityForResult(intention,gallery_request);
                }
                else
                {
                    requestGalleryPermission();
                }
            }
        });
        builder.show();


    }

    private void requestCameraPermission(){
        ActivityCompat.requestPermissions(profile_activity.this,new String[]{Manifest.permission.CAMERA},CAMERA_PERMISSION);
    }

    private void requestGalleryPermission(){
        ActivityCompat.requestPermissions(profile_activity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},GALLERY_PERMISSION);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == CAMERA_PERMISSION){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intention = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intention,camera_request);
            }
        }
        else if(requestCode == GALLERY_PERMISSION){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intention = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(intention,gallery_request);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CAMERA_PERMISSION)
        {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            profile_picture.setImageBitmap(bitmap);
        }
        else if(requestCode == GALLERY_PERMISSION)
        {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            profile_picture.setImageBitmap(bitmap);
        }
    }
}
