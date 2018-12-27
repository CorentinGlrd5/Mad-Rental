package com.corentin.mad_rental;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    private Button reservations, profile, search;
    private EditText beginDate, endDate;
    private String beginDateText, endDateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(MainActivity.this, Reservation.class);
        Typeface maFontBold = Typeface.createFromAsset(getAssets(),
                "font/Roboto-BlackItalic.ttf");
        TextView textView = findViewById(R.id.pageHome_title);
        textView.setTypeface(maFontBold);

        reservations = findViewById(R.id.reservations);
        reservations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Reservation.class);
                startActivity(intent);
            }
        });

        profile = findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Profil.class);
                startActivity(intent);
            }
        });

        search = findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beginDate = findViewById(R.id.begin_date);
                beginDateText = beginDate.getText().toString();
                endDate = findViewById(R.id.end_date);
                endDateText = endDate.getText().toString();
                if (checkDate(beginDateText) || checkDate(endDateText)) {
                    Intent intent = new Intent(MainActivity.this, Search.class);
                    startActivity(intent);
                } else {
                    Toast toast = Toast.makeText(MainActivity.this, "Date non valide", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }

    // Ajouter une verification pour voir si les dates se suivent et une verif pour voir si la date est passée
    public Boolean checkDate (String date){
        if (date == null || !date.matches("^(1[0-9]|0[1-9]|3[0-1]|2[1-9])/(0[1-9]|1[0-2])/[0-9]{4}$")) {
            return false;
        } else {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            try {
                format.parse(date);
                return true;
            } catch (ParseException e){
                return false;
            }
        }
    }
}
