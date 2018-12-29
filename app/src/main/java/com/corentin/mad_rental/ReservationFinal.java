package com.corentin.mad_rental;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ReservationFinal extends AppCompatActivity {

    Integer price, total, diff;
    String name, image, beginDate, endDate;
    List<Integer> optionPrice;
    TextView totalContainer;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_final);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        image = intent.getStringExtra("image");
        price = intent.getIntExtra("price", 0);
        diff = intent.getIntExtra("diff", 0);
        beginDate = intent.getStringExtra("beginDate");
        endDate = intent.getStringExtra("endDate");

        total = price * diff;
        optionPrice = (List<Integer>) intent.getSerializableExtra("option");
        for (Integer itemPrice : optionPrice){
            total += itemPrice;
        }

        totalContainer = findViewById(R.id.total);
        totalContainer.setText("Prix final: "+ total + " €");

        submit = findViewById(R.id.reserved);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReservedVehicleDbHelper dbHelper = new ReservedVehicleDbHelper(ReservationFinal.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(ReservedVehicleContract.ReservedVehiclesEntry.COLUMN_NAME, name);
                values.put(ReservedVehicleContract.ReservedVehiclesEntry.COLUMN_IMAGE, image);
                values.put(ReservedVehicleContract.ReservedVehiclesEntry.COLUMN_PRICE, total);
                values.put(ReservedVehicleContract.ReservedVehiclesEntry.COLUMN_BEGIN_DATE, beginDate);
                values.put(ReservedVehicleContract.ReservedVehiclesEntry.COLUMN_END_DATE, endDate);
                long newRow = db.insert(ReservedVehicleContract.ReservedVehiclesEntry.TABLE_NAME, null, values);
                db.close();
                dbHelper.close();
                Intent intent = new Intent(ReservationFinal.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
