package com.corentin.mad_rental;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> {
    private List<Vehicle> searchList;
    private Context context;
    private Integer diff;
    private String beginDate, endDate;

    public SearchAdapter (List<Vehicle> searchList, Context context, String beginDate, String endDate, Integer diff){
        this.searchList = searchList;
        this.context = context;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.diff = diff;
    }

    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.vehicles, parent, false);
        SearchViewHolder searchViewHolder = new SearchViewHolder(item);
        return searchViewHolder;
    }

    @Override
    public void onBindViewHolder(final SearchViewHolder holder, int position) {
        Vehicle vehicle = searchList.get(position);
        holder.title.setText(vehicle.getName());
        holder.price.setText(vehicle.getPrice() + " € / jour ");
        holder.pollution.setText("Catégorie CO2: " + vehicle.getCategorieco2());
        Glide.with(context).load("http://s519716619.onlinehome.fr/exchange/madrental/images/"+vehicle.getImage()).into(holder.image);
        onClick(vehicle, holder);
    }

    @Override
    public int getItemCount() {
        return searchList.size();
    }

    private void onClick(final Vehicle vehicle, final SearchViewHolder holder){
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), ReservationItem.class);
                intent.putExtra("id", vehicle.getId());
                intent.putExtra("name", vehicle.getName());
                intent.putExtra("image", "http://s519716619.onlinehome.fr/exchange/madrental/images/"+vehicle.getImage());
                intent.putExtra("price", vehicle.getPrice());
                intent.putExtra("categoryco2", vehicle.getCategorieco2());
                intent.putExtra("equipments", (Serializable) vehicle.getEquipments());
                intent.putExtra("options", (Serializable) vehicle.getOptions());
                intent.putExtra("beginDate", beginDate);
                intent.putExtra("endDate", endDate);
                intent.putExtra("diff", diff);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }
}