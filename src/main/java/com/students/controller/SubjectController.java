package com.students.controller;

import com.students.DTO.SubjectRequest;
import com.students.DTO.SubjectResponse;
import com.students.service.SubjectService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;

@RestController
@RequestMapping("/api/v1/subject")
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> getSubject(@PathVariable("id") Long id){
        return service.getSubjectById(id);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getSubjectsList(){
        return service.getSubjectList();
    }
    @PostMapping("")
    public ResponseEntity<?> createSubject(@RequestBody SubjectRequest request){
        return service.save(request);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchSubject(@RequestBody SubjectRequest request, @PathVariable(name = "id") Long id){
        return service.patchSubject(id, request);
    }
    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable(name = "id") Long id){
        service.deleteSubject(id);
    }
}
