//package com.students.service;
//
//import com.students.DTO.*;
//import com.students.entity.Passport;
//import com.students.entity.School;
//import com.students.exceptions.PassportNotFoundException;
//import com.students.repository.SchoolRepo;
//import com.students.repository.StudentRepo;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class SchoolServiceImpl implements SchoolService{
//    private final SchoolRepo schoolRepo;
//    private final StudentRepo studentRepo;
//    @Override
//    @Transactional(readOnly = true)
//    public ResponseEntity<?> getAllSchools() {
//        log.info("Get all schools");
//        List<School> schools =schoolRepo.findAll();
//        SchoolResponse schoolResponse = new SchoolResponse();
//        schools.forEach(school -> {
//            schoolResponse.setId(school.getId());
//            schoolResponse.setStudentId(school.getStudentList().getId()); //???
//        });
//        return new ResponseEntity<>(schoolResponse, HttpStatus.OK);
//    }
//    @Override
//    @Transactional(readOnly = true)
//    public ResponseEntity<?> findSchoolById(Long id) {
//        log.info("Find school by id");
//        if (schoolRepo.findById(id).isPresent()){
//            return new ResponseEntity<>(schoolRepo.findById(id).get(), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(schoolRepo.findById(id).get(), HttpStatus.NOT_FOUND);
//    }
//
//    @Override
//    @Transactional
//    public ResponseEntity<?> save(SchoolRequest school) {
//        log.info("Create new school");
//        School newSchool = new School();
//        newSchool.set(school.getId());
//        response.setSerialNumber(passportDB.getSerialNumber());
//        response.setStudentId(passportDB.getStudent().getId());
//        return new ResponseEntity<>(passportDB, HttpStatus.CREATED);
//    }
//
//    @Override
//    @Transactional
//    public void deleteSchool(Long id) {
//        log.info("Delete passport");
//        schoolRepo.deleteById(id);
//    }
//
//    @Override
//    @Transactional
//    public ResponseEntity<?> putSchool(Long id, SchoolRequest school) {
//        log.info("Replace(put) all passport info");
//        Passport passportFromDB = schoolRepo.findById(id).orElseThrow(() -> new PassportNotFoundException("Passport not found."));
//        passportFromDB.setSerialNumber(passport.getSerialNumber());
//        passportFromDB.setStudent(passport.getStudentId()); //???
//        return new ResponseEntity<>(passportFromDB, HttpStatus.CREATED);
//    }
//
//    @Override
//    @Transactional
//    public ResponseEntity<?> patchSchool(Long id, SchoolPatchRequest school) {
//        log.info("Replace(patch) some passport info");
//        Passport passportFromDB = schoolRepo.findById(id).orElseThrow(() -> new PassportNotFoundException("Passport not found."));
//        Optional<PassportPatchRequest> passportOptional = Optional.ofNullable(passport);
//        if (passportOptional.isPresent()){
//            if(passportOptional.get().getSerialNumber() != null){
//                passportFromDB.setSerialNumber(passportOptional.get().getSerialNumber());
//            }
//            if(passportOptional.get().getStudentId() != null){
//                passportFromDB.setStudent(passportOptional.get().getStudentId()); //???
//            }
//        }
//        return new ResponseEntity<>(passportFromDB, HttpStatus.CREATED);
//    }
//}
