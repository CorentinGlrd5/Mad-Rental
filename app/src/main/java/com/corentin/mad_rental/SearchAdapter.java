package com.corentin.mad_rental;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> {
    private List<Vehicle> searchList;
    private Context context;

    public SearchAdapter (List<Vehicle> searchList, Context context){
        this.searchList = searchList;
        this.context = context;
    }

    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.vehicles, parent, false);
        SearchViewHolder searchViewHolder = new SearchViewHolder(item);
        return searchViewHolder;
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {
        Vehicle vehicle = searchList.get(position);
        holder.title.setText(vehicle.getName());
        holder.price.setText(vehicle.getPrice() + " € / jour ");
        holder.pollution.setText("Catégorie CO2: " + vehicle.getCategorieco2());
        Glide.with(context).load("http://s519716619.onlinehome.fr/exchange/madrental/images/"+vehicle.getImage()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return searchList.size();
    }
}