package com.example.appvidac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import API.BarberosAPI;
import API.EnfermerosAPI;

public class Enfermeros extends AppCompatActivity {
    RecyclerView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enfermeros);
        lista = (RecyclerView)findViewById(R.id.lista);

        EnfermerosAPI data = new EnfermerosAPI(lista, this.getApplicationContext());
        data.execute();
    }
}
