package com.example.appvidac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class inicio_sesion extends AppCompatActivity {
    RequestQueue rq;
    EditText correo, contrasenia;
    Button Ingresar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
        correo = findViewById(R.id.editTextCorreo);
        contrasenia = findViewById(R.id.editTextContraseña);
        Ingresar = findViewById(R.id.btnIngresar);
        Ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarSesion("http://192.168.1.95/Vidac/validar_usuario.php");
            }
        });
    }


    private void iniciarSesion(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                if (!response.isEmpty()){
                    Intent intent = new Intent(getApplicationContext(), PaginaPrincipal.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(inicio_sesion.this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(inicio_sesion.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("Correo", correo.getText().toString());
                parametros.put("Contraseña", contrasenia.getText().toString());
                return parametros;
            }
        };

        rq=Volley.newRequestQueue(this);
        rq.add(stringRequest);
    }

}
