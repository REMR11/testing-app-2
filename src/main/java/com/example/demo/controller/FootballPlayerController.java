package com.example.demo.controller;

import com.example.demo.model.FootballPlayer;
import com.example.demo.repository.FootballPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/players")
public class FootballPlayerController {

    @Autowired
    private FootballPlayerRepository footballPlayerRepository;

    @GetMapping
    public List<FootballPlayer> getAllPlayers() {
        return footballPlayerRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FootballPlayer> getPlayerById(@PathVariable Long id) {
        Optional<FootballPlayer> player = footballPlayerRepository.findById(id);
        return player.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FootballPlayer createPlayer(@RequestBody FootballPlayer footballPlayer) {
        return footballPlayerRepository.save(footballPlayer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FootballPlayer> updatePlayer(@PathVariable Long id, @RequestBody FootballPlayer updatedPlayer) {
        Optional<FootballPlayer> player = footballPlayerRepository.findById(id);
        return player.map(p -> {
            p.setName(updatedPlayer.getName());
            p.setAge(updatedPlayer.getAge());
            p.setPosition(updatedPlayer.getPosition());
            p.setTeam(updatedPlayer.getTeam());
            return ResponseEntity.ok(footballPlayerRepository.save(p));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        if (footballPlayerRepository.existsById(id)) {
            footballPlayerRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}