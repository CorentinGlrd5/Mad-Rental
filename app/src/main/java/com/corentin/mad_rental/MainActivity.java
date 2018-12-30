package com.corentin.mad_rental;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    private Button reservations, profile, search;
    private EditText beginDate, endDate;
    private String beginDateText, endDateText;
    private Integer age;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Typeface maFontBold = Typeface.createFromAsset(getAssets(),
                "font/Roboto-BlackItalic.ttf");
        TextView textView = findViewById(R.id.pageHome_title);
        textView.setTypeface(maFontBold);
        preferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        if (preferences.contains("age")) {
            age = preferences.getInt("age", 6);
        } else {
            SharedPreferences.Editor editor = preferences.edit();
            age = getIntent().getIntExtra("age", 0);
            editor.putInt("age", age);
            editor.commit();
        }
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
                Integer days = diffDate(beginDateText, endDateText);
                if (age != 0) {
                    if (checkDate(beginDateText, endDateText) && days != 0) {
                        Intent intent = new Intent(MainActivity.this, Search.class);
                        intent.putExtra("beginDate", beginDateText);
                        intent.putExtra("endDate", endDateText);
                        intent.putExtra("diff", days);
                        intent.putExtra("age", age);
                        startActivity(intent);
                    }
                } else {
                    Toast toast = Toast.makeText(MainActivity.this, "Veuillez renseigner votre profil", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }

    public Boolean checkDate(String firstDate, String lastDate) {
        String regex = "^(1[0-9]|0[1-9]|3[0-1]|2[1-9])/(0[1-9]|1[0-2])/[0-9]{4}$";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if (!firstDate.matches(regex)) {
            beginDate.setError("Mauvais format de date");
            return false;
        }
        if (!lastDate.matches(regex)){
            endDate.setError("Mauvais format de fate");
            return false;
        }
        try {
            Date beginDateParsed = sdf.parse(firstDate);
            Date endDateParsed = sdf.parse(lastDate);
            Date now = new Date();
            Date today = sdf.parse(sdf.format(now));
            if (beginDateParsed.compareTo(endDateParsed) >= 0) {
                endDate.setError("Les dates ne se suivent pas");
                return false;
            } else if (beginDateParsed.compareTo(today) < 0) {
                beginDate.setError("Date dépassée");
                return false;
            } else if (endDateParsed.compareTo(today) < 0){
                endDate.setError("Date dépassée");
                return false;
            } else {
                return true;
            }
        } catch (ParseException e) {
            return false;
        }
    }

    public Integer diffDate(String firstDate, String lastDate) {
        Integer days = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date beginDate = sdf.parse(firstDate);
            Date endDate = sdf.parse(lastDate);
            long diff = (endDate.getTime() - beginDate.getTime())/1000/3600/24;
            days = (int) diff;
        } catch (ParseException e) {
            Log.i("ParseException", "Exception: "+e);
        }
        return days;
    }
}
