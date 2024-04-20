package com.students.controller;

import com.students.DTO.SchoolRequest;
import com.students.service.SchoolService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService schoolService;

    //Function to get all existing entries
    @GetMapping("/school")
    public ResponseEntity<?> getSchools(){
        return schoolService.getAllSchools();
    }

    //Function to get an existing entry by its id
    @GetMapping("/school/{id}")
    public ResponseEntity<?> getSchoolById(@PathVariable(name = "id") Long id){
        return schoolService.findSchoolById(id);
    }

    //Function to create a new entry
    @PostMapping("/school")
    public ResponseEntity<?> saveSchool(@Valid @RequestBody SchoolRequest request){
        return schoolService.save(request);
    }

    //Function to replace an entry entirely
    @PutMapping("/school/{id}")
    public ResponseEntity<?> putSchool(@Valid @PathVariable(name = "id") Long id, @RequestBody SchoolRequest request){
        return schoolService.putSchool(id,request);
    }


    //Function to delete the entire existing entry by id
    @DeleteMapping("/school/{id}")
    public void deleteSchool(@PathVariable(value = "id") Long id){
        schoolService.deleteSchool(id);
    }
}
