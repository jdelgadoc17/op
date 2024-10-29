package com.example.op;

import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
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
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
            binding.menuInferior.setItemIconSize(150);

            // Listener para el menú inferior
            binding.menuInferior.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    if (item.getItemId() == R.id.fragmentoLista) {
                        if (navController.getCurrentDestination() != null
                                && navController.getCurrentDestination().getId() == R.id.fragmentoLista) {
                            return true;
                        }
                        navController.navigate(R.id.fragmentoLista);
                    } else if (item.getItemId() == R.id.fragmentoFavoritos) {
                        navController.navigate(R.id.fragmentoFavoritos);
                    } else if (item.getItemId() == R.id.fragmentoRandom) {
                        navController.navigate(R.id.fragmentoRandom);
                    }
                    return true;
                }
            });
        }

        // Observador del personaje seleccionado
        personajeViewModel.getPersonajeSeleccionado().observe(this, personaje -> {
            // Si estamos en modo horizontal, asegura que vistaDetalle muestre el personaje
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                actualizarVistaDetalle(personaje);
            }
        });

        // Configura visibilidad inicial de fragmentos según la orientación
        ajustarVisibilidadFragmentos(getResources().getConfiguration().orientation);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        ajustarVisibilidadFragmentos(newConfig.orientation);

        // Si cambiamos a modo horizontal, actualiza vistaDetalle con el personaje seleccionado
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Personaje personajeSeleccionado = personajeViewModel.getPersonajeSeleccionado().getValue();
            if (personajeSeleccionado != null) {
                actualizarVistaDetalle(personajeSeleccionado);
            }
        }
    }

    private void ajustarVisibilidadFragmentos(int orientation) {
        Fragment vistaLista = getSupportFragmentManager().findFragmentById(R.id.vistaLista);
        Fragment vistaDetalle = getSupportFragmentManager().findFragmentById(R.id.vistaDetalle);

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // En modo horizontal, ambos fragmentos son visibles
            if (vistaLista != null && vistaLista.getView() != null) {
                vistaLista.getView().setVisibility(View.VISIBLE);
            }
            if (vistaDetalle != null && vistaDetalle.getView() != null) {
                vistaDetalle.getView().setVisibility(View.VISIBLE);
            }
        } else {
            // En modo vertical, solo vistaLista es visible al inicio, oculta vistaDetalle
            if (vistaLista != null && vistaLista.getView() != null) {
                vistaLista.getView().setVisibility(View.VISIBLE);
            }
            if (vistaDetalle != null && vistaDetalle.getView() != null) {
                vistaDetalle.getView().setVisibility(View.GONE);
            }
        }
    }

    // Método para actualizar la vista de detalle
    private void actualizarVistaDetalle(Personaje personaje) {
        // Verificamos si `vistaDetalle` es el NavHostFragment y obtenemos su fragmento activo
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.vistaDetalle);
        if (navHostFragment != null) {
            Fragment fragmentoActivo = navHostFragment.getChildFragmentManager().getPrimaryNavigationFragment();
            if (fragmentoActivo instanceof FragmentoDetalle && personaje != null) {
                // Actualizamos el fragmento con el personaje seleccionado
                ((FragmentoDetalle) fragmentoActivo).actualizarDetalle(personaje);
            }
        }
    }
}
