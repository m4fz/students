package com.students.repository;

import com.students.DTO.SchoolRequest;
import com.students.entity.Passport;
import com.students.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.LongAccumulator;

@Repository
public interface SchoolRepo extends JpaRepository<School, Long> {
    List<School> findAll();
    Optional<School> findById(Long id);
    School save(School school);
    void deleteById(Long id);
}
