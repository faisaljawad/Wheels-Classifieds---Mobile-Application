package com.example.faisaljawad.wheelsclassifieds;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Part_ad extends AppCompatActivity {

    int count;
    public static final int camera_request = 9999;
    public static final int gallery_request = 10000;
    private int CAMERA_PERMISSION = 1;
    private int GALLERY_PERMISSION = 2;
    LinearLayout linearLayout;
    LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_ad);

        linearLayout = findViewById(R.id.lnr_layout_partads);
        layoutInflater = LayoutInflater.from(Part_ad.this);
        count = 0;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_forward,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void get_permissons(View view) {
        if (count == 6) {
            Toast.makeText(Part_ad.this, "Can't Add more than 6 pictures", Toast.LENGTH_LONG).show();
        }
        else{
            android.app.AlertDialog.Builder builder = new AlertDialog.Builder(Part_ad.this);
            builder.setTitle("Permissions");
            builder.setMessage("Choose one..");
            builder.setPositiveButton("Camera", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (ContextCompat.checkSelfPermission(Part_ad.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                        Intent intention = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(intention, camera_request);
                    } else {
                        requestCameraPermission();
                    }
                }
            });

            builder.setNegativeButton("Gallery", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (ContextCompat.checkSelfPermission(Part_ad.this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                        Intent intention = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                        startActivityForResult(intention, gallery_request);
                    } else {
                        requestGalleryPermission();
                    }
                }
            });
            builder.show();
        }
    }

    private void requestCameraPermission(){
        ActivityCompat.requestPermissions(Part_ad.this,new String[]{Manifest.permission.CAMERA},CAMERA_PERMISSION);
    }

    private void requestGalleryPermission(){
        ActivityCompat.requestPermissions(Part_ad.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},GALLERY_PERMISSION);
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
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == camera_request){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            //profile_picture.setImageBitmap(bitmap);
            View view = layoutInflater.inflate(R.layout.dynamic_img_view,linearLayout,false);
            ImageView imageView = (ImageView) view.findViewById(R.id.img_dynamic_view);
            imageView.setImageBitmap(bitmap);
            linearLayout.addView(view);
            count++;
        }
        else if(resultCode == RESULT_OK && requestCode == gallery_request){
            Uri uri = data.getData();
            View view = layoutInflater.inflate(R.layout.dynamic_img_view,linearLayout,false);
            ImageView imageView = (ImageView) view.findViewById(R.id.img_dynamic_view);
            imageView.setImageURI(uri);
            linearLayout.addView(view);
            count++;
        }
    }
}
