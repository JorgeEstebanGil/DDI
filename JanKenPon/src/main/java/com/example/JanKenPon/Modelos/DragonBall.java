package com.example.JanKenPon.Modelos;


public class DragonBall {
    private String ubicacion;
    private int numEstrellas;
    private boolean found;

    public DragonBall(String ubicacion, int numEstrellas, boolean found) {
        this.ubicacion = ubicacion;
        this.numEstrellas = numEstrellas;
        this.found = found;
    }

    public DragonBall() {
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getNumEstrellas() {
        return numEstrellas;
    }

    public void setNumEstrellas(int numEstrellas) {
        this.numEstrellas = numEstrellas;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }
}
