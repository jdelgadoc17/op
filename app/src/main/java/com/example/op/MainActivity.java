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

        // Configuración de la Toolbar y el BottomNavigationView (asegurarse de que esté en uso el NavController correcto)

        // Observador del personaje seleccionado
        personajeViewModel.getPersonajeSeleccionado().observe(this, personaje -> {
            // En modo horizontal, muestra y actualiza vistaDetalle con el personaje seleccionado
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                Fragment vistaDetalle = getSupportFragmentManager().findFragmentById(R.id.vistaDetalle);
                if (vistaDetalle != null && vistaDetalle.getView() != null) {
                    vistaDetalle.getView().setVisibility(View.VISIBLE);
                    // Aquí se asegura de que FragmentoDetalle tenga el personaje actualizado
                    actualizarVistaDetalle(personaje);
                }
            }
        });

        // Configura visibilidad inicial de fragmentos según la orientación
        ajustarVisibilidadFragmentos(getResources().getConfiguration().orientation);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        ajustarVisibilidadFragmentos(newConfig.orientation);
    }

    private void ajustarVisibilidadFragmentos(int orientation) {
        Fragment vistaLista = getSupportFragmentManager().findFragmentById(R.id.vistaLista);
        Fragment vistaDetalle = getSupportFragmentManager().findFragmentById(R.id.vistaDetalle);

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if (vistaLista != null && vistaLista.getView() != null) {
                vistaLista.getView().setVisibility(View.VISIBLE);
            }
            if (vistaDetalle != null && vistaDetalle.getView() != null) {
                vistaDetalle.getView().setVisibility(View.VISIBLE);
                // Forzar la actualización del personaje seleccionado en vistaDetalle
                personajeViewModel.getPersonajeSeleccionado().getValue();
            }
        } else {
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