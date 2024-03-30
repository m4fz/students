package com.students.controller;

import com.students.entity.GameRequest;
import com.students.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;

    @GetMapping("/games")
    public ResponseEntity<?> getGames(){
        return gameService.getAllGames();
    }

    @GetMapping("/game/{id}")
    public ResponseEntity<?> getGameById(@PathVariable(name = "id") Long id){
        return gameService.findGameById(id);
    }

    @PostMapping("/game")
    public ResponseEntity<?> saveGame(@RequestBody GameRequest student){
        return gameService.saveGames(student);
    }

    @PutMapping("/game/{id}")
    public ResponseEntity<?> putGame(@PathVariable(name = "id") Long id, @RequestBody GameRequest student){
        return gameService.putGame(id,student);
    }

    @PatchMapping("/game/{id}")
    public ResponseEntity<?> patchGame(@PathVariable(name = "id") Long id, @RequestBody GameRequest student){
        return gameService.patchGame(id,student);
    }

    @DeleteMapping("/game/{id}")
    public void deleteGame(@PathVariable(value = "id") Long id){
        gameService.deleteGame(id);
    }
}