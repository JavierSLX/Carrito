package com.example.fabi.carrito.adapterAngel;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fabi.carrito.R;
import com.example.fabi.carrito.modeloAngel.CarritoAngel;
import com.example.fabi.carrito.modeloAngel.ListviewAngel;

import java.util.List;

/**
 * Created by Dulcinea on 29/08/2017.
 */

public class CarritoAngelAdapter  extends ArrayAdapter<CarritoAngel>{
    public CarritoAngelAdapter(@NonNull Context context,List<CarritoAngel> objetos) {
        super(context, R.layout.carrito_angel_template,objetos);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(getContext());
        View item= inflater.inflate(R.layout.carrito_angel_template,null);
        final ImageView imagen=(ImageView)item.findViewById(R.id.imagenCarrito);
        final TextView nombre=(TextView) item.findViewById(R.id.ArticuloCarrito);
        final TextView precio=(TextView)item.findViewById(R.id.PrecioCarrito);
        imagen.setImageResource(getItem(position).getImagen());
        nombre.setText(getItem(position).getNombre());
        precio.setText(getItem(position).getPrecio());
        return item;
    }
}
