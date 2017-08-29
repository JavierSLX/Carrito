package com.example.fabi.carrito.modelo_jesus;

/**
 * Created by alberto on 28/08/2017.
 */

public class modeloCarritos {
    private String nombre;
    private String precio;

    public modeloCarritos(String nombre, String precio) {
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
