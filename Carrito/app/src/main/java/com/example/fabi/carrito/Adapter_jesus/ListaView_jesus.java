package com.example.fabi.carrito.Adapter_jesus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fabi.carrito.R;
import com.example.fabi.carrito.modelo_jesus.lista_jesu;

import java.util.ArrayList;

/**
 * Created by alberto on 27/08/2017.
 */

public class ListaView_jesus extends BaseAdapter{

    private ArrayList<lista_jesu> elementos;
    private Context context;

    public ListaView_jesus(ArrayList<lista_jesu> elementos, Context context) {
        this.elementos = elementos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return elementos.size();
    }

    @Override
    public lista_jesu getItem(int i) {
        return elementos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convet, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = convet;
        if(convet == null){
            view=inflater.inflate(R.layout.lista_jesus, null);
        }
        TextView uno = (TextView)view.findViewById(R.id.textLista);
        Button dos = (Button) view.findViewById(R.id.botonLista);
        dos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"se agrego al carrito",Toast.LENGTH_SHORT).show();
            }
        });
        uno.setText(getItem(i).getNombre());
        return view;
    }


}
