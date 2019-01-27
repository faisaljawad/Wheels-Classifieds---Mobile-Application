package com.example.faisaljawad.wheelsclassifieds.model;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.widget.Toast;
import com.example.faisaljawad.wheelsclassifieds.Ads_info_class;
import com.example.faisaljawad.wheelsclassifieds.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
public class ListDetails {

    public static ArrayList<Model> getList(){
        final ArrayList<Model> adsList = new ArrayList<>();
        /*reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String assembly = dataSnapshot.child("assembly").getValue().toString();
                String bodycolor = dataSnapshot.child("body_color").getValue().toString();
                String description = dataSnapshot.child("description").getValue().toString();
                System.out.print(assembly);
                System.out.print(bodycolor);
                System.out.print(description);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/
        adsList.add(new Model(R.drawable.civic,"Honda Civic 2017","Just like Brand New"));
        adsList.add(new Model(R.drawable.corolla,"Toyota Corolla 2007","Immaculate Condition"));
        return adsList;
    }
}
