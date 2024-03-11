package com.example.PiedraPapelTijera.Modelo;

public class PiedraPapelTijera {
    private String jugador1;
    private String jugador2;
    private String resultado;

    public PiedraPapelTijera(String jugador1, String jugador2, String resultado) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.resultado = resultado;
    }

    public PiedraPapelTijera() {
    }

    public String getJugador1() {
        return jugador1;
    }

    public void setJugador1(String jugador1) {
        this.jugador1 = jugador1;
    }

    public String getJugador2() {
        return jugador2;
    }

    public void setJugador2(String jugador2) {
        this.jugador2 = jugador2;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
