package com.students.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.students.DTO.StudentPostRequest;
import com.students.DTO.StudentResponse;
import com.students.entity.Student;
import com.students.repository.StudentRepo;
import com.students.service.StudentService;
import com.students.service.StudentServiceImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private StudentRepo studentRepo;
    private final String GET_ALL_STUDENTS_URL = "/api/v1/students";
    private final String GET_STUDENT_URL = "/api/v1/student/%s";
    private final String CREATE_STUDENT_URL = "/api/v1/student";
    private final String testStudentFN = UUID.randomUUID().toString();
    private final String testStudentLN = UUID.randomUUID().toString();

    public void setup(){
    }
    @AfterAll
    public static void finishSetup(){

    }
    @Test
    void getStudents() {
        Student testStudent = Student.builder().firstName(testStudentFN).lastName(testStudentLN).age(44).specialty("test")
                .build();
        studentRepo.save(testStudent);
        var response = restTemplate.exchange(GET_ALL_STUDENTS_URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<StudentResponse>>() {
        });

        StudentResponse studentResponse = StudentResponse.builder().firstName(testStudentFN).lastName(testStudentLN).age(44).specialty("test").passportId(0l).schoolId(0l)
                .build();
        assertNotNull(response);
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().size() > 1);
//        assertTrue(response.getBody().contains(studentResponse));
        studentRepo.delete(testStudent);
    }

    @Test
    void getStudentById() {
        var response = restTemplate.getForEntity(String.format(GET_STUDENT_URL, 12),StudentResponse.class);

        assertNotNull(response);
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertNotNull(response.getBody());
        assertEquals(12, response.getBody().getId());
    }

    @Test
    void saveStudent() {
        StudentPostRequest request = StudentPostRequest.builder().firstName(testStudentFN).lastName(testStudentLN).age(44).specialty("test").schoolId(1L)
                .build();
        var response = restTemplate.exchange(CREATE_STUDENT_URL, HttpMethod.POST, new HttpEntity<>(request) , new ParameterizedTypeReference<>() {});

        assertNotNull(response);
        assertTrue(response.getStatusCode().is2xxSuccessful());
    }

    @Test
    void putStudent() {
    }

    @Test
    void patchStudent() {
    }

    @Test
    void deleteStudent() {
    }

    @Test
    void testGetStudents() {
    }

    @Test
    void testGetStudentById() {
    }

    @Test
    void testSaveStudent() {
    }

    @Test
    void testPutStudent() {
    }

    @Test
    void testPatchStudent() {
    }

    @Test
    void testDeleteStudent() {
    }
}