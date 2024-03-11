package com.example.JanKenPon.Controladores;

import com.example.JanKenPon.Modelos.RoundResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jankenpon")
public class JanKenPonController {

    private List<RoundResult> results = new ArrayList<>();

    @PostMapping("/play")
    public RoundResult playRound(@RequestParam String jugador1, @RequestParam String jugador2) {
        // Lógica para determinar el ganador y guardar el resultado
        String winner = determineWinner(jugador1, jugador2);
        RoundResult roundResult = new RoundResult(jugador1, jugador2, winner);
        results.add(roundResult);
        return roundResult;
    }

    @GetMapping("/results/{player}")
    public List<RoundResult> getPlayerResults(@PathVariable String player) {
        List<RoundResult> playerResults = new ArrayList<>();
        for (RoundResult result : results) {
            if (result.getPlayer().equalsIgnoreCase(player)) {
                playerResults.add(result);
            }
        }
        return playerResults;
    }

    private String determineWinner(String player1, String player2) {
        if (player1.equals(player2)) {
            return "Empate";
        } else if (player1.equals("piedra") && player2.equals("tijera") || player1.equals("papel") && player2.equals("piedra") || player1.equals("tijera") && player2.equals("papel")) {
            return "Jugador 1";
        } else {
            return "Jugador 2";
        }
    }
}
