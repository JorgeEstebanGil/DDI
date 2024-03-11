package com.example.JanKenPon.Modelos;

public class DragonBall {
    private String ubicacion;
    private int numEstrellas;

    public DragonBall(String ubicacion, int numEstrellas) {
        this.ubicacion = ubicacion;
        this.numEstrellas = numEstrellas;
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
}
