package com.students.service;

import com.students.DTO.StudentPatchRequest;
import com.students.DTO.StudentRequest;
import org.springframework.http.ResponseEntity;

// using an interface to specify future functions that'll be overridden in services implementation using mappers
public interface StudentService {
    ResponseEntity<?> getAllStudents();
    ResponseEntity<?> findStudentById(Long id);
    ResponseEntity<?> save(StudentRequest student);

    void deleteStudent(Long id);

    ResponseEntity<?> putStudent(Long id, StudentRequest student);

    ResponseEntity<?> patchStudent(Long id, StudentPatchRequest student);
}
