package com.example.appvidac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import API.DoctoresAPI;
import Adapters.ServiciosAdapter;

import static androidx.recyclerview.widget.LinearLayoutManager.VERTICAL;

public class Doctores extends AppCompatActivity {
    RecyclerView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctores);

        lista = (RecyclerView)findViewById(R.id.lista);

        DoctoresAPI data = new DoctoresAPI(lista, this.getApplicationContext());
        data.execute();



    }
}
