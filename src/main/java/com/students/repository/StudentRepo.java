package com.students.repository;

import com.students.entity.Student;
import org.hibernate.annotations.processing.Find;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{
    List<Student> findAll();
    Optional<Student> findById(Long id);

    Student save(Student student);

    void deleteById(Long id);

}
