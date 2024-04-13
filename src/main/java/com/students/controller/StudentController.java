package com.students.controller;

import com.students.DTO.StudentPatchRequest;
import com.students.DTO.StudentRequest;
import com.students.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class StudentController {
    // TODO Make DTO Classes
    private final StudentService studentService;

    //Function to get all existing entries
    @GetMapping("/students")
    public ResponseEntity<?> getStudents(){
        return studentService.getAllStudents();
    }

    //Function to get an existing entry by its id
    @GetMapping("/student/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable(name = "id") Long id){
        return studentService.findStudentById(id);
    }

    //Function to create a new entry
    @PostMapping("/student")
    public ResponseEntity<?> saveStudent(@Valid @RequestBody StudentRequest student){
        return studentService.save(student);
    }

    //Function to replace an entry entirely
    @PutMapping("/student/{id}")
    public ResponseEntity<?> putStudent(@Valid @PathVariable(name = "id") Long id, @RequestBody StudentRequest student){
        return studentService.putStudent(id,student);
    }

    //Function to replace any value of an existing entry
    @PatchMapping("/student/{id}")
    public ResponseEntity<?> patchStudent(@Valid @PathVariable(name = "id") Long id, @RequestBody StudentPatchRequest student){
        return studentService.patchStudent(id,student);
    }

    //Function to delete the entire existing entry by id
    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable(value = "id") Long id){
        studentService.deleteStudent(id);
    }
}
