package com.students.service;

import com.students.DTO.StudentPatchRequest;
import com.students.DTO.StudentResponse;
import com.students.entity.Student;
import com.students.DTO.StudentRequest;
import com.students.exceptions.StudentNotFoundException;
import com.students.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;

    // function to get all existing entries
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> getAllStudents() {
        log.info("Get all students");
        List<Student> studentsFromDB = studentRepo.findAll();
        List<StudentResponse> responses = new ArrayList<>(studentsFromDB.size());
        studentsFromDB.forEach(st -> {StudentResponse response = new StudentResponse(
                st.getId(), st.getFirstName(), st.getLastName(), st.getAge(), st.getSpecialty(), st.getPassport() == null ? 0 : st.getPassport().getId());
            responses.add(response);
        });
        return new ResponseEntity<>(studentRepo.findAll(), HttpStatus.OK);
    }

    // function to get an existing entry by its id
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> findStudentById(Long id) {
        log.info("Find student by id");
        if (studentRepo.findById(id).isPresent()){
            return new ResponseEntity<>(studentRepo.findById(id).get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(studentRepo.findById(id).get(), HttpStatus.NOT_FOUND);
    }

    // function to create a new entry
    @Override
    @Transactional
    public ResponseEntity<?> save(StudentRequest student) {
        log.info("Create new student");
        Student newStudent = new Student();
        newStudent.setFirstName(student.getFirstName());
        newStudent.setLastName(student.getLastName());
        newStudent.setAge(student.getAge());
        newStudent.setSpecialty(student.getSpecialty());
        return new ResponseEntity<>(studentRepo.save(newStudent), HttpStatus.CREATED);
    }

    // function to delete the entire existing entry by id
    @Override
    @Transactional
    public void deleteStudent(Long id) {
        log.info("Delete student");
        studentRepo.deleteById(id);
    }

    // function to replace an entry entirely
    @Override
    @Transactional
    public ResponseEntity<?> putStudent(Long id, StudentRequest student) {
        log.info("Replace(put) all student info");
        Student studentFromDB = studentRepo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found."));
        studentFromDB.setFirstName(student.getFirstName());
        studentFromDB.setLastName(student.getFirstName());
        studentFromDB.setAge(student.getAge());
        studentFromDB.setSpecialty(student.getSpecialty());
        return new ResponseEntity<>(studentFromDB, HttpStatus.CREATED);
    }

    // function to replace any value of an existing entry
    @Override
    @Transactional
    public ResponseEntity<?> patchStudent(Long id, StudentPatchRequest student) {
        log.info("Replace(patch) some student info");
        Student studentFromDB = studentRepo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found."));
        Optional<StudentPatchRequest > studentOptional = Optional.ofNullable(student);
        if (studentOptional.isPresent()){
            if(studentOptional.get().getFirstName() != null){
                studentFromDB.setFirstName(studentOptional.get().getFirstName());
            }
            if(studentOptional.get().getLastName() != null){
                studentFromDB.setLastName(studentOptional.get().getLastName());
            }
            if(studentOptional.get().getAge() != null){
                studentFromDB.setAge(studentOptional.get().getAge());
            }
            if(studentOptional.get().getSpecialty() != null){
                studentFromDB.setSpecialty(studentOptional.get().getSpecialty());
            }
        }
        return new ResponseEntity<>(studentFromDB, HttpStatus.CREATED);
    }

}
