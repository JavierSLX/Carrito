package com.example.fabi.carrito.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.fabi.carrito.R;
import com.example.fabi.carrito.modelo.Carrito;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Adrii on 28/08/2017.
 */

public class CarritoAdapter extends BaseAdapter {
   private ArrayList<Carrito> elementos;
    private Context context;

    public CarritoAdapter(ArrayList<Carrito> elementos, Context context) {
        this.elementos = elementos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return elementos.size();
    }

    @Override
    public Carrito getItem(int i) {
        return elementos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = convertView;
        if(convertView == null){
            view = inflater.inflate(R.layout.adicarrito_template, null);
        }

        //Relaciona cada elemento con su view
        TextView nombreCarrito = (TextView) view.findViewById(R.id.NombreCarrito);
        TextView precioCarrito = (TextView) view.findViewById(R.id.PrecioCarrito);

        //Coloca los valores de cada elemento
        nombreCarrito.setText(getItem(i).getNombreCarrito());
        precioCarrito.setText(getItem(i).getPrecioCarrito());

        return view;
    }
}
