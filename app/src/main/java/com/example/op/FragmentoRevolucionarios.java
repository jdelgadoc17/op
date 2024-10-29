package com.example.op;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.op.databinding.FragmentFragmentoMarinesBinding;
import com.example.op.databinding.FragmentFragmentoRevolucionariosBinding;

import java.util.ArrayList;


public class FragmentoRevolucionarios extends Fragment {
    FragmentFragmentoRevolucionariosBinding binding;
    PersonajeViewModel personajeViewModel;

    public FragmentoRevolucionarios() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFragmentoRevolucionariosBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        personajeViewModel = new ViewModelProvider(requireActivity()).get(PersonajeViewModel.class);
        RepositorioPersonajes repo = new RepositorioPersonajes();
        ArrayList<Personaje> listarevolucionarios = repo.getLista_revolucionarios();

        PersonajeAdapter adapter = new PersonajeAdapter(listarevolucionarios, personajeViewModel);
        binding.recycRevolucionarios.setLayoutManager(new GridLayoutManager(getContext(), 1));
        binding.recycRevolucionarios.setAdapter(adapter);
    }
}