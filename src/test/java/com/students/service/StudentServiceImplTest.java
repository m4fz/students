package com.students.service;

import com.students.DTO.StudentResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(MockitoExtension.class)
//class StudentServiceImplTest {
//    //if any test does not pass, project will not build
//    @Mock
//    private StudentRepo studentRepo;
//    @Mock
//    private StudentMapper mapper;
//    @Mock
//    private PassportService passportService;
//    @Mock
//    private SchoolService schoolService;
//    @InjectMocks
//    private StudentServiceImpl studentService;
//
////    private final StudentRepo studentRepo;
////    private final StudentMapper mapper;
////    private final PassportService passportService;
////    private final SchoolService schoolService;
////    private final StudentServiceImpl studentService;
////
////    StudentServiceImplTest(StudentRepo studentRepo, StudentMapper mapper, PassportService passportService, SchoolService schoolService, StudentServiceImpl studentService) {
////        this.studentRepo = studentRepo;
////        this.mapper = mapper;
////        this.passportService = passportService;
////        this.schoolService = schoolService;
////        this.studentService = studentService;
//
//
//
//    @Test
//    void getAllStudents() {
//        Student student1 = Student.builder()
//                .id(7l).firstName("ivan").lastName("ivanov").age(20).specialty("javadev").school(null)
//                .build();
//        Student student2 = Student.builder()
//                .id(12l).firstName("John").lastName("Bach").age(18).specialty("none").school(null)
//                .build();
//
//        Mockito.when(studentRepo.findAll()).thenReturn(List.of(student1,student2));
//
//        ResponseEntity<?> response = studentService.getAllStudents();
//        Assertions.assertNotNull(response.getBody());
//        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
//        Assertions.assertEquals(2,((List<StudentResponse>)response.getBody()).size());
//    }
//
//    @Test
//    void findStudentById() {
//    }
//
//    @Test
//    void save() {
//    }
//
//    @Test
//    void deleteStudent() {
//    }
//
//    @Test
//    void putStudent() {
//    }
//
//    @Test
//    void patchStudent() {
//    }
//}