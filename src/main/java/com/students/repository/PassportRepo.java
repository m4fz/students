package com.students.repository;

import com.students.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassportRepo extends JpaRepository<Passport, Long> {
    List<Passport> findAll();
}
