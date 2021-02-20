package com.example.countrybirds;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity {

    private TextView miTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miTextView = findViewById(R.id.textView2);

        GetRequest();

    }

    void GetRequest(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://192.168.0.12:8000/birds/backend/1/pajaro";
        String url2 ="http://10.0.2.16/birds/backend/1/pajaro";
        String url1 = "https://cat-fact.herokuapp.com/facts";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        miTextView.setText(response.toString());
                        Log.d("GET REQUEST", "PETICION GET CONSEGUIDA");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        miTextView.setText(error.toString());
                        Log.d("GET REQUEST", error.toString());
                    }
                });

        queue.add(jsonArrayRequest);
    }

}