package com.example.JanKenPon.Controladores;

import com.example.JanKenPon.Modelos.DragonBall;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dragonball")
public class DragonBallController {
    private List<DragonBall> dragonBallsSpread = new ArrayList<>();
    private List<DragonBall> ownedDragonBalls = new ArrayList<>();

    @GetMapping("/radar")
    public ResponseEntity<List<DragonBall>> listDragonBallsSpread() {
        // Devuelve la lista de bolas de dragón dispersas por el mundo
        return ResponseEntity.ok(dragonBallsSpread);
    }

    @GetMapping("/owned")
    public ResponseEntity<List<DragonBall>> listOwnedDragonBalls() {
        // Devuelve la lista de bolas de dragón que posee el jugador
        return ResponseEntity.ok(ownedDragonBalls);
    }

    @PostMapping("/get")
    public ResponseEntity<DragonBall> getDragonBall(int ball) {
        // Simula la recolección de una bola de dragón
        DragonBall dragonBall = new DragonBall("Ubicación", ball);
        ownedDragonBalls.add(dragonBall);
        dragonBallsSpread.removeIf(db -> db.getNumEstrellas() == ball);
        return ResponseEntity.ok(dragonBall);
    }

    @PostMapping("/invokeDragon")
    public ResponseEntity<?> invokeDragon() {
        if (ownedDragonBalls.size() == 7) {
            // Invoca al dragón solo si el jugador posee todas las bolas de dragón
            ownedDragonBalls.clear(); // Una vez invocado, el jugador pierde las bolas
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build(); // 418 I'm a teapot
        } else {
            return ResponseEntity.badRequest().body("Necesitas recolectar todas las 7 bolas de dragón primero");
        }
    }
}
