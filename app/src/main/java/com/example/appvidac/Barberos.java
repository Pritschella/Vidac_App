package com.example.appvidac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import API.ActividadesAPI;
import API.BarberosAPI;

public class Barberos extends AppCompatActivity {
    RecyclerView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barberos);

        lista = (RecyclerView)findViewById(R.id.lista);

        BarberosAPI data = new BarberosAPI(lista, this.getApplicationContext());
        data.execute();
    }
}
