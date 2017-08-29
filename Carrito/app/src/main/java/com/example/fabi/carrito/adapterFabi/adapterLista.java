package com.example.fabi.carrito.adapterFabi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fabi.carrito.Fabi;
import com.example.fabi.carrito.R;
import com.example.fabi.carrito.modeloFabi.modeloCarrito;
import com.example.fabi.carrito.modeloFabi.modeloLista;
import com.example.fabi.carrito.modeloFabi.modeloSpinner;

import java.util.ArrayList;

/**
 * Created by Fabi on 27/08/2017.
 */

public class adapterLista extends BaseAdapter {

    private ArrayList<modeloLista> elementos;
    //private ArrayList<modeloCarrito> carrito;
    private Context context;
    private int posicion;

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
    public View getView(final int i, final View convertView, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = convertView;

        if(convertView == null){
            view = inflater.inflate(R.layout.lista_template, null);
        }
        //Relaciona cada elemento con su view
        TextView titulo = (TextView)view.findViewById(R.id.NombreProducto);
        Button btnAgregar = (Button)view.findViewById(R.id.btnagregar);


        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Se agrego al carrito"+posicion,Toast.LENGTH_SHORT).show();
               Fabi.carrito(context,i);



            }
        });


        //Coloca los valores de cada elemento
        titulo.setText(getItem(i).getNombre());

        return view;
    }
}
