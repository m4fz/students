package com.students.mapper;

import com.students.DTO.StudentPatchRequest;
import com.students.DTO.StudentPostRequest;
import com.students.DTO.StudentResponse;
import com.students.entity.School;
import com.students.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Component
//mapper class that is used to change properties of table entries
public class StudentMapper {
    public Student toEntity(StudentPostRequest request, School school){
        Student student = new Student();
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setAge(request.getAge());
        student.setSpecialty(request.getSpecialty());
        student.setSchool(school);
        return student;
    }
    public void putStudent(Student student, StudentPostRequest request, School school){
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setAge(request.getAge());
        student.setSpecialty(request.getSpecialty());
        student.setSchool(school);
    }
    public void patchStudent(Student student, StudentPatchRequest request, School school){
        if(request.getFirstName()!= null) student.setFirstName(request.getFirstName());
        if(request.getLastName()!= null) student.setLastName(request.getLastName());
        if(request.getAge()!= null) student.setAge(request.getAge());
        if(request.getSpecialty()!= null) student.setSpecialty(request.getSpecialty());
        if(school != null) student.setSchool(school);
    }

    public StudentResponse toResponse(Student student){
        if (student == null) return new StudentResponse();
        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setFirstName(student.getFirstName());
        response.setLastName(student.getLastName());
        response.setAge(student.getAge());
        response.setSpecialty(student.getSpecialty());
        response.setPassportId(student.getPassport() != null ? student.getPassport().getId() : 0);
        response.setSchoolId(student.getSchool() != null ? student.getSchool().getId() : 0);
        return response;
    }

    public List<StudentResponse> toResponseList(List<Student> students){
        if (students.isEmpty()) return Collections.emptyList();
        List<StudentResponse> responses = new ArrayList<>();
        students.forEach(student -> {responses.add(toResponse(student));
        });
        return responses;
    }

}
