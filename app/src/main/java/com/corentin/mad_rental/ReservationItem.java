package com.corentin.mad_rental;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

public class ReservationItem extends AppCompatActivity {
    LinearLayout equipments, options;
    TextView title, rent, category;
    ImageView thumbnail;
    Button submit;
    int id;
    String name, image, price;
    char categoryco2;
    List<Equipment> equipment;
    List<Option> option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_item);
        Intent intent = getIntent();

        id = intent.getIntExtra("id", 0);

        name = intent.getStringExtra("name");
        title = findViewById(R.id.item_title);
        title.setText(name);

        image = intent.getStringExtra("image");
        thumbnail = findViewById(R.id.item_image);
        Glide.with(getApplicationContext()).load(image).into(thumbnail);

        price = intent.getStringExtra("price");
        rent = findViewById(R.id.item_price);
        rent.setText(price + " € / jour");
        categoryco2 = intent.getCharExtra("categoryco2", 'h');
        category = findViewById(R.id.item_category);
        category.setText("" + categoryco2);
        equipment = (List<Equipment>) intent.getSerializableExtra("equipments");
        equipments = findViewById(R.id.item_equipments);
        for (Equipment item: equipment){
            TextView text = new TextView(this);
            text.setGravity(Gravity.END);
            text.setText(item.getName());
            equipments.addView(text);
        }
        option = (List<Option>) intent.getSerializableExtra("options");
        options = findViewById(R.id.item_options);
        for (Option item: option){
            LinearLayout option = new LinearLayout(this);
            option.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            option.setOrientation(LinearLayout.HORIZONTAL);
            option.setGravity(Gravity.CENTER_HORIZONTAL);
            Switch btn = new Switch(this);
            btn.setGravity(Gravity.START);
            btn.setId(item.getId());
            TextView text = new TextView(this);
            text.setGravity(Gravity.END);
            text.setText(item.getName()+": "+item.getPrice()+" €");
            option.addView(btn);
            option.addView(text);
            options.addView(option);
        }
        onSubmit(option);
    }

    private void onSubmit(final List<Option> option){
        submit = findViewById(R.id.item_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReservationItem.this, ReservationFinal.class);
                intent.putExtra("price", price);
                for (Option item: option){
                    int id = getResources().getIdentifier(String.valueOf(item.getId()), "id", getPackageName());
                    Switch sw = findViewById(id);
                    intent.putExtra("price"+item.getId(), item.getPrice());
                    Log.i("montag", "price"+item.getId());
                }
                startActivity(intent);
            }
        });
    }
}


