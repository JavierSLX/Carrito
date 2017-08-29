package com.example.fabi.carrito.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fabi.carrito.R;
import com.example.fabi.carrito.adi;
import com.example.fabi.carrito.modelo.lista;

import java.util.ArrayList;

/**
 * Created by Adrii on 27/08/2017.
 */

public class ListaAdapter extends BaseAdapter {
    private ArrayList<lista> elementos;
    private Context context;


    public ListaAdapter(ArrayList<lista> elementos, Context context) {
        this.elementos = elementos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return elementos.size();
    }

    @Override
    public lista getItem(int i) {
        return elementos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = convertView;
        if(convertView == null){
            view = inflater.inflate(R.layout.adilista_template, null);
        }


        //Relaciona cada elemento con su view
        TextView nombre = (TextView) view.findViewById(R.id.nombre);
        final Button add = (Button) view.findViewById(R.id.btn);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context,"Se agrego al carrito",Toast.LENGTH_SHORT).show();
                adi.carrito(context, i);

            }
        });

        //Coloca los valores de cada elemento
        nombre.setText(getItem(i).getNombre());


        return view;
    }
}
