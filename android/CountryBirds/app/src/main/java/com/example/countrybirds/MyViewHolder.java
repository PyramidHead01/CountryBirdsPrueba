package com.example.countrybirds;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    private TextView nombreTV;
    private TextView paisTV;

    public MyViewHolder(View itemView) {
        super(itemView);

        nombreTV = itemView.findViewById(R.id.textNombre);
        paisTV = itemView.findViewById(R.id.textPais);

    }

    public TextView getNombreTV() {
        return nombreTV;
    }

    public TextView getPaisTV() {
        return paisTV;
    }

}
