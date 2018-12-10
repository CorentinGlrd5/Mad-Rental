package com.corentin.mad_rental;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Reservation extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ReservationAdapter adapter;
    private List<Vehicle> reservationList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        recyclerView = findViewById(R.id.reservation_list);
        adapter = new ReservationAdapter(reservationList, getApplicationContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
