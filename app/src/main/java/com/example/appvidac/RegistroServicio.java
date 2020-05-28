package com.example.appvidac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class RegistroServicio extends AppCompatActivity {
    private Button btnBuscar, btnRegistrar;
    private ImageView imageView;
    private EditText Nombre, Apellidos, Edad, Direccion, Telefono, Parentesco, Correo, Pass;
    private Spinner Genero;
    private Bitmap bitmap;

    private int PICK_IMAGE_REQUEST = 1;
    Context context;

    private String UPLOAD_URL ="http://192.168.1.95/Vidac/SubirFotoServicio.php";
    private String RegisterClientURL ="http://192.168.1.95/Vidac/RegistrarServicio.php";
    private String KEY_IMAGEN = "Foto";
    private String KEY_NOMBRE = "Nombre";
    private String KEY_APELLIDO = "Apellidos";
    private String KEY_EDAD = "Edad";
    private String KEY_TELEFONO = "Telefono";
    private String KEY_DIRECCION = "Direccion";
    private String KEY_CORREO = "Correo";
    private String KEY_PASS = "Pass";
    private String KEY_GENERO = "Genero";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_servicio);
    }
}
