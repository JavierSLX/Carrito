package com.example.fabi.carrito.adapterAngel;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.fabi.carrito.R;
import com.example.fabi.carrito.modeloAngel.ListviewAngel;

import java.util.List;

/**
 * Created by Dulcinea on 27/08/2017.
 */

public class ListviewAngelAdapter extends ArrayAdapter<ListviewAngel> {
    public ListviewAngelAdapter(@NonNull Context context,List<ListviewAngel> objetos) {
        super(context, R.layout.listview_angel_template,objetos);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(getContext());
        View item= inflater.inflate(R.layout.listview_angel_template,null);
        final TextView nombre=(TextView) item.findViewById(R.id.titulo);

        nombre.setText(getItem(position).getNombre());
        return item;
    }
}
