package com.example.fabi.carrito.modelo_jesus;

/**
 * Created by alberto on 27/08/2017.
 */

public class lista_jesu {
    private String nombre;
    private String precio;
    private int imagen;

    public lista_jesu(String nombre, String precio, int imagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
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

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
