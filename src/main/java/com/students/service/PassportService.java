package com.students.service;

import com.students.DTO.PassportRequest;
import org.springframework.http.ResponseEntity;

public interface PassportService {
    ResponseEntity<?> getAllPassports();

    ResponseEntity<?> save(PassportRequest request);
}
