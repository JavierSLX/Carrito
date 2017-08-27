package com.example.fabi.carrito;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.fabi.carrito.adapterFabi.adapterLista;
import com.example.fabi.carrito.adapterFabi.adapterSpinner;
import com.example.fabi.carrito.modeloFabi.modeloLista;
import com.example.fabi.carrito.modeloFabi.modeloSpinner;

import org.w3c.dom.Text;


import java.util.ArrayList;

public class Fabi extends AppCompatActivity {
    private TextView nombre, precio;
    private Spinner spinner;
    private ListView listView;
    private ImageView img;
    ArrayList<modeloLista> lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabi);
        nombre = (TextView)findViewById(R.id.Nombre);
        precio = (TextView)findViewById(R.id.Precio);
        spinner = (Spinner)findViewById(R.id.spinner);
        listView= (ListView)findViewById(R.id.listView);
        img = (ImageView)findViewById(R.id.img);

        final adapterSpinner adapter =new adapterSpinner(listar(),this);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                adapterLista listaAdapter;

                switch (i){
                    case 0:
                        listaAdapter = new adapterLista(listarRopa(),Fabi.this);
                        listView.setAdapter(listaAdapter);
                        /*img.setImageResource(lista.get(i).getImagen());
                        nombre.setText(lista.get(i).getNombre());
                        precio.setText(lista.get(i).getPrecio());
                        */
                        break;
                    case 1:
                        listaAdapter = new adapterLista(listarZapatos(),Fabi.this);
                        listView.setAdapter(listaAdapter);
                        /*
                        img.setImageResource(lista.get(i).getImagen());
                        nombre.setText(lista.get(i).getNombre());
                        precio.setText(lista.get(i).getPrecio());
                        */
                        break;
                    case 2:
                        listaAdapter = new adapterLista(listarZapatos(),Fabi.this);
                        listView.setAdapter(listaAdapter);
                        img.setImageResource(lista.get(i).getImagen());
                        /*
                        nombre.setText(lista.get(i).getNombre());
                        precio.setText(lista.get(i).getPrecio());
                            */
                        break;
                    case 3:
                        listaAdapter = new adapterLista(listarRopa(),Fabi.this);
                        listView.setAdapter(listaAdapter);

                        img.setImageResource(lista.get(i).getImagen());
                        nombre.setText(lista.get(i).getNombre());

                        precio.setText("Ya");

                        break;

                }




            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               img.setImageResource(lista.get(i).getImagen());
               nombre.setText(lista.get(i).getNombre());
               precio.setText(lista.get(i).getPrecio());
           }
       });




    }

    private ArrayList<modeloSpinner> listar() {
        ArrayList<modeloSpinner> listaS = new ArrayList<>();
        String[] opciones = getResources().getStringArray(R.array.Opciones);

        //crea la lista

        for (int i = 0; i <opciones.length; i++){
            listaS.add(new modeloSpinner(opciones[i]));
        }
        return listaS;
    }


    private ArrayList<modeloLista> listarZapatos() {
        final TypedArray imagenesZapatos = getResources().obtainTypedArray(R.array.imagenesZapatos);
        lista = new ArrayList<>();
        String[] nombre = getResources().getStringArray(R.array.Zapatos);
        String [] precio = getResources().getStringArray(R.array.preciozapatos);


        //crea la lista

        for (int i = 0; i <nombre.length; i++){
            lista.add(new modeloLista(nombre[i],precio[i],imagenesZapatos.getResourceId(i,0)));
        }
        return lista;
    }

    private ArrayList<modeloLista> listarRopa() {
        final TypedArray imagenesRopa = getResources().obtainTypedArray(R.array.imagenesRopa);
        lista = new ArrayList<>();
        String[] nombre = getResources().getStringArray(R.array.Ropa);
        String [] precio = getResources().getStringArray(R.array.precioRopa);

        //crea la lista

        for (int i = 0; i <nombre.length; i++){
            lista.add(new modeloLista(nombre[i],precio[i],imagenesRopa.getResourceId(i,0)));
        }
        return lista;
    }

    private ArrayList<modeloLista> listarBolsas() {
        final TypedArray imagenesRopa = getResources().obtainTypedArray(R.array.imagenesBolsas);
        lista = new ArrayList<>();
        String[] nombre = getResources().getStringArray(R.array.Bolsas);
        String [] precio = getResources().getStringArray(R.array.precioBolsas);

        //crea la lista

        for (int i = 0; i <nombre.length; i++){
            lista.add(new modeloLista(nombre[i],precio[i],imagenesRopa.getResourceId(i,0)));
        }
        return lista;
    }

    private ArrayList<modeloLista> listarAccesorios() {
        final TypedArray imagenesRopa = getResources().obtainTypedArray(R.array.imagenesAccesorios);
        lista = new ArrayList<>();
        String[] nombre = getResources().getStringArray(R.array.Accesorios);
        String [] precio = getResources().getStringArray(R.array.precioaccesorios);

        //crea la lista

        for (int i = 0; i <nombre.length; i++){
            lista.add(new modeloLista(nombre[i],precio[i],imagenesRopa.getResourceId(i,0)));
        }
        return lista;
    }




}
