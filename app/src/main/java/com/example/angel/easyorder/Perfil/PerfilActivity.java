package com.example.angel.easyorder.Perfil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.angel.easyorder.Categoria.Categoria;
import com.example.angel.easyorder.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PerfilActivity extends AppCompatActivity {


    private ImageView foto2;
    private TextView titulo;
    private TextView descripcion;
    private TextView costo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);


        String foto = getIntent().getExtras().getString("vFoto");
        String nombre = getIntent().getExtras().getString("vNombre");
        double precio = getIntent().getExtras().getDouble("vPrecio");
        String catego = getIntent().getExtras().getString("vDescripcion");


        foto2 = (ImageView) findViewById(R.id.imgFoto);
        titulo = (TextView) findViewById(R.id.Titulo);
        costo = (TextView) findViewById(R.id.valor);
        descripcion = (TextView) findViewById(R.id.Descripcion);

        titulo.setText(nombre);
        costo.setText("S/." + String.valueOf(precio));
        descripcion.setText(catego);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("EasyOrder");
        toolbar.setLogo(R.drawable.chef44);

        Picasso.with(foto2.getContext())
                .load(foto).into(foto2);

    }
}

