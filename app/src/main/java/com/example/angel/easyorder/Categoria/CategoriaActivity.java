package com.example.angel.easyorder.Categoria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.angel.easyorder.R;

import java.util.ArrayList;
import java.util.List;

public class CategoriaActivity extends AppCompatActivity {

    private RecyclerView reciclador;
    private List<Categoria> items = new ArrayList();
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*reciclador=(RecyclerView) findViewById(R.id.reciclador);
        reciclador.setHasFixedSize(true);

        lManager= new LinearLayoutManager(this);
        reciclador.setLayoutManager(lManager);

        FillLibro();

    }

    private void FillLibro() {
        GetHttpCategoria wsLibros= new GetHttpCategoria(items,reciclador,adapter,this);
        wsLibros.execute();
    */}

}
