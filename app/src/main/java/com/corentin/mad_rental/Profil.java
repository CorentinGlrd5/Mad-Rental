package com.corentin.mad_rental;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class Profil extends AppCompatActivity {
    EditText nom;
    EditText prenom;
    EditText dateDeNaissance;


    public final static String NOM = "Nom";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        nom = findViewById(R.id.Nom);
        prenom = findViewById(R.id.Prenom);
        dateDeNaissance = findViewById(R.id.Date);
    }

    public void validerProfil(View view) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String valeurNom = nom.getText().toString();
        String valeurPrenom = prenom.getText().toString();
        String valeurDate = dateDeNaissance.getText().toString();

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(NOM, valeurNom);
        editor.putString(NOM, valeurPrenom);
        editor.putString(NOM, valeurDate);
        editor.commit();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        String nom = preferences.getString(NOM, valeurNom);
        String prenom = preferences.getString(NOM, valeurPrenom);
        String dateDeNaissance = preferences.getString(NOM, valeurDate);

        Toast.makeText(this, "Bonjour " + nom + " " + prenom + "Vous avez " + dateDeNaissance, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }
}
