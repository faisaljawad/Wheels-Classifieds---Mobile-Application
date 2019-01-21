package com.example.faisaljawad.wheelsclassifieds.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.faisaljawad.wheelsclassifieds.R;
import com.example.faisaljawad.wheelsclassifieds.model.Model;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdsAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Model> models;

    public AdsAdapter(Context context, ArrayList<Model> models) {
        this.context = context;
        this.models = models;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int position) {
        return models.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = View.inflate(context, R.layout.list_items, null);
        }
        ImageView images = (ImageView)convertView.findViewById(R.id.adImageView);
        TextView title = (TextView)convertView.findViewById(R.id.adTitle);
        TextView desc = (TextView)convertView.findViewById(R.id.adDescription);
        Model model = models.get(position);
        images.setImageResource(model.getAd_Image());
        title.setText(model.getAd_Title());
        desc.setText(model.getAd_Description());
        return convertView;
    }
}
