package com.students.service;

import com.students.entity.Student;
import com.students.entity.StudentRequest;
import com.students.exceptions.StudentNotFoundException;
import com.students.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> getAllStudents() {
        return new ResponseEntity<>(studentRepo.findAll(), HttpStatus.OK);
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> findStudentById(Long id) {
        if (studentRepo.findById(id).isPresent()){
            return new ResponseEntity<>(studentRepo.findById(id).get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(studentRepo.findById(id).get(), HttpStatus.NOT_FOUND);
    }

    @Override
    @Transactional
    public ResponseEntity<?> save(StudentRequest student) {
        Student newStudent = new Student();
        newStudent.setFirstName(student.getFirstName());
        newStudent.setLastName(student.getLastName());
        newStudent.setAge(student.getAge());
        newStudent.setSpecialty(student.getSpecialty());
        return new ResponseEntity<>(studentRepo.save(newStudent), HttpStatus.CREATED);
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }

    @Override
    @Transactional
    public ResponseEntity<?> putStudent(Long id, StudentRequest student) {
        Student studentFromDB = studentRepo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found."));
        Optional<StudentRequest> studentOptional = Optional.ofNullable(student);
        studentFromDB.setFirstName(studentOptional.map(StudentRequest::getFirstName).orElseThrow(NullPointerException::new));
        studentFromDB.setLastName(studentOptional.map(StudentRequest::getLastName).orElseThrow(NullPointerException::new));
        studentFromDB.setAge(studentOptional.map(StudentRequest::getAge).orElseThrow(NullPointerException::new));
        studentFromDB.setSpecialty(studentOptional.map(StudentRequest::getSpecialty).orElseThrow(NullPointerException::new));
        return new ResponseEntity<>(studentFromDB, HttpStatus.CREATED);
    }

    @Override
    @Transactional
    public ResponseEntity<?> patchStudent(Long id, StudentRequest student) {
        Student studentFromDB = studentRepo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found."));
        Optional<StudentRequest> studentOptional = Optional.ofNullable(student);
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
