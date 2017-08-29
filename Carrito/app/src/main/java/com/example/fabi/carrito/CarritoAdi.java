package com.example.fabi.carrito;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.example.fabi.carrito.adapter.CarritoAdapter;

import java.util.ArrayList;

public class CarritoAdi extends AppCompatActivity {


    private ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito_adi);

       lista = (ListView) findViewById(R.id.ListaCarrito);
        CarritoAdapter adapter1 = new CarritoAdapter(adi.listac, this);
        lista.setAdapter(adapter1);

    }
}
