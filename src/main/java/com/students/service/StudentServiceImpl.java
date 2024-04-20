package com.students.service;

import com.students.DTO.StudentPatchRequest;
import com.students.DTO.StudentResponse;
import com.students.entity.School;
import com.students.entity.Student;
import com.students.DTO.StudentPostRequest;
import com.students.exceptions.SchoolNotFoundException;
import com.students.exceptions.StudentNotFoundException;
import com.students.mapper.StudentMapper;
import com.students.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.ScheduledTaskHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo; //injecting repo
    private final StudentMapper mapper; //injecting mapper for readability
    private final PassportService passportService; //injecting service(needed because of passport and student join)
    private final SchoolService schoolService;

    // function to get all existing entries
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> getAllStudents() {
        log.info("Get all students");
        List<Student> studentsFromDB = studentRepo.findAll();
        return new ResponseEntity<>(mapper.createStudentResponseList(studentsFromDB), HttpStatus.OK);
    }

    // function to get an existing entry by its id
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> findStudentById(Long id) {
        log.info("Find student by id");
        if (studentRepo.findById(id).isPresent()){
            return new ResponseEntity<>(mapper.createStudentResponse(studentRepo.findById(id).get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // function to create a new entry
    @Override
    @Transactional
    public ResponseEntity<?> save(Long id, StudentPostRequest request) {
        log.info("Create new student");
        School school = schoolService.findSchool(request.getSchoolId()).orElseThrow(() ->new SchoolNotFoundException("school not found"));
        Student student = studentRepo.save(mapper.createEntityFromPostRequest(request,school));
        StudentResponse response = mapper.createStudentResponse(student);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // function to delete the entire existing entry by id
    @Override
    @Transactional
    public void deleteStudent(Long id) {
        log.info("Delete student");
        Student studentFromDB = studentRepo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found"));
        passportService.deletePassport(studentFromDB.getPassport().getId());
        studentRepo.deleteById(id);
    }

    // function to replace an entry entirely
    @Override
    @Transactional
    public ResponseEntity<?> putStudent(Long id, StudentPostRequest request) {
        log.info("Replace(put) all student info");
        Student studentFromDB = studentRepo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found."));
        School school = schoolService.findSchool(request.getSchoolId()).orElseThrow(() ->new SchoolNotFoundException("school not found"));
        mapper.putStudent(studentFromDB, request, school);
        return new ResponseEntity<>(studentFromDB, HttpStatus.CREATED);
    }

    // function to replace any value of an existing entry
    @Override
    @Transactional
    public ResponseEntity<?> patchStudent(Long id, StudentPatchRequest request) {
        log.info("Replace(patch) some student info");
        Student studentFromDB = studentRepo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found."));
        School school = schoolService.findSchool(request.getSchoolId()).orElseThrow(() ->new SchoolNotFoundException("school not found"));
        mapper.patchStudent(studentFromDB, request, school);
        return new ResponseEntity<>(studentFromDB, HttpStatus.CREATED);
    }

}
