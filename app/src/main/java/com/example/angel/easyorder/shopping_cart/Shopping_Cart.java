package com.example.angel.easyorder.shopping_cart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
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
    private Spinner spnTipoPago;
    private TextView txtNombreRestaurante;
    private TextView txtNombreMesa;

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
        spnTipoPago = findViewById(R.id.spnTipoPago);
        txtNombreRestaurante=findViewById(R.id.txtNombreRestaurante);
        txtNombreMesa=findViewById(R.id.txtNombreMesa);
        //obtener el recicler

        reciclador = findViewById(R.id.RecicladorCarrito);
        reciclador.setHasFixedSize(true);
        //administrador para linear layout
        lManager = new LinearLayoutManager(this);
        reciclador.setLayoutManager(lManager);


        adapter = new PedidoAdapter(items);
        reciclador.setAdapter(adapter);

        //Adapter del spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Pagos, R.layout.support_simple_spinner_dropdown_item);
        spnTipoPago.setAdapter(adapter);

        SumarTodo();
        String[] variables = getIntent().getExtras().getString("vResultado2").split(";");
        txtNombreRestaurante.setText(variables[0]);
        txtNombreMesa.setText("Mesa  "+variables[1]);
    }

    public void FillPedidos() {
        items.add(new Pedido("Arroz con pollo", 2, 8.5));
        items.add(new Pedido("Causa rellena", 1, 16.5));
        items.add(new Pedido("Lomo Saltado", 3, 9.5));
        items.add(new Pedido("Chancho al Palo", 1, 10.5));
        items.add(new Pedido("Banana Split  ", 1, 5.50));
        items.add(new Pedido("Volcan De Chocolate", 2, 7.5));
        items.add(new Pedido("Tres Leches", 2, 10.0));
        items.add(new Pedido("Desayuno Americano", 1, 7.5));
        items.add(new Pedido("Desayuno Deluxe", 1, 4.5));
        items.add(new Pedido("Pan con Nada", 1, 2.5));
    }

    private void SumarTodo() {
        double subtotal = 0;
        double igv = 0;
        double total = 0;

        for (int i = 0; i < items.size(); i++) {
            subtotal = subtotal + (items.get(i).getPrecio()*items.get(i).getCantidad());
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
