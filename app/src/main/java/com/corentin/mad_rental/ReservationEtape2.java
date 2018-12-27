package com.corentin.mad_rental;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class ReservationEtape2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_etape2);
        Intent intent = getIntent();
        int valueSwitch1 = intent.getIntExtra("ValeurSwitch1", 0);
        int valueSwitch2 = intent.getIntExtra("ValeurSwitch2", 0);
        int prixFinal = valueSwitch1 + valueSwitch2;
        TextView textView = (TextView) findViewById(R.id.finalPrice);
        textView.setText("Prix final : " + prixFinal);
    }


    public void validationReserve2(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
