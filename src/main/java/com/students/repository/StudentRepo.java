package com.students.repository;

import com.students.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// using springs repo functions to get the necessary data from the table, save changes etc.
@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{
    @Query(value = "from Student student left join fetch student.passport")
    List<Student> findAll();
    Optional<Student> findById(Long id);

    Student save(Student student);

    void deleteById(Long id);

}
