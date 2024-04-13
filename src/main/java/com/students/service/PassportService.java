package com.students.service;

import com.students.DTO.PassportPatchRequest;
import com.students.DTO.PassportRequest;
import com.students.DTO.StudentPatchRequest;
import com.students.DTO.StudentRequest;
import org.springframework.http.ResponseEntity;

public interface PassportService {
    ResponseEntity<?> getPassports();
    ResponseEntity<?> findPassportById(Long id);

    ResponseEntity<?> save(PassportRequest request);

    void deletePassport(Long id);

    ResponseEntity<?> putPassport(Long id, PassportRequest passport);

    ResponseEntity<?> patchPassport(Long id, PassportPatchRequest passport);
}
