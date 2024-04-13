package com.students.repository;

import com.students.entity.Passport;
import com.students.entity.Student;
import com.students.service.PassportService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PassportRepo extends JpaRepository<Passport, Long> {
    List<Passport> findAll();
    Optional<Passport> findById(Long id);
    Passport save(Passport passport);
    void deleteById(Long id);
}
