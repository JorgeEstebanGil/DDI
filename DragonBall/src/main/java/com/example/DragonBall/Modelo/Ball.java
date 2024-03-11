package com.example.DragonBall.Modelo;

public class Ball {
    private int id;
    private int stardots;
    private String ubicacion;

    public Ball(int id, int stardots, String ubicacion) {
        this.id = id;
        this.stardots = stardots;
        this.ubicacion = ubicacion;
    }

    public Ball() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStardots() {
        return stardots;
    }

    public void setStardots(int stardots) {
        this.stardots = stardots;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
