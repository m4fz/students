package com.students.repository;

import com.students.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// using springs repo functions to get the necessary data from the table, save changes etc.
@Repository
public interface GameRepo extends JpaRepository<Game, Long> {
    List<Game> findAll();

    Optional<Game> findById(Long id);

    Game save(Game game);

    void deleteById(Long id);
}
