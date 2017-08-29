package com.example.fabi.carrito;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.fabi.carrito.adapterFabi.adapterCarrito;
import com.example.fabi.carrito.modeloFabi.modeloCarrito;
import com.example.fabi.carrito.modeloFabi.modeloLista;

import java.util.ArrayList;

public class Finalizar extends AppCompatActivity {
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalizar);


        lista = (ListView)findViewById(R.id.listacompleta);
        adapterCarrito carrito = new adapterCarrito(Fabi.listac,this);
        lista.setAdapter(carrito);







    }

}
