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
    private EditText lastName, firstName, birthDay;
    private String lastNameText, firstNameText, birthDayText;
    private Integer age;
    private SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        preferences = PreferenceManager.getDefaultSharedPreferences(Profil.this);

        lastName = findViewById(R.id.Nom);
        firstName = findViewById(R.id.Prenom);
        birthDay = findViewById(R.id.Date);

        if (preferences.contains("lastname") && preferences.contains("firstname") && preferences.contains("birthday")) {
            lastName.setText(preferences.getString("lastname", "Nom"));
            firstName.setText(preferences.getString("firstname", "Prenom"));
            birthDay.setText(preferences.getString("birthday", "Date de naissance"));
        }

        validate = findViewById(R.id.validate);
        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastNameText = lastName.getText().toString();
                firstNameText = firstName.getText().toString();
                birthDayText = birthDay.getText().toString();
                age = getAge(birthDayText);
                if (checkFormat(lastNameText, firstNameText, birthDayText) && age >= 1 && age <= 130) {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("lastname", lastNameText);
                    editor.putString("firstname", firstNameText);
                    editor.putString("birthday", birthDayText);
                    editor.putInt("age", age);
                    editor.commit();
                    Intent intent = new Intent(Profil.this, MainActivity.class);
                    intent.putExtra("age", age);
                    startActivity(intent);
                } else {
                    Toast toast = Toast.makeText(Profil.this, "Veuillez renseigner votre profil", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }

    public Boolean checkFormat(String nom, String prenom, String dateDeNaissance) {
        String regexText = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
        String regexDate = "^(1[0-9]|0[1-9]|3[0-1]|2[1-9])/(0[1-9]|1[0-2])/[0-9]{4}$";
        if (!nom.matches(regexText)) {
            lastName.setError("Erreur format");
            return false;
        }
        if (!prenom.matches(regexText)) {
            firstName.setError("Erreur format");
            return false;
        }
        if (!dateDeNaissance.matches(regexDate)) {
            birthDay.setError("Mauvais format de date");
            return false;
        }
        return true;
    }

    public Integer getAge(String dateText) {
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
            Log.i("ParseException", "Exception: " + e);
        }
        return age;
    }
}
