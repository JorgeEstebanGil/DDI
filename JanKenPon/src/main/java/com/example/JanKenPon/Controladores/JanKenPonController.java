package com.example.JanKenPon.Controladores;

import com.example.JanKenPon.Modelos.RoundResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jankenpon")
public class JanKenPonController {

    private List<RoundResult> j1 = new ArrayList<>();
    private List<RoundResult> j2 = new ArrayList<>();

    @PostMapping("/play")
    public ResponseEntity<RoundResult> playRound(@RequestParam String jugador1, @RequestParam String jugador2) {
        String winner = determineWinner(jugador1, jugador2);
        RoundResult roundResult = new RoundResult(jugador1, jugador2, winner);

        // Almacenar el resultado para el jugador 1 (J1)
        if (jugador1.equals("j1")) {
            j1.add(roundResult);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(roundResult);
    }

    @GetMapping("/results/j1")
    public ResponseEntity<List<RoundResult>> getPlayer1Results() {
        // Devolver los resultados almacenados para el jugador 1 (J1)
        return ResponseEntity.ok(j1);
    }

    @GetMapping("/results/j2")
    public ResponseEntity<List<RoundResult>> getPlayer2Results() {
        // Devolver los resultados almacenados para el jugador 2 (J2)
        return ResponseEntity.ok(j2);
    }

    private String determineWinner(String player1, String player2) {
        if (player1.equals(player2)) {
            return "empate";
        } else if ((player1.equals("piedra") && player2.equals("tijeras")) ||
                (player1.equals("papel") && player2.equals("piedra")) ||
                (player1.equals("tijeras") && player2.equals("papel"))) {
            return "jugador1";
        } else {
            return "jugador2";
        }
    }
}
