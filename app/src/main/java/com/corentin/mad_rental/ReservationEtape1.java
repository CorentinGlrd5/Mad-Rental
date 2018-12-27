package com.corentin.mad_rental;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import static com.corentin.mad_rental.Profil.NOM;

public class ReservationEtape1 extends AppCompatActivity {
    Switch simpleSwitch1, simpleSwitch2;
    TextView textView, textView2;
    Button suivantReserve1;
    String statusSwitch1, statusSwitch2, valueTextView, valueTextView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_etape1);
        simpleSwitch1 = findViewById(R.id.simpleSwitch1);
        simpleSwitch2 = findViewById(R.id.simpleSwitch2);
        suivantReserve1 = findViewById(R.id.submitButton);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        suivantReserve1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (simpleSwitch1.isChecked()) {
                    statusSwitch1 = simpleSwitch1.getTextOn().toString();
                    valueTextView = textView.getText().toString();
                } else {
                    statusSwitch1 = simpleSwitch1.getTextOff().toString();
                }
                if (simpleSwitch2.isChecked()) {
                    statusSwitch2 = simpleSwitch2.getTextOn().toString();
                    valueTextView2 = textView2.getText().toString();
                } else {
                    statusSwitch2 = simpleSwitch2.getTextOff().toString();
                }
                Toast.makeText(getApplicationContext(), "Switch1 :" + statusSwitch1 + "\n" + "Switch2 :" + statusSwitch2, Toast.LENGTH_LONG).show(); // display the current state for switch's
                Toast.makeText(getApplicationContext(), "Switch1 :" + valueTextView + "\n" + "Switch2 :" + valueTextView2, Toast.LENGTH_LONG).show();
                TextView textView = findViewById(R.id.textView);
                textView.isSelected();
                Intent intent = new Intent(ReservationEtape1.this, ReservationEtape2.class);
                intent.putExtra("ValeurSwitch1", valueTextView);
                intent.putExtra("ValeurSwitch2", valueTextView2);
                startActivity(intent);
            }
        });
    }

    public void suivantReserve1(View view) {
        Intent intent = new Intent(this, ReservationEtape2.class);
        startActivity(intent);
    }
}


