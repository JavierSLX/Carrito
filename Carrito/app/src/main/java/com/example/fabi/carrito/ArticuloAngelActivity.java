package com.example.fabi.carrito;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ArticuloAngelActivity extends AppCompatActivity {
    String []nombres;
    String []precio;
    String []arregloImagenes;
    TypedArray imagenes;
    int posicionArreglo=0;
    TextView nombreText;
    TextView precioText;
    private ImageView imagen;
    private int imagenId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulo_angel);
        posicionArreglo=getIntent().getIntExtra("posicion",0);
        nombres=getIntent().getStringArrayExtra("nombre");
        nombreText=(TextView)findViewById(R.id.nombreArticulo);
        nombreText.setText(nombres[posicionArreglo].toString());
        precio=getIntent().getStringArrayExtra("precio");
        precioText=(TextView)findViewById(R.id.precioArticulo);
        precioText.setText(precio[posicionArreglo].toString());
        imagenId=getIntent().getIntExtra("imagen",0);
        imagen=(ImageView)findViewById(R.id.imagenGrande);
        imagen.setImageResource(imagenId);
    }
}
