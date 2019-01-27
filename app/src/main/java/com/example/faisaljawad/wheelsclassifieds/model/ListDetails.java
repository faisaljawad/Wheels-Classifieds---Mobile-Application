package com.example.faisaljawad.wheelsclassifieds.model;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;

import com.example.faisaljawad.wheelsclassifieds.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListDetails {
    public static ArrayList<Model> getList(){

        /*final ArrayList<Model> adsList = new ArrayList<>();

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Vehicle Ads");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String assembly = dataSnapshot.child("assembly").getValue().toString();
                String body_color = dataSnapshot.child("body_color").getValue().toString();
                adsList.add(new Model(R.drawable.corolla,assembly,body_color));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        adsList.add(new Model(R.drawable.civic,"Honda Civic 2017","Just like Brand New"));
        return adsList;*/
        ArrayList<Model> adsList = new ArrayList<>();
        adsList.add(new Model(R.drawable.civic,"Honda Civic 2017","Just like Brand New"));
        return adsList;
    }
}
