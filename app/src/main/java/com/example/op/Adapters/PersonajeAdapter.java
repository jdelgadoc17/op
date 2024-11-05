package com.example.op.Adapters;


import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.op.Model.Personaje;
import com.example.op.Model.PersonajeViewModel;
import com.example.op.R;
import com.example.op.databinding.ItemPersonajeBinding;

import java.util.List;

public class PersonajeAdapter extends RecyclerView.Adapter<PersonajeAdapter.InfoViewHolder> {

    private List<Personaje> listaPersonajes;
    private PersonajeViewModel personajeViewModel;

    public PersonajeAdapter(List<Personaje> listaPersonajes, PersonajeViewModel personajeViewModel) {
        this.listaPersonajes = listaPersonajes;
        this.personajeViewModel = personajeViewModel;
    }

    @NonNull
    @Override
    public InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPersonajeBinding binding = ItemPersonajeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new InfoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull InfoViewHolder holder, int position) {
        Personaje personaje = listaPersonajes.get(position);

        holder.binding.nombreTextView.setText(personaje.getNombre());
        holder.binding.recompensaTextView.setText(String.valueOf(personaje.getRecompensa()));
        holder.binding.rolTextView.setText(personaje.getRol());
        holder.binding.descripcionTextView.setText(personaje.getDescripcion());
        holder.binding.personajeImageView.setImageResource(personaje.getImage());



        if (personajeViewModel.getListaFavoritos().getValue() != null &&
                personajeViewModel.getListaFavoritos().getValue().contains(personaje)) {
            holder.binding.favoriteButton.setImageResource(R.drawable.fullstar);
        } else {
            holder.binding.favoriteButton.setImageResource(R.drawable.emptystar);
        }

        holder.itemView.setOnClickListener(view -> {
            personajeViewModel.seleccionarPersonaje(personaje);

            // Obtenemos el NavController correcto según la orientación
            NavController navController;
            if (view.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                // En modo vertical, usamos el NavController de vistaLista para navegar
                navController = ((NavHostFragment) ((AppCompatActivity) view.getContext())
                        .getSupportFragmentManager().findFragmentById(R.id.vistaLista)).getNavController();
                navController.navigate(R.id.fragmentoDetalle);
            } else {
                // En modo horizontal, no navegamos, solo actualizamos la vista
                navController = ((NavHostFragment) ((AppCompatActivity) view.getContext())
                        .getSupportFragmentManager().findFragmentById(R.id.vistaDetalle)).getNavController();
            }
        });



        holder.binding.favoriteButton.setOnClickListener(view -> {
            personajeViewModel.toggleFavorito(personaje); // Añadir o eliminar de favoritos

            if (personajeViewModel.getListaFavoritos().getValue().contains(personaje)) {
                Toast.makeText(view.getContext(), personaje.getNombre() +  view.getContext().getString(R.string.addFav), Toast.LENGTH_SHORT).show();
                holder.binding.favoriteButton.setImageResource(R.drawable.fullstar);
            } else {
                Toast.makeText(view.getContext(), personaje.getNombre() + view.getContext().getString(R.string.delFav), Toast.LENGTH_SHORT).show();
                holder.binding.favoriteButton.setImageResource(R.drawable.emptystar);
            }
        });

    }



    @Override
    public int getItemCount() {
        return listaPersonajes.size();
    }

    // Setter para actualizar la lista de personajes si es necesario
    public void setListaPersonajes(List<Personaje> listaPersonajes) {
        this.listaPersonajes = listaPersonajes;
        notifyDataSetChanged();
    }

    // ViewHolder
    public static class InfoViewHolder extends RecyclerView.ViewHolder {
        ItemPersonajeBinding binding;

        public InfoViewHolder(@NonNull ItemPersonajeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
