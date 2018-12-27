package com.corentin.mad_rental;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class ReservationFinal extends AppCompatActivity {

    Integer price, total;
    List<Integer> optionPrice;
    TextView totalContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_final);
        Intent intent = getIntent();
        price = intent.getIntExtra("price", 0);
        total = price;
        optionPrice = (List<Integer>) intent.getSerializableExtra("option");
        for (Integer itemPrice : optionPrice){
            total += itemPrice;
        }
        totalContainer = findViewById(R.id.total);
        totalContainer.setText("Prix final: "+ total + " €");
    }
}
