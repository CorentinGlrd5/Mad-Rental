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
    private List<Vehicle> vehiclesList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        recyclerView = findViewById(R.id.reservation_list);
        adapter = new ReservationAdapter(vehiclesList, getApplicationContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        dataFeed();
    }

    private void dataFeed() {
        Vehicle vehicle =  new Vehicle("Buggy", "24$", "https://i.ytimg.com/vi/ERSBfT-mkmw/maxresdefault.jpg", "24/07/16", "30/07/16");
        vehiclesList.add(vehicle);
        vehicle =  new Vehicle("Camion", "34$", "https://imgix.ranker.com/user_node_img/50043/1000852838/original/the-gigahorse-photo-u1?w=650&q=50&fm=jpg&fit=crop&crop=faces", "24/07/16", "30/07/16");
        vehiclesList.add(vehicle);
        vehicle =  new Vehicle("Bateau", "54$", "http://img4.autodeclics.com/photo_article/70106/7523/1200-L-mad-max-fury-road-les-voitures-du-film.jpg", "24/07/16", "30/07/16");
        vehiclesList.add(vehicle);
        vehicle =  new Vehicle("Buggy", "24$", "https://shortlist.imgix.net/app/uploads/2017/08/24211833/53113ad650c45eb0d6551fa624068912-827x551.jpg?w=1200&h=1&fit=max&auto=format%2Ccompress", "24/07/16", "30/07/16");
        vehiclesList.add(vehicle);
        vehicle =  new Vehicle("Buggy", "24$", "https://blog.allopneus.com/wp-content/uploads/2015/04/MMFR_PlymouthRock-876x534.jpg", "24/07/16", "30/07/16");
        vehiclesList.add(vehicle);
    }
}
