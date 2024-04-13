package com.students.controller;

import com.students.DTO.PassportPatchRequest;
import com.students.DTO.PassportRequest;
import com.students.service.PassportService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class PassportController {
    private final PassportService passportService;

    @GetMapping("/passports")
    public ResponseEntity<?> getPassports(){
        return passportService.getAllPassports();
    }

    @GetMapping("/passport/{id}")
    public ResponseEntity<?> getPassportById(@PathVariable(name = "id") Long id){
        return passportService.findPassportById(id);
    }
    @PostMapping("/passport")
    public ResponseEntity<?> savePassword(@Valid @RequestBody PassportRequest request){
        return passportService.save(request);
    }
    @PutMapping("/passport/{id}")
    public ResponseEntity<?> putPassport(@Valid @PathVariable(name = "id") Long id, @RequestBody PassportRequest passport){
        return passportService.putPassport(id,passport);
    }

    //Function to replace any value of an existing entry
    @PatchMapping("/passport/{id}")
    public ResponseEntity<?> patchPassport(@Valid @PathVariable(name = "id") Long id, @RequestBody PassportPatchRequest passport){
        return passportService.patchPassport(id,passport);
    }

    //Function to delete the entire existing entry by id
    @DeleteMapping("/passport/{id}")
    public void deletePassport(@PathVariable(value = "id") Long id){
        passportService.deletePassport(id);
    }
}

