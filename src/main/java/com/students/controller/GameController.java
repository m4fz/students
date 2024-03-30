package com.students.controller;

import com.students.DTO.GameRequest;
import com.students.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;
    //Function to get all existing entries
    @GetMapping("/games")
    public ResponseEntity<?> getGames(){
        return gameService.getAllGames();
    }

    //Function to get an existing entry by its id
    @GetMapping("/game/{id}")
    public ResponseEntity<?> getGameById(@PathVariable(name = "id") Long id){
        return gameService.findGameById(id);
    }

    //Function to create a new entry
    @PostMapping("/game")
    public ResponseEntity<?> saveGame(@RequestBody GameRequest student){
        return gameService.saveGames(student);
    }

    //Function to replace an entry entirely
    @PutMapping("/game/{id}")
    public ResponseEntity<?> putGame(@PathVariable(name = "id") Long id, @RequestBody GameRequest student){
        return gameService.putGame(id,student);
    }

    //Function to replace any value of an existing entry
    @PatchMapping("/game/{id}")
    public ResponseEntity<?> patchGame(@PathVariable(name = "id") Long id, @RequestBody GameRequest student){
        return gameService.patchGame(id,student);
    }

    //Function to delete the entire existing entry by id
    @DeleteMapping("/game/{id}")
    public void deleteGame(@PathVariable(value = "id") Long id){
        gameService.deleteGame(id);
    }
}