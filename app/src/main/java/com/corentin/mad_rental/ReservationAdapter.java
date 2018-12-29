package com.corentin.mad_rental;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

public class ReservationAdapter extends RecyclerView.Adapter<ReservationViewHolder> {
    private List<ReservedVehicle> reservationList;
    private Context context;

    public ReservationAdapter (List<ReservedVehicle> reservationList, Context context){
        this.reservationList = reservationList;
        this.context = context;
    }

    @Override
    public ReservationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.vehicles, parent, false);
        ReservationViewHolder reservationViewHolder = new ReservationViewHolder(item);
        return reservationViewHolder;
    }

    @Override
    public void onBindViewHolder(ReservationViewHolder holder, int position) {
        ReservedVehicle vehicle = reservationList.get(position);
        holder.info.setText(vehicle.getName() + " - " + vehicle.getPrice() + " €");
        holder.beginDate.setText("début: " + vehicle.getBeginDate());
        holder.endDate.setText("fin: " + vehicle.getEndDate());
        Glide.with(context).load(vehicle.getImage()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return reservationList.size();
    }
}
