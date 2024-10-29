package com.example.op;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.op.databinding.ItemPersonajeFavBinding;

import java.util.ArrayList;

public class AdapterFavoritos extends RecyclerView.Adapter<AdapterFavoritos.FavoritoViewHolder> {

    ArrayList<Personaje> listaFavoritos;
    private PersonajeViewModel personajeViewModel;

    public AdapterFavoritos(ArrayList<Personaje> listaFavoritos, PersonajeViewModel personajeViewModel) {
        this.listaFavoritos = listaFavoritos;
        this.personajeViewModel = personajeViewModel;
    }

    @NonNull
    @Override
    public AdapterFavoritos.FavoritoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FavoritoViewHolder(ItemPersonajeFavBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFavoritos.FavoritoViewHolder holder, int position) {
        Personaje personaje = listaFavoritos.get(position);
        holder.binding.nombreTextView.setText(personaje.getNombre());
        holder.binding.recompensaTextView.setText(String.valueOf(personaje.getRecompensa()));
        holder.binding.rolTextView.setText(personaje.getRol());
        holder.binding.descripcionTextView.setText(personaje.getDescripcion());
        holder.binding.personajeImageView.setImageResource(personaje.getImage());

        // Añadir click listener para el botón de eliminar



    }

    @Override
    public int getItemCount() {
        return listaFavoritos.size();
    }

    public void setListaFavoritos(ArrayList<Personaje> nuevosFavoritos) {
        this.listaFavoritos = nuevosFavoritos;
        notifyDataSetChanged();
    }

    public void eliminarFavorito(int position) {
        listaFavoritos.remove(position);
        notifyItemRemoved(position);
    }


    //VIEWHOLDER, CADA ITEM

    public static class FavoritoViewHolder extends RecyclerView.ViewHolder {
        ItemPersonajeFavBinding binding;

        public FavoritoViewHolder(@NonNull ItemPersonajeFavBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}