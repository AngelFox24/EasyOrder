package com.example.angel.easyorder.Categoria;

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
import com.example.angel.easyorder.Producto.Producto;
import com.example.angel.easyorder.Producto.ProductoActivity;
import com.example.angel.easyorder.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.LibroViewHolder>{

    private List<Categoria> items;

    public static class LibroViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public CardView libroCardView;
        public ImageView imgFoto;
        public TextView Titulo;


        public LibroViewHolder(View v) {
            super(v);
            libroCardView = (CardView) v.findViewById(R.id.libroCardView);
            imgFoto = (ImageView) v.findViewById(R.id.imgFoto);
            Titulo = (TextView) v.findViewById(R.id.Titulo);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public CategoriaAdapter(List<Categoria> items) {
        this.items = items;
    }

    public List<Categoria> getItems(){
        return this.items;
    }

    @Override
    public LibroViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.categoria, viewGroup, false);
        return new LibroViewHolder(v);
    }

    @Override
    public void onBindViewHolder(LibroViewHolder viewHolder, final int i) {
        //viewHolder.imgFoto.setImageResource(items.get(i).getIdphoto());
        Picasso.with(viewHolder.imgFoto.getContext())
                .load(items.get(i).getUrlfoto()).into(viewHolder.imgFoto);

        viewHolder.Titulo.setText(items.get(i).getTitulo());

        //Implementando evento CLIC en el CardView
        viewHolder.libroCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("vNombre", items.get(i).getTitulo());
                //Para otra ocasion joven

                Intent newActivity = new Intent(v.getContext(), ProductoActivity.class);
                newActivity.putExtras(bundle);
                v.getContext().startActivity(newActivity);
            }
        });

    }
}



