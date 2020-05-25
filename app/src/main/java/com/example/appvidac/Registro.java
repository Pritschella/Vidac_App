package com.example.appvidac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Registro extends AppCompatActivity {

    Button btnRegresar;
    ImageButton btnServicio, btnCliente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnRegresar = (Button)findViewById(R.id.btn_regresar);
        btnServicio = (ImageButton)findViewById(R.id.imBu_servicio);
        btnCliente = (ImageButton)findViewById(R.id.imBu_cliente);


        btnServicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registroServicio  = new Intent(v.getContext(), RegistroServicio.class);
                startActivity(registroServicio);
            }
        });

        btnCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registroCliente = new Intent(v.getContext(), RegistroCliente.class);
                startActivity(registroCliente);
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent inicioSesion = new Intent(MainActivity.this, inicio_sesion.class);
                Intent regresar = new Intent(Registro.this, MainActivity.class);
                startActivity(regresar);
            }
        });


    }
}
