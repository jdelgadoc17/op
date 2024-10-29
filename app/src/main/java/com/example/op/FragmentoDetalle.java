package com.example.op;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.op.databinding.FragmentFragmentoDetalleBinding;


public class FragmentoDetalle extends Fragment {

    FragmentFragmentoDetalleBinding binding;
    private PersonajeViewModel personajeViewModel;

    public FragmentoDetalle() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentFragmentoDetalleBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        personajeViewModel = new ViewModelProvider(requireActivity()).get(PersonajeViewModel.class);
        personajeViewModel.getPersonajeSeleccionado().observe(getViewLifecycleOwner(), personaje -> {
            if (personaje != null) {
                // Actualizar las vistas con los datos del personaje seleccionado
                binding.nombreTextView.setText(personaje.getNombre());
                binding.recompensaInfo.setText(String.format("Recompensa: %d", personaje.getRecompensa()));
                binding.rolInfo.setText(personaje.getRol());
                binding.descripcionInfo.setText(personaje.getDescripcion());
                binding.imgInfo.setImageResource(personaje.getImage());
            }
        });

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Oculta el botón en modo horizontal
            Log.i("aqi", "VERTIAL");
            binding.buttonBackInfo.setVisibility(View.GONE);
        } else {
            // Muestra el botón en modo vertical
            binding.buttonBackInfo.setVisibility(View.VISIBLE);
        }


        binding.buttonBackInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                personajeViewModel.limpiarSeleccion();
                NavController navController = Navigation.findNavController(view);
                navController.popBackStack();
                personajeViewModel.limpiarSeleccion();

            }
        });



    }

    public void actualizarDetalle(Personaje personaje) {
        if (personaje != null) {
            binding.nombreTextView.setText(personaje.getNombre());
            binding.recompensaInfo.setText(String.format("Recompensa: %d", personaje.getRecompensa()));
            binding.rolInfo.setText(personaje.getRol());
            binding.descripcionInfo.setText(personaje.getDescripcion());
            binding.imgInfo.setImageResource(personaje.getImage());
        }
    }

}