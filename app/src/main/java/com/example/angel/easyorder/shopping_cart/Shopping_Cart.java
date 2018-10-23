package com.example.angel.easyorder.shopping_cart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.angel.easyorder.R;

import java.util.ArrayList;
import java.util.List;

public class Shopping_Cart extends AppCompatActivity {
    private RecyclerView reciclador;
    private List<Pedido> items = new ArrayList();
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping__cart);
        //llenar items
        FillPedidos();
        //obtener el recicler
        reciclador=(RecyclerView)findViewById(R.id.RecicladorCarrito);
        reciclador.setHasFixedSize(true);
        //administrador para linear layout
        lManager=new LinearLayoutManager(this);
        reciclador.setLayoutManager(lManager);

        adapter=new PedidoAdapter(items);
        reciclador.setAdapter(adapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("EasyOrder");
        toolbar.setLogo(R.drawable.chef44);

    }
private void FillPedidos(){
        items.add(new Pedido("Arroz con pollo",2,8.5));
        items.add(new Pedido("Causa rellena",1,2.0));
        items.add(new Pedido("Lomo Saltado",3,9.5));
        items.add(new Pedido("Chancho al Palo",1,10.5));
}

}
