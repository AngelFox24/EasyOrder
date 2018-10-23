package com.example.angel.easyorder.shopping_cart;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.angel.easyorder.R;

import java.util.List;

public class PedidoAdapter extends RecyclerView.Adapter<PedidoAdapter.PedidoViewHolder> {
    private List<Pedido> items;

    public static class PedidoViewHolder extends RecyclerView.ViewHolder{
        public CardView comidaCardView;
        public TextView nombre;
        public TextView cantidad;
        public TextView precio;

        public PedidoViewHolder(View v){
            super(v);
            comidaCardView=(CardView)v.findViewById(R.id.detalleCompra);
            nombre=(TextView) v.findViewById(R.id.NombreComida);
            cantidad=(TextView) v.findViewById(R.id.CantidadComida);
            precio=(TextView) v.findViewById(R.id.PrecioComida);
        }

    }
    @Override
    public PedidoAdapter.PedidoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card,viewGroup,false);

        return new PedidoViewHolder(v);
    }
    public List<Pedido> getItems(){
        return this.items;
    }

    public PedidoAdapter(List<Pedido> items){
        this.items=items;

    }

    @Override
    public void onBindViewHolder(PedidoAdapter.PedidoViewHolder pedidoViewHolder, int i) {
        pedidoViewHolder.nombre.setText(items.get(i).getNombre());
        pedidoViewHolder.cantidad.setText(items.get(i).getCantidad());
        pedidoViewHolder.precio.setText(String.valueOf(items.get(i).getPrecio()));

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
