package com.example.cerveza.Models;
import java.util.Date;

//Importamos las librerias de lombok para no tener que escribir getters y setters
import lombok.Setter;
import lombok.Getter;

//Usamos las anotaciones de lombok para que nos genere los getters y setters
@Getter
@Setter

public class BeerModel { //Creamos la clase BeerModel con sus atributos, que son los mismos que los de la tabla de la base de datos
    private int id;
    private String nombre;
    private int anoLanzamiento;
    private int codigoBreweryNew;
    private int codigoBreweryOld;

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

    public int getAnoLanzamiento() {
        return anoLanzamiento;
    }

    public void setAnoLanzamiento(int anoLanzamiento) {
        this.anoLanzamiento = anoLanzamiento;
    }

    public int getCodigoBreweryNew() {
        return codigoBreweryNew;
    }

    public void setCodigoBreweryNew(int codigoBreweryNew) {
        this.codigoBreweryNew = codigoBreweryNew;
    }

    public int getCodigoBreweryOld() {
        return codigoBreweryOld;
    }

    public void setCodigoBreweryOld(int codigoBreweryOld) {
        this.codigoBreweryOld = codigoBreweryOld;
    }
}




