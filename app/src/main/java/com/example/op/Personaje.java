package com.example.op;

public class Personaje {
    private String nombre;
    private String rol;
    private int recompensa;
    private String frutaDelDiablo;
    private String descripcion;
    private int image;


    public Personaje(String nombre, String rol, int recompensa, String frutaDelDiablo, String descripcion, int image) {
        this.nombre = nombre;
        this.rol = rol;
        this.recompensa = recompensa;
        this.frutaDelDiablo = frutaDelDiablo;
        this.descripcion = descripcion;
        this.image = image;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(int recompensa) {
        this.recompensa = recompensa;
    }

    public String getFrutaDelDiablo() {
        return frutaDelDiablo;
    }

    public void setFrutaDelDiablo(String frutaDelDiablo) {
        this.frutaDelDiablo = frutaDelDiablo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


    @Override
    public String toString() {
        return "Personaje{" +
                "nombre='" + nombre + '\'' +
                ", rol='" + rol + '\'' +
                ", recompensa=" + recompensa +
                ", frutaDelDiablo='" + frutaDelDiablo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", image=" + image +
                '}';
    }
}
