package com.corentin.mad_rental;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Profil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
    }

    public void validerProfil(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
