package com.example.fabi.carrito.adapterFabi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.fabi.carrito.R;
import com.example.fabi.carrito.modeloFabi.modeloCarrito;
import com.example.fabi.carrito.modeloFabi.modeloLista;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Fabi on 28/08/2017.
 */

public class adapterCarrito extends  BaseAdapter{
    private ArrayList<modeloCarrito> elementos;
    private Context context;

    public adapterCarrito(ArrayList<modeloCarrito> elementos, Context context) {
        this.elementos = elementos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return elementos.size();
    }

    @Override
    public modeloCarrito getItem(int i) {
        return elementos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view =convertView;

        if (convertView == null){
            view = inflater.inflate(R.layout.carritofabi_template, null);
        }
        TextView nombre = (TextView)view.findViewById(R.id.nombrecarrito);
        TextView precio = (TextView)view.findViewById(R.id.preciocarrito);

        nombre.setText(getItem(i).getNombreCarrito());
        precio.setText(getItem(i).getPrecioCarrito());


        return view;
    }
}
