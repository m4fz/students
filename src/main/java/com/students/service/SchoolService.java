package com.students.service;

import com.students.DTO.SchoolRequest;
import com.students.entity.School;
import com.students.repository.SchoolRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public interface SchoolService {
    ResponseEntity<?> getAllSchools();
    ResponseEntity<?> findSchoolById(Long id);
    ResponseEntity<?> save(SchoolRequest school);

    void deleteSchool(Long id);

    ResponseEntity<?> putSchool(Long id, SchoolRequest school);

    Optional<School> findSchool(Long id);

}

