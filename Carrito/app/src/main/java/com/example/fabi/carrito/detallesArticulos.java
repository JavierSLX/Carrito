package com.example.fabi.carrito;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class detallesArticulos extends AppCompatActivity {

    private ImageView imageView;
    private TextView nombre, precio;
    private Button regresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_articulos);

        imageView = (ImageView) findViewById(R.id.detallesNintendo);
        nombre = (TextView) findViewById(R.id.detallesNombre);
        precio = (TextView) findViewById(R.id.detallesPrecio);
        regresar = (Button) findViewById(R.id.detallesBoton);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras != null){
            String nombres = (String)extras.get("nombre");
            String precios = (String)extras.get("precio");
            int imagen = (int)extras.get("imagen");
            nombre.setText(nombres);
            precio.setText(precios);
            imageView.setImageResource(imagen);
        }
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(detallesArticulos.this, Jesus_principal.class);
                startActivity(intent);
            }
        });
    }
}
