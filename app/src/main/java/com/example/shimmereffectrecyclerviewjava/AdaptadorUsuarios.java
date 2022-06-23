package com.example.shimmereffectrecyclerviewjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorUsuarios extends RecyclerView.Adapter<AdaptadorUsuarios.ViewHolder> {

    Context context;
    List<Usuario> listaUsuarios;

    AdaptadorUsuarios(Context context, List<Usuario> listaUsuarios) {
        this.context = context;
        this.listaUsuarios = listaUsuarios;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(context).inflate(R.layout.item_rv_completado, parent, false);
        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ivCredencial.setImageResource(R.drawable.icon_user_card);
        holder.tvNombre.setText(listaUsuarios.get(position).nombre);
        holder.tvPuesto.setText(listaUsuarios.get(position).puesto);
    }

    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivCredencial;
        TextView tvNombre;
        TextView tvPuesto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivCredencial = itemView.findViewById(R.id.ivCredencial);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvPuesto = itemView.findViewById(R.id.tvPuesto);
        }
    }
}
