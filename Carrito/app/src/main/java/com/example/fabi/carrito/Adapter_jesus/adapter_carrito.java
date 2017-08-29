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
import com.example.fabi.carrito.modelo_jesus.modeloCarritos;

import java.util.ArrayList;

/**
 * Created by alberto on 28/08/2017.
 */

public class adapter_carrito extends BaseAdapter{

    private ArrayList<modeloCarritos> elementos;
    private Context context;

    public adapter_carrito(ArrayList<modeloCarritos> elementos, Context context) {
        this.elementos = elementos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return elementos.size();
    }

    @Override
    public modeloCarritos getItem(int i) {
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
            view=inflater.inflate(R.layout.text_carrito, null);
        }
        TextView uno = (TextView)view.findViewById(R.id.nombreCarrito);
        TextView dos = (TextView) view.findViewById(R.id.precioCarrito);
        uno.setText(getItem(i).getNombre());
        dos.setText(getItem(i).getPrecio());
        return view;
    }
}
