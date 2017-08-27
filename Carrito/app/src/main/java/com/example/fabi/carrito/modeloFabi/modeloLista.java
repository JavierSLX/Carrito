package com.example.fabi.carrito.modeloFabi;

import android.widget.TextView;

/**
 * Created by Fabi on 27/08/2017.
 */

public class modeloLista {
    private String Nombre;
    private String precio;
    private int imagen;

    public modeloLista(String nombre, String precio, int imagen) {
        Nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
