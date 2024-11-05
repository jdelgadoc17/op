package com.example.op.Model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class PersonajeViewModel extends ViewModel {
    private final MutableLiveData<Personaje> personajeSeleccionado = new MutableLiveData<>();
    private final MutableLiveData<ArrayList<Personaje>> listaFavoritos = new MutableLiveData<>(new ArrayList<>());


    /*
    Uso de la lcase ViewModel para menajear el estado de los personaje mostrados
     */
    public void seleccionarPersonaje(Personaje personaje) {
        personajeSeleccionado.setValue(personaje);
    }



    public void toggleFavorito(Personaje personaje) {
        ArrayList<Personaje> favoritos = listaFavoritos.getValue();
        if (favoritos != null) {
            if (favoritos.contains(personaje)) {
                favoritos.remove(personaje);

            } else {
                favoritos.add(personaje);
            }
            listaFavoritos.setValue(favoritos); // Actualiza la lista
        }
    }


    public LiveData<Personaje>getPersonajeSeleccionado(){
        return personajeSeleccionado;
    }

    public void limpiarSeleccion() {
        personajeSeleccionado.setValue(null); // Limpia la selección
    }

    public LiveData<ArrayList<Personaje>> getListaFavoritos() {
        return listaFavoritos;
    }
}
