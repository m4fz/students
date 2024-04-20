package com.students.service;

import com.students.DTO.*;
import com.students.entity.Passport;
import com.students.entity.School;
import com.students.exceptions.PassportNotFoundException;
import com.students.exceptions.SchoolNotFoundException;
import com.students.mapper.SchoolMapper;
import com.students.repository.SchoolRepo;
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
public class SchoolServiceImpl implements SchoolService{
    private final SchoolRepo schoolRepo;
    private final StudentRepo studentRepo;
    private final SchoolMapper mapper;
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> getAllSchools() {
        log.info("Get all schools");
        return new ResponseEntity<>(mapper.schoolResponseList(schoolRepo.findAll()), HttpStatus.OK);
    }
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> findSchoolById(Long id) {
        log.info("Find school by id");
        if (findSchool(id).isPresent()){
            return new ResponseEntity<>(mapper.createSchoolResponse(schoolRepo.findById(id).get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(mapper.createSchoolResponse(schoolRepo.findById(id).get()), HttpStatus.NOT_FOUND);
    }

    @Override
    @Transactional
    public ResponseEntity<?> save(SchoolRequest request) {
        log.info("Create new school");
        return new ResponseEntity<>(schoolRepo.save(mapper.createSchoolEntity(request)), HttpStatus.OK);
    }

    @Override
    @Transactional
    public void deleteSchool(Long id) {
        log.info("Delete passport");
        schoolRepo.deleteById(id);
    }

    @Override
    @Transactional
    public ResponseEntity<?> putSchool(Long id, SchoolRequest request) {
        log.info("Replace(put) all passport info");
        School schoolFromDB = findSchool(id).orElseThrow(() ->new SchoolNotFoundException("school not found"));
        mapper.putSchool(schoolFromDB,request);
        return new ResponseEntity<>(mapper.createSchoolResponse(schoolFromDB), HttpStatus.CREATED);
    }

    public Optional<School> findSchool(Long id){
        return schoolRepo.findById(id);
    }
}
