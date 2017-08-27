package com.example.fabi.carrito.adapterFabi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.fabi.carrito.R;
import com.example.fabi.carrito.modeloFabi.modeloLista;
import com.example.fabi.carrito.modeloFabi.modeloSpinner;

import java.util.ArrayList;

/**
 * Created by Fabi on 27/08/2017.
 */

public class adapterLista extends BaseAdapter {

    private ArrayList<modeloLista> elementos;
    private Context context;

    public adapterLista(ArrayList<modeloLista> elementos, Context context) {
        this.elementos = elementos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return elementos.size();
    }

    @Override
    public modeloLista getItem(int i) {
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
            view = inflater.inflate(R.layout.lista_template, null);
        }
        //Relaciona cada elemento con su view
        TextView titulo = (TextView)view.findViewById(R.id.NombreProducto);
        Button btnAgregar = (Button)view.findViewById(R.id.btnagregar);


        //Coloca los valores de cada elemento
        titulo.setText(getItem(i).getNombre());
        return view;
    }
}
