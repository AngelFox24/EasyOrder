package com.example.angel.easyorder.Categoria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.angel.easyorder.R;
import com.example.angel.easyorder.shopping_cart.Pedido;
import com.example.angel.easyorder.shopping_cart.PedidoAdapter;
import com.example.angel.easyorder.shopping_cart.Shopping_Cart;

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
        setContentView(R.layout.activity_categoria);

        Fill();

        reciclador=(RecyclerView) findViewById(R.id.reciclador);
        reciclador.setHasFixedSize(true);

        lManager= new LinearLayoutManager(this);
        reciclador.setLayoutManager(lManager);

        adapter = new CategoriaAdapter(items);
        reciclador.setAdapter(adapter);





        //Toolbar
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Menu del Dia");
        toolbar.setLogo(R.drawable.chef44);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        String lol = getIntent().getExtras().getString("vResultado");
        Bundle nel = new Bundle();
        nel.putString("vResultado2", lol);

        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main,menu);
        menu.findItem(R.id.shopping).setIntent(new Intent(this,Shopping_Cart.class).putExtra("vResultado2",lol));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        startActivity(item.getIntent());
        return true;
    }

    private void Fill() {
        items.add(new Categoria("Desayunos","https://image.flaticon.com/icons/png/512/100/100022.png"));
        items.add(new Categoria("Almuerzos","https://image.flaticon.com/icons/png/512/208/208029.png"));
        items.add(new Categoria("Infusiones","http://www.portondelcielo.com/_images/servicios_desayuno.png"));
        items.add(new Categoria("Postres","http://ginzarestobar.com.ar/wp-content/uploads/2018/01/icon-postres.png"));
    }

}
