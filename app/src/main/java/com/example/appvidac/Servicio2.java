package com.example.appvidac;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Servicio2 {
    private int id,telefono, idfoto;
    private String nombre, apellidos, direccion, horario, genero, descripcion, correo, pass, disponibilidad, foto;

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getIdfoto() {
        return idfoto;
    }

    public void setIdfoto(int idfoto) {
        this.idfoto = idfoto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Servicio2 createFromJSONObject(JSONObject data){
        try {
            this.nombre = data.getString("Nombre");
            this.apellidos = data.getString("Apellidos");
            this.direccion = data.getString("Direccion");
            this.telefono = data.getInt("Telefono");
            this.descripcion = data.getString("Descripcion");
            this.foto = data.getString("foto_url");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Override
    public String toString() {
        return "Servicio2{" +
                "id=" + id +
                ", telefono=" + telefono +
                ", idfoto=" + idfoto +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", direccion='" + direccion + '\'' +
                ", horario='" + horario + '\'' +
                ", genero='" + genero + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", correo='" + correo + '\'' +
                ", pass='" + pass + '\'' +
                ", disponibilidad='" + disponibilidad + '\'' +
                ", foto='" + foto + '\'' +
                '}';
    }
}
