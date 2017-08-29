package com.example.fabi.carrito;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.example.fabi.carrito.Adapter_jesus.ListaView_jesus;
import com.example.fabi.carrito.modelo_jesus.Spinner_jesus;
import com.example.fabi.carrito.modelo_jesus.lista_jesu;

import java.util.ArrayList;

public class Jesus_principal extends AppCompatActivity {

    ArrayList<lista_jesu> lista;
    private Spinner spinner;

    private ImageView imageView;
    private TextView nombre, precio;
    private ListView listView;
    private int imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jesus_principal);

        spinner = (Spinner) findViewById(R.id.SpinnerPricipal);
        imageView = (ImageView) findViewById(R.id.ImagenPrincipal);
        nombre = (TextView) findViewById(R.id.textUnoPrincipal);
        precio = (TextView) findViewById(R.id.textDosPrincipal);
        listView = (ListView) findViewById(R.id.listViewPrincipal);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Jesus_principal.this, detallesArticulos.class);
                intent.putExtra("nombre",nombre.getText().toString());
                intent.putExtra("precio",precio.getText().toString());
                intent.putExtra("imagen",imagen);
                startActivity(intent);

            }
        });
        SpinnerAdapter adapter = new com.example.fabi.carrito.Adapter_jesus.SpinnerAdapter(opciones(), this);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ListaView_jesus listasAdapter;
                switch (i) {
                    case 0:
                        listasAdapter = new ListaView_jesus(laptop(), Jesus_principal.this);
                        listView.setAdapter(listasAdapter);
                        break;
                    case 1:
                        listasAdapter = new ListaView_jesus(celulares(), Jesus_principal.this);
                        listView.setAdapter(listasAdapter);
                        break;
                    case 2:
                        listasAdapter = new ListaView_jesus(consolas(), Jesus_principal.this);
                        listView.setAdapter(listasAdapter);
                        break;
                    case 3:
                        listasAdapter = new ListaView_jesus(pantallas(), Jesus_principal.this);
                        listView.setAdapter(listasAdapter);
                        break;
                }
                imagen = lista.get(0).getImagen();
                imageView.setImageResource(imagen);
                nombre.setText(lista.get(0).getNombre());
                precio.setText(lista.get(0).getPrecio());

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                nombre.setText(lista.get(i).getNombre());
                precio.setText(lista.get(i).getPrecio());
                imagen = lista.get(i).getImagen();
                imageView.setImageResource(imagen);

            }
        });

    }

    private ArrayList<Spinner_jesus>opciones(){
        ArrayList<Spinner_jesus> spinner = new ArrayList<>();
        String[]opciones = getResources().getStringArray(R.array.opcion);
        for(int i = 0; i<opciones.length;i++){
            spinner.add(new Spinner_jesus(opciones[i]));
        }
        return spinner;
    }
    private ArrayList<lista_jesu>consolas() {
        final TypedArray elementos = getResources().obtainTypedArray(R.array.imagenesConsolas);
        lista= new ArrayList<>();
        String[] nombre = getResources().getStringArray(R.array.nombresConsolas);
        String[] precio = getResources().getStringArray(R.array.preciosConsolas);

        for (int i = 0; i < nombre.length; i++) {
            lista.add(new lista_jesu(nombre[i],precio[i],elementos.getResourceId(i,0)));
        }
        return lista;
    }
    private ArrayList<lista_jesu>pantallas() {
        final TypedArray elementos = getResources().obtainTypedArray(R.array.imagenesPantallas);
        lista= new ArrayList<>();
        String[] nombre = getResources().getStringArray(R.array.nombresPantalla);
        String[] precio = getResources().getStringArray(R.array.preciosPantalla);

        for (int i = 0; i < nombre.length; i++) {
            lista.add(new lista_jesu(nombre[i],precio[i],elementos.getResourceId(i,0)));
        }
        return lista;
    }
    private ArrayList<lista_jesu>celulares() {
        final TypedArray elementos = getResources().obtainTypedArray(R.array.imagenesCelulares);
        lista= new ArrayList<>();
        String[] nombre = getResources().getStringArray(R.array.nombrescelulares);
        String[] precio = getResources().getStringArray(R.array.preciosCelulares);

        for (int i = 0; i < nombre.length; i++) {
            lista.add(new lista_jesu(nombre[i],precio[i],elementos.getResourceId(i,0)));
        }
        return lista;
    }
    private ArrayList<lista_jesu>laptop() {
        final TypedArray elementos = getResources().obtainTypedArray(R.array.imagenesLaptop);
        lista= new ArrayList<>();
        String[] nombre = getResources().getStringArray(R.array.nombresLaptop);
        String[] precio = getResources().getStringArray(R.array.preciosLaptos);

        for (int i = 0; i < nombre.length; i++) {
            lista.add(new lista_jesu(nombre[i],precio[i],elementos.getResourceId(i,0)));
        }
        return lista;
    }

}
