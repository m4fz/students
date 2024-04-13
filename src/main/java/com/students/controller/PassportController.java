package com.students.controller;

import com.students.DTO.PassportRequest;
import com.students.repository.PassportRepo;
import com.students.service.PassportService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class PassportController {
    private final PassportService passportService;

    @GetMapping("/passports")
    public ResponseEntity<?> getAllPassports(){
        return passportService.getAllPassports();
    }

    @PostMapping("/passport")
    public ResponseEntity<?> createPassword(@Valid @RequestBody PassportRequest request){
        return passportService.save(request);
    }
}
