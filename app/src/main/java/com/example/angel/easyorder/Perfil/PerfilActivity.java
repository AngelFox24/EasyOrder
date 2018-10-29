package com.example.angel.easyorder.Perfil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    private EditText edtCantidad;
    private Button btnCarro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);


        String foto = getIntent().getExtras().getString("vFoto");
        String nombre = getIntent().getExtras().getString("vNombre");
        double precio = getIntent().getExtras().getDouble("vPrecio");
        String catego = getIntent().getExtras().getString("vDescripcion");


        foto2 = findViewById(R.id.imgFoto);
        titulo = findViewById(R.id.Titulo);
        costo = findViewById(R.id.valor);
        descripcion = findViewById(R.id.Descripcion);
        edtCantidad = findViewById(R.id.edtCantidad);
        btnCarro = findViewById(R.id.btnCarro);

        titulo.setText(nombre);
        costo.setText("S/." + String.valueOf(precio));
        descripcion.setText(catego);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("EasyOrder");
        toolbar.setLogo(R.drawable.chef44);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Picasso.with(foto2.getContext())
                .load(foto).into(foto2);

    }
    public void btnAgregar(View v){
        //Aqui lo agregas a la base de datos

    }
}

