package com.example.appvidac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton inicioSesion, registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicioSesion = (ImageButton)findViewById(R.id.imBu_InicioSesion);
        registro = (ImageButton)findViewById(R.id.imBu_registro);

        inicioSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent InicioSesion = new Intent(MainActivity.this,inicio_sesion.class);
                startActivity(InicioSesion);
            }
        });

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Registro = new Intent(v.getContext(), com.example.appvidac.Registro.class);
                startActivity(Registro);
            }
        });





    }
}
