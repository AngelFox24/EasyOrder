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

        String nombre = getIntent().getExtras().getString("vNombre");
        if (nombre == "Desayunos") {
            FillD();
        }
        if (nombre == "Almuerzos") {
            FillA();
        }
        if (nombre == "Infusiones") {
            FillI();
        }
        if (nombre == "Postres") {
            FillP();
        }


        reciclador = (RecyclerView) findViewById(R.id.reciclador);
        reciclador.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this);
        reciclador.setLayoutManager(lManager);

        adapter = new ProductoAdapter(items);
        reciclador.setAdapter(adapter);


    }

    private void FillA() {
        items.add(new Producto("Lomo", 20.50, "Plato tipico peruano criollo", "https://comidasperuanas.net/wp-content/uploads/2015/08/Lomo-Saltado-730x430.jpg"));
        items.add(new Producto("Aji de gallina", 16.00, "Bajo en grasas.. y excusas", "https://www.maggi.pe/wp-content/uploads/2016/02/Aji-de-gallina-540x440px-340x360.jpg"));
        items.add(new Producto("Arepa", 7.50, "Exquisito aperitivo, comida ideal cuando se encuentra en apuros", "https://ichef.bbci.co.uk/news/660/cpsprodpb/1400C/production/_93723918_thinkstockphotos-627042504.jpg"));
        items.add(new Producto("Ensalada fresca", 15.00, "Enriquecido en fibra y vitaminas, un plato ideal", "https://sevilla.abc.es/gurme//wp-content/uploads/2013/08/ensalada-caribena-1200x675.jpg"));
    }

    public void FillD() {
        items.add(new Producto("Desayuno Americano", 12.00, "Beacon, huevo, tostada, panqueques, naranja", "https://cocina-casera.com/wp-content/uploads/2018/04/desayuno-americano-3.jpg"));
        items.add(new Producto("Desayuno Europeo", 12.00, "Lo más fino que nos puede ofrecer doña Isabel II", "http://s04.s3c.es/imag/_v0/770x420/2/a/d/breakfast-hotel-1921530_1920.jpg"));
        items.add(new Producto("Desayuno Deluxe", 15.00, "El desayuno es la comida más importante del dia... y la más sabrosa", "https://st-listas.20minutos.es/images/2010-07/237493/2535101_640px.jpg?1331145463"));
    }

    public void FillI() {
        items.add(new Producto("Te verde", 1.50, "Plato tipico peruano criollo", "https://www.abc.es/media/familia/2018/04/07/te-verde-fotolia-kiD--620x349@abc.jpg"));
        items.add(new Producto("Café cargado", 2.50, "Para empezar el dia lleno de energia", "http://www.capitalmexico.com.mx/wp-content/uploads/2016/08/cafeina-embarazo-jpg-1024x682.jpg"));
        items.add(new Producto("Manzanilla", 1.50, "Tranquilazante natural, deja las ideas fluir", "https://static.tuasaude.com/media/article/cy/iu/beneficios-do-cha-de-camomila_13767_l.jpg"));
    }

    public void FillP() {
        items.add(new Producto("Banana Split", 15.00, "La combinación perfecta", "https://cdn.shopify.com/s/files/1/1143/3886/products/banana-split_78533835-7ecd-4cb3-8934-9f4c455c9b69_1024x1024.jpg?v=1522429634"));
        items.add(new Producto("Volcan de chocolate", 15.00, "Imposible resistirse", "https://www.cocinerosargentinos.com/images/2_Volcan-circular-de-chocolate.jpg"));
        items.add(new Producto("Tres leches", 8.00, "El sabor que no quieres dejar escapar", "https://images-gmi-pmc.edge-generalmills.com/81a71e1c-cd25-4cb4-85c0-ff21ff7668ec.jpg"));

    }
}
