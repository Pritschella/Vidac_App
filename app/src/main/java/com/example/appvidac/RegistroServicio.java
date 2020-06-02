package com.example.appvidac;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

public class RegistroServicio extends AppCompatActivity implements View.OnClickListener{
    private Button btnBuscarf, btnBuscarc, btnRegistrars;
    private ImageView imageViewf, imageViewc;
    private EditText Nombre, Apellidos, Direccion, Telefono, Horario, Descripcion, Correo, Pass;
    private Spinner Genero, Servicio;
    private Bitmap bitmap;

    private int PICK_IMAGE_REQUEST = 1;
    Context context;

    private String UPLOAD_URL ="http://192.168.1.95/Vidac/SubirFotoServicio.php";
    private String RegisterClientURL ="http://192.168.1.95/Vidac/RegistrarServicio.php";
    private String KEY_IMAGEN = "Foto";
    private String KEY_NOMBRE = "Nombre";
    private String KEY_APELLIDO = "Apellidos";
    private String KEY_HORARIO = "Horario";
    private String KEY_DESCRIPCION = "Descripcion";
    private String KEY_TELEFONO = "Telefono";
    private String KEY_DIRECCION = "Direccion";
    private String KEY_CORREO = "Correo";
    private String KEY_PASS = "Pass";
    private String KEY_GENERO = "Genero";
    private String KEY_DISPONIBLE = "Disponibilidad";
    private String KEY_SERVICIO = "Servicio";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_servicio);

        btnBuscarf=findViewById(R.id.btnBuscarSer);
        btnBuscarc=findViewById(R.id.btnBuscarSer2);
        btnRegistrars=findViewById(R.id.btnRegistrarSer);
        imageViewf=findViewById(R.id.imageViewf);
        imageViewc=findViewById(R.id.imageViewCredencial);

        Nombre=findViewById(R.id.NombresSer);
        Apellidos=findViewById(R.id.ApellidosSer);
        Horario=findViewById(R.id.HorarioSer);
        Direccion=findViewById(R.id.DireccionSer);
        Telefono=findViewById(R.id.TelefonoSer);
        Genero=findViewById(R.id.spinner2);
        Servicio=findViewById(R.id.Tipo);
        Correo=findViewById(R.id.CorreoSer);
        Pass=findViewById(R.id.PassSer);
        Descripcion=findViewById(R.id.DescripcionSer);

        btnBuscarf.setOnClickListener(this);
        btnBuscarc.setOnClickListener(this);
        btnRegistrars.setOnClickListener(this);
    }

    public String getStringImagen(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    public void uploadImage(String URL){
        final ProgressDialog loading = ProgressDialog.show(this,"Subiendo...","Espere por favor...",false,false);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        //Descartar el diálogo de progreso
                        loading.dismiss();
                        //Mostrando el mensaje de la respuesta
                        Toast.makeText(getApplicationContext(), s , Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                loading.dismiss();
                String message = null;
                if (volleyError instanceof NetworkError) {
                    message = "Cannot connect to Internet...Please check your connection!";
                } else if (volleyError instanceof ServerError) {
                    message = "The server could not be found. Please try again after some time!!";
                } else if (volleyError instanceof AuthFailureError) {
                    message = "Cannot connect to Internet...Please check your connection!";
                } else if (volleyError instanceof ParseError) {
                    message = "Parsing error! Please try again after some time!!";
                } else if (volleyError instanceof NoConnectionError) {
                    message = "Cannot connect to Internet...Please check your connection!";
                } else if (volleyError instanceof TimeoutError) {
                    message = "Connection TimeOut! Please check your internet connection.";
                }
                Toast.makeText(RegistroServicio.this, message, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), volleyError.getMessage(), Toast.LENGTH_LONG).show();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError{
                String imagen = getStringImagen(bitmap);

                String nombre = Nombre.getText().toString().trim();
                Map<String, String> params = new Hashtable<String, String>();

                params.put(KEY_IMAGEN, imagen);
                params.put(KEY_NOMBRE, nombre);
                return params;
            }
        };


        RequestQueue requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(stringRequest);
    }
    private void showFileChooser(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Imagen"), PICK_IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {
                //Cómo obtener el mapa de bits de la Galería
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                //Configuración del mapa de bits en ImageView
               if (im==1){
                    Toast.makeText(this, "hola", Toast.LENGTH_LONG).show();
               imageViewf.setImageBitmap(bitmap);
                }
                if(im==2){
                    imageViewc.setImageBitmap(bitmap);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    public void RegistrarServicio(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String s) {
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getApplicationContext(), volleyError.getMessage(), Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError{

                String nombre = Nombre.getText().toString();
                String apellidos = Apellidos.getText().toString();
                String horario = Horario.getText().toString();
                String telefono = Telefono.getText().toString();
                String direccion = Direccion.getText().toString();
                String correo = Correo.getText().toString();
                String pass = Pass.getText().toString();
                String genero = Genero.getSelectedItem().toString();
                String descripcion = Descripcion.getText().toString();
                String servicio= Servicio.getSelectedItem().toString();

                Map<String, String> params = new Hashtable<>();

                params.put(KEY_NOMBRE, nombre);
                params.put(KEY_APELLIDO, apellidos);
                params.put(KEY_HORARIO, horario);
                params.put(KEY_TELEFONO, telefono);
                params.put(KEY_DIRECCION, direccion);
                params.put(KEY_CORREO, correo);
                params.put(KEY_PASS, pass);
                params.put(KEY_GENERO, genero);
                params.put(KEY_DESCRIPCION, descripcion);
                params.put(KEY_SERVICIO, servicio);
                params.put(KEY_DISPONIBLE, "Disponible");
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(stringRequest);
    }
    int im =0;
    @Override
    public void onClick(View v) {

        if(v == btnBuscarf){
            im=1;
            showFileChooser();

        }

        if(v == btnBuscarc){
            im=2;
            showFileChooser();
            uploadImage("http://192.168.1.95/Vidac/SubirFotoServicio.php");
        }

        if (v==btnRegistrars){
            //uploadImage("http://192.168.1.95/Vidac/SubirFotoServicio.php");
            uploadImage("http://192.168.1.95/Vidac/SubirCredencialServicio.php");
            RegistrarServicio("http://192.168.1.95/Vidac/RegistrarServicio.php");
        }
    }
}
