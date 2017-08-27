package com.example.fabi.carrito.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.fabi.carrito.R;
import com.example.fabi.carrito.modelo.spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Adrii on 27/08/2017.
 */

public class SpinnerAdapter extends BaseAdapter {

    ArrayList<spinner> elementos;
    private Context context;

    public SpinnerAdapter(ArrayList<spinner> elementos, Context context) {
        this.elementos = elementos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return elementos.size();
    }

    @Override
    public spinner getItem(int i) {
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
            view = inflater.inflate(R.layout.adispiner_template, null);
        }


        //Relaciona cada elemento con su view
        TextView opcion = (TextView) view.findViewById(R.id.tipo);



        //Coloca los valores de cada elemento
        opcion.setText(getItem(i).getCategoria());


        return view;

    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = convertView;
        if(convertView == null){
            view = inflater.inflate(R.layout.spinner_template, null);
        }


        //Relaciona cada elemento con su view
        TextView opcion = (TextView) view.findViewById(R.id.opcionSpinner);



        //Coloca los valores de cada elemento
        opcion.setText(getItem(position).getCategoria());


        return view;
    }
}
