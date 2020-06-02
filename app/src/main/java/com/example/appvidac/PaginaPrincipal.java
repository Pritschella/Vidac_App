package com.example.appvidac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PaginaPrincipal extends AppCompatActivity {
    ImageButton doc, act, enf, barber, mensa, far, resta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_principal);
        doc = findViewById(R.id.imageButton);
        enf=findViewById(R.id.enf);
        barber=findViewById(R.id.barber);
        mensa=findViewById(R.id.mensa);
        far=findViewById(R.id.farm);
        resta=findViewById(R.id.resta);

        doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Doctores.class);
                startActivity(intent);
            }
        });

        act = findViewById(R.id.imacti);
        act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Actividades.class);
                startActivity(intent);
            }
        });

        enf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Enfermeros.class);
                startActivity(intent);
            }
        } );

        mensa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Mandaderos.class);
                startActivity(intent);
            }
        } );

        barber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Barberos.class);
                startActivity(intent);
            }
        } );

        far.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Farmacias.class);
                startActivity(intent);
            }
        } );

        resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Restaurantes.class);
                startActivity(intent);
            }
        } );
    }
}

