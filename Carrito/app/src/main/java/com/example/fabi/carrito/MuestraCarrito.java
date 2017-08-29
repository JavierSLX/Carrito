package com.example.fabi.carrito;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.fabi.carrito.adapterAngel.CarritoAngelAdapter;
import com.example.fabi.carrito.adapterAngel.ListviewAngelAdapter;
import com.example.fabi.carrito.modeloAngel.CarritoAngel;

import java.util.ArrayList;

public class MuestraCarrito extends AppCompatActivity {
    private ListView listviewCarrito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestra_carrito);
        listviewCarrito=(ListView)findViewById(R.id.listaCarrito);
        CarritoAngelAdapter itemAdapter2=new CarritoAngelAdapter(MuestraCarrito.this,AngelActivity.carrito);
        listviewCarrito.setAdapter(itemAdapter2);
    }
}
