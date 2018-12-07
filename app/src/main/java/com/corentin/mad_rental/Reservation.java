package com.corentin.mad_rental;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Reservation extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ReservationAdapter adapter;
    private List<Vehicle> vehiclesList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        recyclerView = findViewById(R.id.reservation_list);
        adapter = new ReservationAdapter(vehiclesList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        dataFeed();
    }

    private void dataFeed() {
        Vehicle vehicle =  new Vehicle("Buggy", "24$", "24/07/16", "30/07/16");
        vehiclesList.add(vehicle);
        vehicle =  new Vehicle("Camion", "34$", "24/07/16", "30/07/16");
        vehiclesList.add(vehicle);
        vehicle =  new Vehicle("Bateau", "54$", "24/07/16", "30/07/16");
        vehiclesList.add(vehicle);
        vehicle =  new Vehicle("Buggy", "24$", "24/07/16", "30/07/16");
        vehiclesList.add(vehicle);
        vehicle =  new Vehicle("Buggy", "24$", "24/07/16", "30/07/16");
        vehiclesList.add(vehicle);
    }
}
