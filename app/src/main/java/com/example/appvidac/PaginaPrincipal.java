package com.example.appvidac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PaginaPrincipal extends AppCompatActivity {
    ImageButton doc, act;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_principal);
        doc = findViewById(R.id.imageButton);
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
    }
}

