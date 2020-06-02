package com.example.appvidac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import API.RestaurantesAPI;

public class Restaurantes extends AppCompatActivity {
    RecyclerView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurantes);

        lista = (RecyclerView)findViewById(R.id.lista);

        RestaurantesAPI data = new RestaurantesAPI(lista, this.getApplicationContext());
        data.execute();
    }
}
