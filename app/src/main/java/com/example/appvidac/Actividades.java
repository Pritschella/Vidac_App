package com.example.appvidac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import API.ActividadesAPI;
import API.DoctoresAPI;

public class Actividades extends AppCompatActivity {
    RecyclerView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades);

        lista = (RecyclerView)findViewById(R.id.lista);

        ActividadesAPI data = new ActividadesAPI(lista, this.getApplicationContext());
        data.execute();
    }
}
