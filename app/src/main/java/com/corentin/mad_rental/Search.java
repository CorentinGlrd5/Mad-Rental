package com.corentin.mad_rental;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Intent intent = getIntent();
        diff = intent.getIntExtra("diff", 0);
        beginDate = intent.getStringExtra("beginDate");
        endDate = intent.getStringExtra("endDate");
        gson = new Gson();
        recyclerView = findViewById(R.id.search_list);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams requestParams = new RequestParams();
        requestParams.put("datedebut", beginDate);
        requestParams.put("datefin", endDate);
        requestParams.put("agemin", 15);
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