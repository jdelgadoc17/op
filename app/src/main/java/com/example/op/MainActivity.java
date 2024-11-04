package com.example.op;

import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.op.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;


import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.op.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    PersonajeViewModel personajeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configuración inicial de la visibilidad de los fragmentos
        ajustarVisibilidadFragmentos();

        // Inicializa PersonajeViewModel
        personajeViewModel = new ViewModelProvider(this).get(PersonajeViewModel.class);

        // Configuración de la Toolbar
        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        toolbar.setTitle(getString(R.string.app_name));
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setBackground(new ColorDrawable(getResources().getColor(R.color.blueOnePiece)));

        // Configuración del menú inferior con vistaLista
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.vistaLista);
        if (navHostFragment != null) {
            NavController navController = navHostFragment.getNavController();
            NavigationUI.setupWithNavController(binding.menuInferior, navController);

            // Configuración de iconos y tamaño del menú
            binding.menuInferior.setItemIconTintList(null);
            binding.menuInferior.setItemIconSize(100);

            // Listener para el menú inferior
            binding.menuInferior.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    boolean isListaSection = item.getItemId() == R.id.fragmentoLista;

                    if (isListaSection) {
                        if (navController.getCurrentDestination() != null
                                && navController.getCurrentDestination().getId() == R.id.fragmentoLista) {
                            toolbar.setTitle(getString(R.string.personajes));
                            return true;
                        }
                        navController.navigate(R.id.fragmentoLista);
                    } else if (item.getItemId() == R.id.fragmentoFavoritos) {
                        toolbar.setTitle(getString(R.string.favoritos));
                        navController.navigate(R.id.fragmentoFavoritos);
                    } else if (item.getItemId() == R.id.fragmentoRandom) {
                        toolbar.setTitle(getString(R.string.random));
                        navController.navigate(R.id.fragmentoRandom);
                    }

                    // Controlar visibilidad de vistaDetalle
                    binding.vistaDetalle.setVisibility(isListaSection && getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE ? View.VISIBLE : View.GONE);

                    return true;
                }
            });
        }

        // Observador del personaje seleccionado para ajustar la visibilidad segun la orientacion
        personajeViewModel.getPersonajeSeleccionado().observe(this, personaje -> {
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                actualizarVistaDetalle(personaje);

            }
        });
    }

    // METODO para ajustar la visibilidad de los fragmentos según orientación
    private void ajustarVisibilidadFragmentos() {
        boolean isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        binding.vistaLista.setVisibility(View.VISIBLE);
        if(isLandscape){
            binding.vistaDetalle.setVisibility(View.VISIBLE);
        }else{
            binding.vistaDetalle.setVisibility(View.GONE);
        }
    }

    // Este método sirve para detectar cambios de orientación y ajustamos visibilidad AUTOMATICO (se ha modificado el Android Manifest)
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        ajustarVisibilidadFragmentos();
    }


    // Este es un metodo para actualizar la vista de detalle con el personaje seleccionado
    private void actualizarVistaDetalle(Personaje personaje) {
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.vistaDetalle);
        if (navHostFragment != null) {
            Fragment fragmentoActivo = navHostFragment.getChildFragmentManager().getPrimaryNavigationFragment();
            if (fragmentoActivo instanceof FragmentoDetalle && personaje != null) {
                ((FragmentoDetalle) fragmentoActivo).actualizarDetalle(personaje);
                //Comprueba si el fragment activo es el fragmento Detalle y si es así, el manda la info para que se muestre
            }
        }
    }
}
