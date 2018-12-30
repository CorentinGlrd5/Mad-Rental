package com.corentin.mad_rental;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Profil extends AppCompatActivity {

    private Button validate;
    private EditText nom, prenom, dateDeNaissance;
    private String nomText, prenomText, dateText;
    private Integer age, dateNaissance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        Log.i("onCreate age : ", String.valueOf(age));
        Log.i("onCreate dateNaissan: ", String.valueOf(dateNaissance));

        validate = findViewById(R.id.validate);
        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nom = findViewById(R.id.Nom);
                nomText = nom.getText().toString();
                prenom = findViewById(R.id.Prenom);
                prenomText = prenom.getText().toString();
                dateDeNaissance = findViewById(R.id.Date);
                dateText = dateDeNaissance.getText().toString();
                age = checkDate(dateText);
                if (checkValues(nomText, prenomText, dateText) && age != 0) {
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(Profil.this);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("Name", nomText);
                    editor.putString("LastName", prenomText);
                    editor.putInt("age", age);
                    editor.commit();
                    dateNaissance = preferences.getInt("age", age);
                    Log.i("onClick: ", String.valueOf(dateNaissance));
                    int valeur = preferences.getInt("age", age);
                    Intent intent = new Intent(Profil.this, MainActivity.class);
                    intent.putExtra("nom", nomText);
                    intent.putExtra("prenom", prenomText);
                    intent.putExtra("date", dateText);
                    startActivity(intent);
                } else {
                    Toast toast = Toast.makeText(Profil.this, "Champs non remplis", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }

    public Boolean checkValues(String nom, String prenom, String dateDeNaissance) {
        String regexText = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
        String regexDate = "^(1[0-9]|0[1-9]|3[0-1]|2[1-9])/(0[1-9]|1[0-2])/[0-9]{4}$";
        if (nom == null || !nom.matches(regexText) || prenom == null || !prenom.matches(regexText) || dateDeNaissance == null || !dateDeNaissance.matches(regexDate)) {
            return false;
        } else {
            return true;
        }
    }

    public Integer checkDate(String dateText) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Integer age = 0;
        try {
            Date firstDate = sdf.parse(dateText);
            Date date = new Date();
            String today = sdf.format(date);
            Date dateToday = sdf.parse(today);
            double years = (dateToday.getTime() - firstDate.getTime()) / 1000 / 3600 / 24 / 365.25;
            age = (int) Math.floor(years);
        } catch (ParseException e) {
        }
        return age;
    }
}
