package com.corentin.mad_rental;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SearchViewHolder extends RecyclerView.ViewHolder {
    public TextView title, price, pollution;
    public ImageView image;

    public SearchViewHolder(View view){
        super(view);
        title = view.findViewById(R.id.vehicle_title);
        price = view.findViewById(R.id.vehicule_firstinfo);
        pollution = view.findViewById(R.id.vehicule_secondinfo);
        image =  view.findViewById(R.id.vehicule_img);
    }
}
