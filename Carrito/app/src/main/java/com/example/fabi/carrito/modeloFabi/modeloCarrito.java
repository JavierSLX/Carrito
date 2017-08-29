package com.example.fabi.carrito.modeloFabi;

/**
 * Created by Fabi on 28/08/2017.
 */

public class modeloCarrito {
    private String nombreCarrito;
    private String precioCarrito;

    public modeloCarrito(String nombreCarrito, String precioCarrito) {
        this.nombreCarrito = nombreCarrito;
        this.precioCarrito = precioCarrito;
    }


    public String getNombreCarrito() {
        return nombreCarrito;
    }

    public void setNombreCarrito(String nombreCarrito) {
        this.nombreCarrito = nombreCarrito;
    }

    public String getPrecioCarrito() {
        return precioCarrito;
    }

    public void setPrecioCarrito(String precioCarrito) {
        this.precioCarrito = precioCarrito;
    }
}
