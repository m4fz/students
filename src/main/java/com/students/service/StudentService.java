package com.students.service;

import com.students.entity.Student;
import com.students.entity.StudentRequest;
import org.springframework.http.ResponseEntity;

import java.security.PublicKey;
import java.util.List;

public interface StudentService {
    ResponseEntity<?> getAllStudents();
    ResponseEntity<?> findStudentById(Long id);
    ResponseEntity<?> save(StudentRequest student);

    void deleteStudent(Long id);

    ResponseEntity<?> putStudent(Long id, StudentRequest student);

    ResponseEntity<?> patchStudent(Long id, StudentRequest student);
}
