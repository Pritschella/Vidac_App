package com.example.appvidac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class RegistroCliente extends AppCompatActivity implements View.OnClickListener{


    private int PICK_IMAGE_REQUEST = 1;

    private String UPLOAD_URL ="https://192.168.1.95/Vidac/SubirFoto.php";

    private String KEY_IMAGEN = "Foto";
    private String KEY_NOMBRE = "Nombre";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_cliente);
    }




    @Override
    public void onClick(View v) {

    }
}
