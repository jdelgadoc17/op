package com.example.op.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.op.Adapters.PersonajeAdapter;
import com.example.op.Model.Personaje;
import com.example.op.Model.PersonajeViewModel;
import com.example.op.Model.RepositorioPersonajes;
import com.example.op.R;
import com.example.op.databinding.FragmentFragmentoPiratasBinding;

import java.util.ArrayList;


public class FragmentoPiratas extends Fragment {
    PersonajeViewModel personajeViewModel;
    FragmentFragmentoPiratasBinding binding;
    public FragmentoPiratas() {
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentFragmentoPiratasBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        personajeViewModel = new ViewModelProvider(requireActivity()).get(PersonajeViewModel.class);
        RepositorioPersonajes repo = new RepositorioPersonajes();
        ArrayList<Personaje> listaPiratas = repo.getLista_piratas();

        PersonajeAdapter adapter = new PersonajeAdapter(listaPiratas, personajeViewModel);
        binding.recycPiratas.setLayoutManager(new GridLayoutManager(getContext(), 1));
        binding.recycPiratas.setAdapter(adapter);

        // Añadir el divisor entre items en el RecyclerView
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(binding.recycPiratas.getContext(), LinearLayoutManager.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.divider));
        binding.recycPiratas.addItemDecoration(dividerItemDecoration);




    }
}