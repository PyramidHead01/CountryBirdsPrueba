package com.example.countrybirds;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //private TextView miTextView;
    private RecyclerView myRecyclerView;

    List<PajaroDTO> listaPajaros = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //miTextView = findViewById(R.id.textView2);

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

                        for(int i = 0; i < response.length(); i++){

                            try{

                                String nombre = response.getJSONObject(i).getString("nombre");
                                String pais = response.getJSONObject(i).getString("pais");

                                listaPajaros.add(new PajaroDTO(nombre, pais));

                            }catch(JSONException e){
                                e.printStackTrace();
                            }

                        }

                        MyRecyclerViewAdapter myAdapter = new MyRecyclerViewAdapter(listaPajaros, MainActivity.this);

                        //relaciona RecyclerViewAdapter con recicler view (el del xml)
                        RecyclerView recyclerView = findViewById(R.id.recyclerView);
                        recyclerView.setAdapter(myAdapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                        //miTextView.setText(response.toString());

                        Log.d("GET REQUEST", "PETICION GET CONSEGUIDA");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //miTextView.setText(error.toString());
                        Log.d("GET REQUEST", error.toString());
                    }
                });

        queue.add(jsonArrayRequest);
    }

}