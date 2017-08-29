package com.example.fabi.carrito;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetallesFabi extends AppCompatActivity {

    private TextView nombredetalles,preciodetalles;
    private ImageView imgdetalles;
    private Button btnregresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_fabi);

        nombredetalles = (TextView)findViewById(R.id.nombredetalles);
        preciodetalles = (TextView)findViewById(R.id.precioDetalles);
        imgdetalles = (ImageView)findViewById(R.id.imagenDetalles);
        btnregresar = (Button)findViewById(R.id.Regresar);

        Intent recibir = getIntent();
       Bundle extras = recibir.getExtras();
        if (extras !=null){
            String nombre = (String)extras.get("Nombre");
            String precio = (String)extras.get("Precio");
            int imagen = (int)extras.get("Imagen");
            nombredetalles.setText(nombre);
            preciodetalles.setText(precio);
            imgdetalles.setImageResource(imagen);
        }


        btnregresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetallesFabi.this,Fabi.class);
                startActivity(intent);
            }
        });



    }
}

