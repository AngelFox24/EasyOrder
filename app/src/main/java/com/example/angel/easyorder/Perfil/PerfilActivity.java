package com.example.angel.easyorder.Perfil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.angel.easyorder.Categoria.Categoria;
import com.example.angel.easyorder.R;

import java.util.ArrayList;
import java.util.List;

public class PerfilActivity extends AppCompatActivity {

    private RecyclerView reciclador;
    private List<Categoria> items = new ArrayList();
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        reciclador=(RecyclerView) findViewById(R.id.reciclador);
        reciclador.setHasFixedSize(true);

        lManager= new LinearLayoutManager(this);
        reciclador.setLayoutManager(lManager);

        Fill();


    }

    private void Fill() {
        items.add(new Categoria("Desayunos","https://image.flaticon.com/icons/svg/17/17007.svg"));
        items.add(new Categoria("Almuerzos","https://banner2.kisspng.com/20180613/wep/kisspng-breakfast-food-lunch-dinner-clip-art-cutlery-icon-5b216bc76ea5a1.9184759815289169354532.jpg"));
        items.add(new Categoria("Infusiones","http://www.portondelcielo.com/_images/servicios_desayuno.png"));
        items.add(new Categoria("Postres","https://image.flaticon.com/icons/svg/52/52990.svg"));
    }

}

