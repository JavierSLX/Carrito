package com.example.fabi.carrito;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fabi.carrito.adapterAngel.ListviewAngelAdapter;
import com.example.fabi.carrito.adapterAngel.SpinnerAngelAdapter;
import com.example.fabi.carrito.modeloAngel.ListviewAngel;
import com.example.fabi.carrito.modeloAngel.SpinnerAngel;

import java.util.ArrayList;

public class AngelActivity extends AppCompatActivity {
    private Spinner spinnerAngel;
    private ListView listviewAngel;
    private ArrayList<SpinnerAngel>categoriaAngel;
    private ArrayList<ListviewAngel>nombresAngel;
    private ImageView imagen;
    TextView nombreText;
    TextView precioText;
    String []nombres;
    String []precio;
    String []arregloImagenes;
    TypedArray imagenes;
    int posicionArreglo=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angel);
        nombreText=(TextView)findViewById(R.id.nombreArticulo);
        precioText=(TextView)findViewById(R.id.precioArticulo);
        listviewAngel=(ListView)findViewById(R.id.listaArticulos);
        String []categoria=getResources().getStringArray(R.array.opciones);
        imagen=(ImageView)findViewById(R.id.imagenArticulo);
        categoriaAngel=new ArrayList<>();
        for(int i=0;i<categoria.length;i++)
        {
            categoriaAngel.add(new SpinnerAngel(categoria[i]));
        }

        SpinnerAngelAdapter adapter=new SpinnerAngelAdapter(this,categoriaAngel);
        //Se instancia el spinner del xml con el elemento java y se carga el adapter
        spinnerAngel=(Spinner)findViewById(R.id.tipoArticulo);
        spinnerAngel.setAdapter(adapter);
        spinnerAngel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    //Celular
                    case 0:
                        nombres=getResources().getStringArray(R.array.nombreCelular);
                        precio=getResources().getStringArray(R.array.precioCelular);
                        arregloImagenes=getResources().getStringArray(R.array.imagenesCelular);
                        mostrarElementos(nombres,precio);
                        nombreText.setText(nombres[0].toString());
                        precioText.setText(precio[0].toString());
                        imagenes=getResources().obtainTypedArray(R.array.imagenesCelular);
                        imagen.setImageResource(imagenes.getResourceId(0,0));
                        break;
                    //Tablet
                    case 1:
                        nombres=getResources().getStringArray(R.array.nombresTablet);
                        precio=getResources().getStringArray(R.array.preciosTablet);
                        arregloImagenes=getResources().getStringArray(R.array.imagenesTablet);
                        mostrarElementos(nombres,precio);
                        nombreText.setText(nombres[0].toString());
                        precioText.setText(precio[0].toString());
                        imagenes=getResources().obtainTypedArray(R.array.imagenesTablet);
                        imagen.setImageResource(imagenes.getResourceId(0,0));
                        break;
                    //Spinner
                    case 2:
                        nombres=getResources().getStringArray(R.array.nombreSpinner);
                        precio=getResources().getStringArray(R.array.preciosSpinner);
                        arregloImagenes=getResources().getStringArray(R.array.imagenesSpinner);
                        mostrarElementos(nombres,precio);
                        nombreText.setText(nombres[0].toString());
                        precioText.setText(precio[0].toString());
                        imagenes=getResources().obtainTypedArray(R.array.imagenesSpinner);
                        imagen.setImageResource(imagenes.getResourceId(0,0));
                        break;
                    //Watches
                    case 3:
                        nombres=getResources().getStringArray(R.array.nombresWatches);
                        precio=getResources().getStringArray(R.array.preciosWatches);
                        arregloImagenes=getResources().getStringArray(R.array.imagenesWatches);
                        mostrarElementos(nombres,precio);
                        nombreText.setText(nombres[0].toString());
                        precioText.setText(precio[0].toString());
                        imagenes=getResources().obtainTypedArray(R.array.imagenesWatches);
                        imagen.setImageResource(imagenes.getResourceId(0,0));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                nombres=getResources().getStringArray(R.array.nombreCelular);
                precio=getResources().getStringArray(R.array.precioCelular);
                mostrarElementos(nombres,precio);
                nombreText.setText(nombres[0].toString());
                precioText.setText(precio[0].toString());
                imagenes=getResources().obtainTypedArray(R.array.imagenesCelular);
                imagen.setImageResource(imagenes.getResourceId(0,0));
            }
        });
        listviewAngel.setClickable(true);
        listviewAngel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                posicionArreglo=i;
                nombreText.setText(nombres[i].toString());
                precioText.setText(precio[i].toString());
                imagen.setImageResource(imagenes.getResourceId(i,0));
            }
        });
        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AngelActivity.this,ArticuloAngelActivity.class);
                intent.putExtra("nombre", nombres);
                intent.putExtra("precio", precio);
                intent.putExtra("imagen", (Parcelable) imagenes);
                intent.putExtra("posicion",posicionArreglo);
                startActivity(intent);
            }
        });
    }
    public void mostrarElementos(String []nombres,String []precios)
    {
        nombresAngel=new ArrayList<>();
        for(int j=0;j<nombres.length;j++)
        {
            nombresAngel.add(new ListviewAngel(nombres[j],precios[j]));
        }
        ListviewAngelAdapter itemAdapter2=new ListviewAngelAdapter(AngelActivity.this,nombresAngel);
        listviewAngel.setAdapter(itemAdapter2);
    }
}
