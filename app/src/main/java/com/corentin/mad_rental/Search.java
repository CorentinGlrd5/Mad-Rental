package com.corentin.mad_rental;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class Search extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SearchAdapter adapter;
    private List<Vehicle> searchList = new ArrayList<>();
    private Integer diff;
    private String beginDate, endDate;
    private Gson gson;
    private LinearLayout filter;
    private View overlay;
    private Switch sw;
    private Boolean click;
    private Integer age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Intent intent = getIntent();
        diff = intent.getIntExtra("diff", 0);
        beginDate = intent.getStringExtra("beginDate");
        endDate = intent.getStringExtra("endDate");
        age = intent.getIntExtra("age", 0);

        filter = findViewById(R.id.filter);
        sw = findViewById(R.id.promo_switch);
        filter.animate().translationY(200).setDuration(1);

        gson = new Gson();
        recyclerView = findViewById(R.id.search_list);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        getSearchList(0);

        click = false;

        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                overlay = findViewById(R.id.overlay);
                if (!click) {
                    filter.animate().translationY(0).setDuration(500);
                    overlay.animate().alpha(0.5f).setDuration(1000);
                    click = !click;
                } else {
                    filter.animate().translationY(200).setDuration(500);
                    overlay.animate().alpha(0).setDuration(250);
                    if(sw.isChecked()){
                        sw.setChecked(false);
                    }
                    click = !click;
                }
            }
        });

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    getSearchList(1);
                } else {
                    getSearchList(0);
                }
            }
        });
    }

    private void getSearchList(Integer promotion){
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams requestParams = new RequestParams();
        requestParams.put("datedebut", beginDate);
        requestParams.put("datefin", endDate);
        requestParams.put("agemin", age);
        requestParams.put("promotion", promotion);
        client.get("http://s519716619.onlinehome.fr/exchange/madrental/get-vehicules.php", requestParams, new TextHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, String response) {
                // called when response HTTP status is "200 OK"
                Type listType = new TypeToken<List<Vehicle>>(){}.getType();
                List<Vehicle> searchList = gson.fromJson(response, listType);
                adapter = new SearchAdapter(searchList, getApplicationContext(), beginDate, endDate, diff);
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, String errorResponse, Throwable e) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
            }
        });
    }
}