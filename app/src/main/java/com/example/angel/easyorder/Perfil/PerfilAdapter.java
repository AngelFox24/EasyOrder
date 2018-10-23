package com.example.angel.easyorder.Perfil;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.angel.easyorder.Categoria.Categoria;
import com.example.angel.easyorder.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PerfilAdapter extends RecyclerView.Adapter<com.example.angel.easyorder.Categoria.CategoriaAdapter.LibroViewHolder>{

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

    public PerfilAdapter(List<Categoria> items) {
        this.items = items;
    }

    public List<Categoria> getItems(){
        return this.items;
    }

    @Override
    public com.example.angel.easyorder.Categoria.CategoriaAdapter.LibroViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.perfil, viewGroup, false);
        return new com.example.angel.easyorder.Categoria.CategoriaAdapter.LibroViewHolder(v);
    }

    @Override
    public void onBindViewHolder(com.example.angel.easyorder.Categoria.CategoriaAdapter.LibroViewHolder viewHolder, final int i) {
        //viewHolder.imgFoto.setImageResource(items.get(i).getIdphoto());
        Picasso.with(viewHolder.imgFoto.getContext())
                .load(items.get(i).getUrlfoto()).into(viewHolder.imgFoto);

        viewHolder.Titulo.setText(items.get(i).getTitulo());

        //Implementando evento CLIC en el CardView
        /*viewHolder.personCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("vFoto", items.get(i).getUrlfoto());
                bundle.putString("vNombre", items.get(i).getNombre());
                bundle.putString("vDNI", items.get(i).getDni());
                bundle.putString("vBiografia", items.get(i).getBiografia());

                Intent newActivity = new Intent(v.getContext(), BioActivity.class);
                newActivity.putExtras(bundle);
                v.getContext().startActivity(newActivity);
            }
        });
        */
    }
}