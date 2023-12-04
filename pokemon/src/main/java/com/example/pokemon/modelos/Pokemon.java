package com.example.pokemon.modelos;

public class Pokemon {
    private int id;
    private String nombre;
    private int region_id;

    public Pokemon(int id, String nombre, Region region, int region_id) {
        this.id = id;
        this.nombre = nombre;
        this.region_id = region_id;
    }
    public Pokemon() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRegion_id() {
        return region_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }
}
