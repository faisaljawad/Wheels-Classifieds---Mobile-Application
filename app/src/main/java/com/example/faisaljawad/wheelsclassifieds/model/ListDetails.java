package com.example.faisaljawad.wheelsclassifieds.model;

import com.example.faisaljawad.wheelsclassifieds.R;

import java.util.ArrayList;

public class ListDetails {
    public static ArrayList<Model> getList(){
        ArrayList<Model> adsList = new ArrayList<>();
        adsList.add(new Model(R.drawable.corolla,"Toyota Corolla 2007","Immaculate Condition"));
        adsList.add(new Model(R.drawable.civic,"Honda Civic 2017","Just like Brand New"));
        return adsList;
    }
}
