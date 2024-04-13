package com.students.service;

import com.students.DTO.*;
import com.students.entity.Passport;
import com.students.entity.Student;
import com.students.exceptions.PassportNotFoundException;
import com.students.exceptions.StudentNotFoundException;
import com.students.mapper.PassportMapper;
import com.students.repository.PassportRepo;
import com.students.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
@RequiredArgsConstructor
public class PassportServiceImpl implements PassportService{
    private final PassportRepo passportRepo;
    private final StudentRepo studentRepo;
    private final PassportMapper mapper;
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> getAllPassports() {
        log.info("Get all passports");
        List<Passport> passports =passportRepo.findAll();
        return new ResponseEntity<>(mapper.createPassportResponseList(passports), HttpStatus.OK);
    }
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> findPassportById(Long id) {
        log.info("Find Passport by id");
        if (passportRepo.findById(id).isPresent()){
            return new ResponseEntity<>(mapper.createPassportResponse(passportRepo.findById(id).get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    private Student findStudentById(Long id) {
        log.info("Find Student by id");
        return studentRepo.findById(id).orElseThrow(() -> new StudentNotFoundException(String.format("Student with id = %S not found", id)));
    }

    @Override
    @Transactional
    public ResponseEntity<?> save(PassportRequest request) {
        log.info("Create new passport");
        Student student = studentRepo.findById(request.getStudentId()).orElseThrow(()-> new StudentNotFoundException(String.format("Student with id = %S not found", request.getStudentId())));
        Passport passport = passportRepo.save(mapper.createPassportEntity(request, student));
        return new ResponseEntity<>(mapper.createPassportResponse(passport), HttpStatus.CREATED);
    }

    @Override
    @Transactional
    public void deletePassport(Long id) {
        log.info("Delete passport");
        passportRepo.deleteById(id);
    }

    @Override
    @Transactional
    public ResponseEntity<?> putPassport(Long id, PassportRequest request) {
        log.info("Replace(put) all passport info");
        Passport passportFromDB = passportRepo.findById(id).orElseThrow(() -> new PassportNotFoundException("Passport not found."));
        Student student = findStudentById(request.getStudentId());
        mapper.putPassport(passportFromDB, request, student);
        return new ResponseEntity<>(mapper.createPassportResponse(passportFromDB), HttpStatus.CREATED);
    }

    @Override
    @Transactional
    public ResponseEntity<?> patchPassport(Long id, PassportPatchRequest request) {
        log.info("Replace(patch) some passport info");
        Passport passportFromDB = passportRepo.findById(id).orElseThrow(() -> new PassportNotFoundException("Passport not found."));
        Student student = findStudentById(request.getStudentId());
        mapper.patchPassport(passportFromDB, request, student);
        return new ResponseEntity<>(mapper.createPassportResponse(passportFromDB), HttpStatus.CREATED);
    }
}
