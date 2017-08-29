package com.example.fabi.carrito.Adapter_jesus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.fabi.carrito.R;
import com.example.fabi.carrito.modelo_jesus.Spinner_jesus;

import java.util.ArrayList;

/**
 * Created by alberto on 27/08/2017.
 */

public class SpinnerAdapter extends BaseAdapter{

    private ArrayList<Spinner_jesus> elementos;
    private Context context;

    public SpinnerAdapter(ArrayList<Spinner_jesus> elementos, Context context) {
        this.elementos = elementos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return elementos.size();
    }

    @Override
    public Spinner_jesus getItem(int i) {
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
        if (convertView == null) {
            view=inflater.inflate(R.layout.spinner_template, null);
        }
        TextView titulo = (TextView)view.findViewById( R.id.opcionSpinner);
        titulo.setText(getItem(i).getCategoria());
        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = convertView;
        if (convertView == null) {
            view=inflater.inflate(R.layout.spinner_template, null);
        }
        TextView titulo = (TextView)view.findViewById( R.id.opcionSpinner);
        titulo.setText(getItem(position).getCategoria());
        return view;
    }
}
