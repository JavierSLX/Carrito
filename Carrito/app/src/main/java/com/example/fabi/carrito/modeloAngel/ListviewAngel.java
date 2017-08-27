package com.example.fabi.carrito.modeloAngel;

/**
 * Created by Dulcinea on 27/08/2017.
 */

public class ListviewAngel {
    private String nombre;
    private String precio;

    public ListviewAngel(String nombre, String precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
