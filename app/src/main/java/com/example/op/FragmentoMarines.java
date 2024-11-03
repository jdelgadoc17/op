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
import com.example.op.databinding.FragmentFragmentoPiratasBinding;

import java.util.ArrayList;


public class FragmentoMarines extends Fragment {
    FragmentFragmentoMarinesBinding binding;
    PersonajeViewModel personajeViewModel;
    public FragmentoMarines() {
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFragmentoMarinesBinding.inflate(getLayoutInflater());
        return binding.getRoot();    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        personajeViewModel = new ViewModelProvider(requireActivity()).get(PersonajeViewModel.class);
        RepositorioPersonajes repo = new RepositorioPersonajes();
        ArrayList<Personaje> listaMarines = repo.getLista_marines();

        PersonajeAdapter adapter = new PersonajeAdapter(listaMarines, personajeViewModel);
        binding.recycMarines.setLayoutManager(new GridLayoutManager(getContext(), 1));
        binding.recycMarines.setAdapter(adapter);
    }
}