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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dragonball")
public class DragonBallController {
    private final List<DragonBall> dragonBallsSpread = new ArrayList<>();
    private final List<DragonBall> ownedDragonBalls = new ArrayList<>();

    private final List<Integer> stardots = List.of(1, 2, 3, 4, 5, 6, 7);

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
    public ResponseEntity<?> getDragonBall(int ball) {
        if (ownedDragonBalls.size() >= 7) {
            // No se puede recoger más de 7 bolas de dragón
            return ResponseEntity.badRequest().body("Ya posees todas las 7 bolas de dragón");
        }

        // Simula la recolección de una bola de dragón
        DragonBall dragonBall = new DragonBall("Ubicación", ball, true);
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

    @GetMapping("/get")
    public ResponseEntity<DragonBall> getDragonBallWithStardots(int stardots) {
        List<DragonBall> foundBalls = ownedDragonBalls.stream()
                .filter(db -> db.getNumEstrellas() == stardots)
                .collect(Collectors.toList());

        if (foundBalls.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        DragonBall dragonBall = foundBalls.get(0);
        return ResponseEntity.ok(dragonBall);
    }
}
