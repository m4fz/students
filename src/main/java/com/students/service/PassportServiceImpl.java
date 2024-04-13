package com.students.service;

import com.students.DTO.*;
import com.students.entity.Passport;
import com.students.entity.Student;
import com.students.exceptions.PassportNotFoundException;
import com.students.exceptions.StudentNotFoundException;
import com.students.repository.PassportRepo;
import com.students.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
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
    @Override
    public ResponseEntity<?> getPassports() {
        log.info("Get all passports");
        List<Passport> passports =passportRepo.findAll();
        PassportResponse passportResponse = new PassportResponse();
        passports.forEach(passport -> {
            passportResponse.setId(passport.getId());
            passportResponse.setStudentId(passport.getStudent().getId());
            passportResponse.setSerialNumber((passport.getSerialNumber()));
        });
        return new ResponseEntity<>(passportResponse, HttpStatus.OK);
    }
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> findPassportById(Long id) {
        log.info("Find Passport by id");
        if (passportRepo.findById(id).isPresent()){
            return new ResponseEntity<>(passportRepo.findById(id).get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(passportRepo.findById(id).get(), HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> save(PassportRequest request) {
        log.info("Create new passport");
        Student student = studentRepo.findById(request.getStudentId()).orElseThrow(()-> new StudentNotFoundException(String.format("Student with id = %S not found", request.getStudentId())));
        Passport passport = Passport.builder().serialNumber(request.getSerialNumber()).student(student).build();
        Passport passportDB = passportRepo.save(passport);
        PassportResponse response = new PassportResponse();
        response.setId(passportDB.getId());
        response.setSerialNumber(passportDB.getSerialNumber());
        response.setStudentId(passportDB.getStudent().getId());
        return new ResponseEntity<>(passportDB, HttpStatus.CREATED);
    }

    @Override
    @Transactional
    public void deletePassport(Long id) {
        log.info("Delete passport");
        passportRepo.deleteById(id);
    }

    @Override
    @Transactional
    public ResponseEntity<?> putPassport(Long id, PassportRequest passport) {
        log.info("Replace(put) all passport info");
        Passport passportFromDB = passportRepo.findById(id).orElseThrow(() -> new PassportNotFoundException("Passport not found."));
        passportFromDB.setSerialNumber(passport.getSerialNumber());
        passportFromDB.setStudent(passport.getStudentId()); //???
        return new ResponseEntity<>(passportFromDB, HttpStatus.CREATED);
    }

    @Override
    @Transactional
    public ResponseEntity<?> patchPassport(Long id, PassportPatchRequest passport) {
        log.info("Replace(patch) some passport info");
        Passport passportFromDB = passportRepo.findById(id).orElseThrow(() -> new PassportNotFoundException("Passport not found."));
        Optional<PassportPatchRequest> passportOptional = Optional.ofNullable(passport);
        if (passportOptional.isPresent()){
            if(passportOptional.get().getSerialNumber() != null){
                passportFromDB.setSerialNumber(passportOptional.get().getSerialNumber());
            }
            if(passportOptional.get().getStudentId() != null){
                passportFromDB.setStudent(passportOptional.get().getStudentId()); //???
            }
        }
        return new ResponseEntity<>(passportFromDB, HttpStatus.CREATED);
    }
}
