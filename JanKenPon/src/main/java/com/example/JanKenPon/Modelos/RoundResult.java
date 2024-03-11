package com.example.JanKenPon.Modelos;

public class RoundResult {
    private String jugador1;
    private String jugador2;
    private String winner;

    public RoundResult(String jugador1, String jugador2, String winner) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.winner = winner;
    }

    public RoundResult() {
    }
    public String getPlayer() {
        return winner;
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

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
