package com.corentin.mad_rental;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ReservationViewHolder extends RecyclerView.ViewHolder {
    public TextView info, beginDate, endDate;
    public ImageView image;

    public ReservationViewHolder(View view){
        super(view);
        info = view.findViewById(R.id.vehicle_title);
        beginDate = view.findViewById(R.id.vehicule_firstinfo);
        endDate = view.findViewById(R.id.vehicule_secondinfo);
        image =  view.findViewById(R.id.vehicule_img);
    }
}
