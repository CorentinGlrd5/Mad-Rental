package com.corentin.mad_rental;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(MainActivity.this, Reservation.class);
        Typeface maFontBold = Typeface.createFromAsset(getAssets(),
                "font/Roboto-BlackItalic.ttf");
        TextView textView = findViewById(R.id.pageHome_title);
        textView.setTypeface(maFontBold);
    }

    public void MesReservations(View view) {
        Intent intent = new Intent(this, Search.class);
        startActivity(intent);

    }

    public void MonProfil(View view) {
        Intent intent = new Intent(this, Profil.class);
        startActivity(intent);
    }

    public void Recherche(View view) {
        Intent intent = new Intent(this, Profil.class);
        startActivity(intent);
    }
}
