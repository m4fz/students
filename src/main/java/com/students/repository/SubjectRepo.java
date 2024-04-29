package com.students.repository;

import com.students.entity.Student;
import com.students.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepo extends JpaRepository<Subject, Long> {


    //findAll is already in jparepo
    Optional<Subject> findById(Long id);

    Subject save(Subject subject);

    void deleteById(Long id);
}
