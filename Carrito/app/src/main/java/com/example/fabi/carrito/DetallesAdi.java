package com.example.fabi.carrito;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.fabi.carrito.R.id.adi;
import static com.example.fabi.carrito.R.id.txtPrecio;

public class DetallesAdi extends AppCompatActivity {
    private Button regresar;
    private TextView precio, nombre;
    private ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_adi);

        regresar = (Button)findViewById(R.id.btn1);
        precio = (TextView)findViewById(txtPrecio);
        nombre = (TextView)findViewById(R.id.txtNombre);
        img = (ImageView)findViewById(R.id.img1);

        Intent recibir = getIntent();
        Bundle extras = recibir.getExtras();

        if (extras != null){
            String nombre1 = (String)extras.get("Nombre");
            String precio1 = (String)extras.get("Precio");
            int imagen1 = (int)extras.get("Imagen");
            precio.setText(precio1);
            nombre.setText(nombre1);
            img.setImageResource(imagen1);


        }
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetallesAdi.this, adi.class);
                startActivity(intent);
            }
        });





    }
}
