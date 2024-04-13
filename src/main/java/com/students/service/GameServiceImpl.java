package com.students.service;

import com.students.entity.Game;
import com.students.DTO.GameRequest;
import com.students.exceptions.GameNotFoundException;
import com.students.repository.GameRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Slf4j
@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
    private final GameRepo gameRepo;

    // function to get all existing entries
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> getAllGames() {
        log.info("Get all games");
        return new ResponseEntity<>(gameRepo.findAll(), HttpStatus.OK);
    }

    // function to get an existing entry by its id
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> findGameById(Long id) {
        log.info("Find game by id");
        if (gameRepo.findById(id).isPresent()){
            return new ResponseEntity<>(gameRepo.findById(id).get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(gameRepo.findById(id).get(), HttpStatus.NOT_FOUND);
    }

    // function to create a new entry
    @Override
    @Transactional
    public ResponseEntity<?> saveGames(GameRequest game) {
        log.info("Create new game");
        Game newGame = new Game();
        newGame.setGameName(game.getGameName());
        newGame.setRating(game.getRating());
        newGame.setPrice(game.getPrice());
        return new ResponseEntity<>(gameRepo.save(newGame), HttpStatus.CREATED);
    }

    // function to delete the entire existing entry by id
    @Override
    @Transactional
    public void deleteGame(Long id) {
        log.info("Delete game");
        gameRepo.deleteById(id);
    }

    // function to replace an entry entirely
    @Override
    @Transactional
    public ResponseEntity<?> putGame(Long id, GameRequest game) {
        log.info("Replace(put) all game info");
        Game gameFromDB = gameRepo.findById(id).orElseThrow(() -> new GameNotFoundException("Game not found."));
        Optional<GameRequest> gameOptional = Optional.ofNullable(game);
        gameFromDB.setGameName(gameOptional.map(GameRequest::getGameName).orElseThrow(NullPointerException::new));
        gameFromDB.setRating(gameOptional.map(GameRequest::getRating).orElseThrow(NullPointerException::new));
        gameFromDB.setPrice(gameOptional.map(GameRequest::getPrice).orElseThrow(NullPointerException::new));
        return new ResponseEntity<>(gameFromDB, HttpStatus.CREATED);
    }

    // function to replace any value of an existing entry
    @Override
    @Transactional
    public ResponseEntity<?> patchGame(Long id, GameRequest game) {
        log.info("Replace(patch) some game info");
        Game gameFromDB = gameRepo.findById(id).orElseThrow(() -> new GameNotFoundException("Game not found."));
        Optional<GameRequest> studentOptional = Optional.ofNullable(game);
        if (studentOptional.isPresent()){
            if(studentOptional.get().getGameName() != null){
                gameFromDB.setGameName(studentOptional.get().getGameName());
            }
            if(studentOptional.get().getRating() != null){
                gameFromDB.setRating(studentOptional.get().getRating());
            }
            if(studentOptional.get().getPrice() != null){
                gameFromDB.setPrice(studentOptional.get().getPrice());
            }
        }
        return new ResponseEntity<>(gameFromDB, HttpStatus.CREATED);
    }
}
