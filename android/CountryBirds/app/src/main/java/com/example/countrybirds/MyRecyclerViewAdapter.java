package com.example.countrybirds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<PajaroDTO> listaPajaros;
    private Context context;

    private TextView nombreTV;
    private TextView paisTV;

    public MyRecyclerViewAdapter(List listaPajaros, Context context){
        this.listaPajaros = listaPajaros;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_item, parent, false);

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        nombreTV = holder.getNombreTV();
        paisTV = holder.getPaisTV();

        String name = listaPajaros.get(position).getNombre();
        String pais = listaPajaros.get(position).getPais();

        nombreTV.setText(name);
        paisTV.setText(pais);

    }

    @Override
    public int getItemCount() {
        return listaPajaros.size();
    }
}
