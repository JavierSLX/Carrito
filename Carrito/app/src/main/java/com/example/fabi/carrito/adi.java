package com.example.fabi.carrito;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fabi.carrito.adapter.ListaAdapter;
import com.example.fabi.carrito.modelo.Carrito;
import com.example.fabi.carrito.modelo.lista;
import com.example.fabi.carrito.modelo.spinner;

import java.util.ArrayList;

import static com.example.fabi.carrito.R.array.maquillaje;
import static com.example.fabi.carrito.R.id.btn;

public class adi extends AppCompatActivity {

    private Spinner Spinner;
    private TextView precio, nombre;
    private ListView listaB;
    private ImageView img;
    private static ArrayList<lista> listaObj;
    public static ArrayList<Carrito> listac;
    private static int position;
    private Button finalizar;
        private int img1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adi);

        //Define cada elemento con su view
        Spinner = (Spinner) findViewById(R.id.spinner);
        precio = (TextView) findViewById(R.id.precio);
        nombre = (TextView) findViewById(R.id.nombre);
        listaB = (ListView) findViewById(R.id.lista);
        img = (ImageView) findViewById(R.id.imagen);
        finalizar = (Button)findViewById(R.id.finalizar);

        listac = new ArrayList<>();




        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(adi.this, DetallesAdi.class);
                intent.putExtra("Nombre", nombre.getText().toString());
                intent.putExtra("Precio", precio.getText().toString());
                intent.putExtra("Imagen", img1);
                startActivity(intent);
            }
        });

        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(adi.this, CarritoAdi.class);
                startActivity(intent);

            }
        });

        //crea el adapter
        SpinnerAdapter adapter1 = new com.example.fabi.carrito.adapter.SpinnerAdapter(listar(), this);
        Spinner.setAdapter(adapter1);

        Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ListaAdapter adapter;
                switch (i) {
                    case 0:
                        adapter = new ListaAdapter(labiales(), adi.this);
                        listaB.setAdapter(adapter);

                        break;
                    case 1:
                        adapter = new ListaAdapter(maquillaje(), adi.this);
                        listaB.setAdapter(adapter);

                        break;
                    case 2:
                        adapter = new ListaAdapter(Cremas(), adi.this);
                        listaB.setAdapter(adapter);

                        break;
                    case 3:
                        adapter = new ListaAdapter(mascara(), adi.this);
                        listaB.setAdapter(adapter);


                        break;
                }
                img1 = listaObj.get(0).getImagen();
                img.setImageResource(listaObj.get(0).getImagen());
                nombre.setText(listaObj.get(0).getNombre());
                precio.setText(listaObj.get(0).getPrecio());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        listaB.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                img1 = listaObj.get(i).getImagen();
                img.setImageResource(listaObj.get(i).getImagen());
                nombre.setText(listaObj.get(i).getNombre());
                precio.setText(listaObj.get(i).getPrecio());

            }
        });
    }

    private ArrayList<spinner> listar (){
        ArrayList<spinner> lista = new ArrayList<>();
        String[] titulos = getResources().getStringArray(R.array.categorias);


        //crea la lista

        for (int i = 0; i < titulos.length; i++){
            lista.add(new spinner(titulos[i]));
        }
        return lista;
    }

    private ArrayList<lista> labiales (){
         listaObj = new ArrayList<>();
        String[] titulos = getResources().getStringArray(R.array.labiales);
        final String [] precios = getResources().getStringArray(R.array.precioLabiales);


        final TypedArray elementos = getResources().obtainTypedArray(R.array.imagenlabial);




        //crea la lista

        for (int i = 0; i < titulos.length; i++){
            listaObj.add(new lista(titulos[i],precios[i], elementos.getResourceId(i,0)));
        }
        return listaObj;
    }

    private ArrayList<lista> Cremas (){
        listaObj = new ArrayList<>();
        String[] titulos = getResources().getStringArray(R.array.cremas);
        String [] precios = getResources().getStringArray(R.array.precioCremas);


        final TypedArray elementos = getResources().obtainTypedArray(R.array.imagencremas);
        //crea la lista

        for (int i = 0; i < titulos.length; i++){
            listaObj.add(new lista(titulos[i],precios[i], elementos.getResourceId(i,0)));
        }
        return listaObj;
    }

    private ArrayList<lista> maquillaje (){
        listaObj = new ArrayList<>();
        String[] titulos = getResources().getStringArray(R.array.maquillaje);
        String [] precios = getResources().getStringArray(R.array.preciomaquillajes);


        final TypedArray elementos = getResources().obtainTypedArray(R.array.imagenmaquillaje);
        //crea la lista

        for (int i = 0; i < titulos.length; i++){
            listaObj.add(new lista(titulos[i],precios[i], elementos.getResourceId(i,0)));
        }
        return listaObj;
    }


    private ArrayList<lista> mascara (){
        listaObj = new ArrayList<>();
        String[] titulos = getResources().getStringArray(R.array.mascara);
        String [] precios = getResources().getStringArray(R.array.preciomascaras);


        final TypedArray elementos = getResources().obtainTypedArray(R.array.imagenesmascara);
        //crea la lista

        for (int i = 0; i < titulos.length; i++){
            listaObj.add(new lista(titulos[i],precios[i], elementos.getResourceId(i,0)));
        }
        return listaObj;
    }

    public static ArrayList<Carrito> carrito(Context context, int position){

        Toast.makeText(context,"ya salioooo", Toast.LENGTH_SHORT).show();
        listac.add(new Carrito(listaObj.get(position).getNombre(), listaObj.get(position).getPrecio()));

        return listac;
    }


}
