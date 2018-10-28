package com.example.angel.easyorder.shopping_cart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.angel.easyorder.R;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Shopping_Cart extends AppCompatActivity {
    private RecyclerView reciclador;
    private List<Pedido> items;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private TextView txtSubtotal2;
    private TextView txtIgv;
    private TextView txtTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping__cart);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("EasyOrder");
        toolbar.setLogo(R.drawable.chef44);

        items = new ArrayList();
        FillPedidos();
        //subtotal
        txtSubtotal2 = findViewById(R.id.txtSubtotales);
        txtIgv = findViewById(R.id.txtIgv);
        txtTotal = findViewById(R.id.txtTotal);
        //obtener el recicler

        reciclador = findViewById(R.id.RecicladorCarrito);
        reciclador.setHasFixedSize(true);
        //administrador para linear layout
        lManager = new LinearLayoutManager(this);
        reciclador.setLayoutManager(lManager);


        adapter = new PedidoAdapter(items);
        reciclador.setAdapter(adapter);

        SumarTodo();

    }

    private void FillPedidos() {
        items.add(new Pedido("Arroz con pollo", 2, 8.5));
        items.add(new Pedido("Causa rellena", 1, 16.2));
        items.add(new Pedido("Lomo Saltado", 3, 9.5));
        items.add(new Pedido("Chancho al Palo", 1, 10.5));
    }

    private void SumarTodo() {
        double subtotal = 0;
        double igv = 0;
        double total = 0;

        for (int i = 0; i < items.size(); i++) {
            subtotal = subtotal + items.get(i).getPrecio();
        }
        igv = subtotal * 0.18;
        total = subtotal + igv;

        subtotal = Math.round(subtotal * 100 + 0.005) / 100.0;
        igv = Math.round(igv * 100 + 0.005) / 100.0;
        total = Math.round(total * 100 + 0.005) / 100.0;

        txtSubtotal2.setText(String.valueOf(subtotal));
        txtIgv.setText(String.valueOf(igv));
        txtTotal.setText(String.valueOf(total));
    }

}
