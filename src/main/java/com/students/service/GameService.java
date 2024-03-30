package com.students.service;

import com.students.entity.GameRequest;
import org.springframework.http.ResponseEntity;

public interface GameService {
    ResponseEntity<?> getAllGames();
    ResponseEntity<?> findGameById(Long id);
    ResponseEntity<?> saveGames(GameRequest game);

    void deleteGame(Long id);

    ResponseEntity<?> putGame(Long id, GameRequest game);

    ResponseEntity<?> patchGame(Long id, GameRequest game);
}
