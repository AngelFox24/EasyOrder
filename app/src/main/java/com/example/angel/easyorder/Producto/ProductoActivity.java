package com.example.angel.easyorder.Producto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.angel.easyorder.Categoria.Categoria;
import com.example.angel.easyorder.Categoria.CategoriaAdapter;
import com.example.angel.easyorder.R;

import java.util.ArrayList;
import java.util.List;

public class ProductoActivity extends AppCompatActivity {

    private RecyclerView reciclador;
    private List<Producto> items = new ArrayList();
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);


        Fill();

        reciclador=(RecyclerView) findViewById(R.id.reciclador);
        reciclador.setHasFixedSize(true);

        lManager= new LinearLayoutManager(this);
        reciclador.setLayoutManager(lManager);

        adapter = new ProductoAdapter(items);
        reciclador.setAdapter(adapter);


    }

    private void Fill() {
        items.add(new Producto("Lomo", 20.5, "Plato tipico peruano criollo", "https://comidasperuanas.net/wp-content/uploads/2015/08/Lomo-Saltado-730x430.jpg"));
        items.add(new Producto("Lomo", 20.5, "Plato tipico peruano criollo", "https://comidasperuanas.net/wp-content/uploads/2015/08/Lomo-Saltado-730x430.jpg"));
        items.add(new Producto("Lomo", 20.5, "Plato tipico peruano criollo", "https://comidasperuanas.net/wp-content/uploads/2015/08/Lomo-Saltado-730x430.jpg"));
        items.add(new Producto("Lomo", 20.5, "Plato tipico peruano criollo", "https://comidasperuanas.net/wp-content/uploads/2015/08/Lomo-Saltado-730x430.jpg"));
        items.add(new Producto("Lomo", 20.5, "Plato tipico peruano criollo", "https://comidasperuanas.net/wp-content/uploads/2015/08/Lomo-Saltado-730x430.jpg"));
        items.add(new Producto("Lomo", 20.5, "Plato tipico peruano criollo", "https://comidasperuanas.net/wp-content/uploads/2015/08/Lomo-Saltado-730x430.jpg"));
    }

}
