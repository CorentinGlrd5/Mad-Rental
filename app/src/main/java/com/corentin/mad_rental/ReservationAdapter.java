package com.corentin.mad_rental;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ReservationAdapter extends RecyclerView.Adapter<ReservationViewHolder> {
    private List<Vehicle> reservationList;

    public ReservationAdapter (List<Vehicle> reservationList){
        this.reservationList = reservationList;
    }

    @Override
    public ReservationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.vehicles, parent, false);
        ReservationViewHolder reservationViewHolder = new ReservationViewHolder(item);
        return reservationViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReservationViewHolder holder, int position) {
        Vehicle vehicle = reservationList.get(position);
        holder.info.setText(vehicle.getName() + " - " + vehicle.getPrice());
        holder.beginDate.setText("début: " + vehicle.getBeginDate());
        holder.endDate.setText("fin: " + vehicle.getEndDate());
    }

    @Override
    public int getItemCount() {
        return reservationList.size();
    }
}
