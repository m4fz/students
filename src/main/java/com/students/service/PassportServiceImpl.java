package com.students.service;

import com.students.DTO.PassportRequest;
import com.students.DTO.PassportResponse;
import com.students.entity.Passport;
import com.students.entity.Student;
import com.students.exceptions.StudentNotFoundException;
import com.students.repository.PassportRepo;
import com.students.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PassportServiceImpl implements PassportService{
    private final PassportRepo passportRepo;
    private final StudentRepo studentRepo;
    @Override
    public ResponseEntity<?> getAllPassports() {
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
    public ResponseEntity<?> save(PassportRequest request) {
        Student student = studentRepo.findById(request.getStudentId()).orElseThrow(()-> new StudentNotFoundException(String.format("Student with id = %S not found", request.getStudentId())));
        Passport passport = Passport.builder().serialNumber(request.getSerialNumber()).student(student).build();
        Passport passportDB = passportRepo.save(passport);
        PassportResponse response = new PassportResponse();
        response.setId(passportDB.getId());
        response.setSerialNumber(passportDB.getSerialNumber());
        response.setStudentId(passportDB.getStudent().getId());
        return new ResponseEntity<>(passportDB, HttpStatus.CREATED);
    }
}
