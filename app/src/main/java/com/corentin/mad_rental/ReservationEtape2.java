package com.corentin.mad_rental;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ReservationEtape2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_etape2);
    }

    public void validationReserve2(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
