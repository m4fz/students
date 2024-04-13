package com.students.service;

import com.students.DTO.PassportPatchRequest;
import com.students.DTO.PassportRequest;
import org.springframework.http.ResponseEntity;

public interface PassportService {
    ResponseEntity<?> getAllPassports();
    ResponseEntity<?> findPassportById(Long id);

    ResponseEntity<?> save(PassportRequest request);

    void deletePassport(Long id);

    ResponseEntity<?> putPassport(Long id, PassportRequest passport);

    ResponseEntity<?> patchPassport(Long id, PassportPatchRequest passport);
}
