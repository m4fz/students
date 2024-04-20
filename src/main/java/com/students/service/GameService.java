package com.students.service;

import com.students.DTO.GameRequest;
import org.springframework.http.ResponseEntity;

// using an interface to specify future functions that'll be overridden in services implementation using mappers
public interface GameService {
    ResponseEntity<?> getAllGames();
    ResponseEntity<?> findGameById(Long id);
    ResponseEntity<?> saveGames(GameRequest game);

    void deleteGame(Long id);

    ResponseEntity<?> putGame(Long id, GameRequest game);

    ResponseEntity<?> patchGame(Long id, GameRequest game);
}
