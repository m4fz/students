package com.students.service;

import com.students.DTO.PassportPatchRequest;
import com.students.DTO.PassportPostRequest;
import org.springframework.http.ResponseEntity;
// using an interface to specify future functions that'll be overridden in services implementation using mappers
public interface PassportService {
    ResponseEntity<?> getAllPassports();
    ResponseEntity<?> findPassportById(Long id);

    ResponseEntity<?> save(PassportPostRequest request);

    void deletePassport(Long id);

    ResponseEntity<?> putPassport(Long id, PassportPostRequest passport);

    ResponseEntity<?> patchPassport(Long id, PassportPatchRequest passport);
}
