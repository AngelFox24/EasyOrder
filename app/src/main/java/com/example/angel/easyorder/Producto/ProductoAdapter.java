package com.example.angel.easyorder.Producto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.angel.easyorder.Perfil.PerfilActivity;
import com.example.angel.easyorder.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<com.example.angel.easyorder.Producto.ProductoAdapter.LibroViewHolder>{

    private List<Producto> items;

    public static class LibroViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public CardView libroCardView;
        public ImageView imgFoto;
        public TextView Titulo;
        public TextView precio;
        public TextView cate;


        public LibroViewHolder(View v) {
            super(v);
            libroCardView = (CardView) v.findViewById(R.id.libroCardView);
            imgFoto = (ImageView) v.findViewById(R.id.imgFoto);
            Titulo = (TextView) v.findViewById(R.id.Titulo);
            precio =  (TextView) v.findViewById(R.id.Precio);
            cate = (TextView) v.findViewById(R.id.Categoria);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public ProductoAdapter(List<Producto> items) {
        this.items = items;
    }

    public List<Producto> getItems(){
        return this.items;
    }

    @Override
    public com.example.angel.easyorder.Producto.ProductoAdapter.LibroViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.producto, viewGroup, false);
        return new com.example.angel.easyorder.Producto.ProductoAdapter.LibroViewHolder(v);
    }

    @Override
    public void onBindViewHolder(com.example.angel.easyorder.Producto.ProductoAdapter.LibroViewHolder viewHolder, final int i) {
        //viewHolder.imgFoto.setImageResource(items.get(i).getIdphoto());
        Picasso.with(viewHolder.imgFoto.getContext())
                .load(items.get(i).getUrlFoto()).into(viewHolder.imgFoto);

        viewHolder.Titulo.setText(items.get(i).getProducto());
        viewHolder.precio.setText("Precio: " + String.valueOf(items.get(i).getCosto()));
        viewHolder.cate.setText("Descripcion: " + items.get(i).getCategoria());


        viewHolder.libroCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("vFoto", items.get(i).getUrlFoto());
                bundle.putString("vNombre", items.get(i).getProducto());
                bundle.putDouble("vPrecio", items.get(i).getCosto());
                bundle.putString("vDescripcion", items.get(i).getCategoria());

                Intent newActivity = new Intent(v.getContext(), PerfilActivity.class);
                newActivity.putExtras(bundle);
                v.getContext().startActivity(newActivity);
            }
        });

    }
}

