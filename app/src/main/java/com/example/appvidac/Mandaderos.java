package com.example.appvidac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import API.BarberosAPI;
import API.MandaderosAPI;

public class Mandaderos extends AppCompatActivity {
    RecyclerView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mandaderos);

        lista = (RecyclerView)findViewById(R.id.lista);

        MandaderosAPI data = new MandaderosAPI(lista, this.getApplicationContext());
        data.execute();
    }
}
