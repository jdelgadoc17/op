package com.example.op;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.op.databinding.FragmentFragmentoRandomBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FragmentoRandom extends Fragment {

    private FragmentFragmentoRandomBinding binding;
    private List<Personaje> listaPiratas;
    private List<Personaje> listaMarines;
    private List<Personaje> listaRevolucionarios;
    private Random random;

    public FragmentoRandom() {
        // Constructor vacío requerido
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        random = new Random();  // Inicializar Random solo una vez
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFragmentoRandomBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Configuración de imagen predeterminada
        binding.imgInfo.setImageResource(R.drawable.luffy_hat);

        binding.buttonRandom.setOnClickListener(v -> mostrarPersonajeRandom());

        binding.buttonBackRandom.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(view);
            navController.popBackStack();
        });
    }

    public void mostrarPersonajeRandom() {
        // Obtener las listas de personajes del repositorio
        listaPiratas = RepositorioPersonajes.getLista_piratas();
        listaMarines = RepositorioPersonajes.getLista_marines();
        listaRevolucionarios = RepositorioPersonajes.getLista_revolucionarios();

        // Combinar listas en una sola
        List<Personaje> listaCombinada = new ArrayList<>();
        listaCombinada.addAll(listaPiratas);
        listaCombinada.addAll(listaMarines);
        listaCombinada.addAll(listaRevolucionarios);

        // Verificar si la lista está vacía
        if (listaCombinada.isEmpty()) {
            Toast.makeText(getContext(), getString(R.string.no_personajes), Toast.LENGTH_SHORT).show();
            return;
        }

        // Seleccionar un personaje aleatorio y actualizar la interfaz
        Personaje personajeRandom = listaCombinada.get(random.nextInt(listaCombinada.size()));
        binding.imgInfo.setImageResource(personajeRandom.getImage());
        binding.nombreTextView.setText(personajeRandom.getNombre());
    }
}