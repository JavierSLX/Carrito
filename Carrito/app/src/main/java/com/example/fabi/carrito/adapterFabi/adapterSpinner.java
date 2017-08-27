package com.example.fabi.carrito.adapterFabi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.fabi.carrito.R;
import com.example.fabi.carrito.modeloFabi.modeloSpinner;

import java.util.ArrayList;

/**
 * Created by Fabi on 27/08/2017.
 */

public class adapterSpinner  extends BaseAdapter{
    private ArrayList<modeloSpinner> elementos;
    private Context context;

    public adapterSpinner(ArrayList<modeloSpinner> elementos, Context context) {
        this.elementos = elementos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return elementos.size() ;
    }

    @Override
    public modeloSpinner getItem(int i) {
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
            view = inflater.inflate(R.layout.spinner_template, null);
        }
        //Relaciona cada elemento con su view
        TextView titulo = (TextView)view.findViewById(R.id.opcionSpinner);


        //Coloca los valores de cada elemento
        titulo.setText(getItem(i).getOpcion());

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
        TextView titulo = (TextView)view.findViewById(R.id.opcionSpinner);


        //Coloca los valores de cada elemento
        titulo.setText(getItem(position).getOpcion());

        return view;
    }
}
