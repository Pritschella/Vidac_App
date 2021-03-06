package com.example.appvidac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import API.BarberosAPI;
import API.FarmaciasAPI;

public class Farmacias extends AppCompatActivity {
    RecyclerView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmacias);

        lista = (RecyclerView)findViewById(R.id.lista);

        FarmaciasAPI data = new FarmaciasAPI(lista, this.getApplicationContext());
        data.execute();
    }
}
