package com.students.mapper;

import com.students.DTO.StudentPatchRequest;
import com.students.DTO.StudentRequest;
import com.students.DTO.StudentResponse;
import com.students.entity.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentMapper {
    public Student createEntityFromPostRequest(StudentRequest request){
        Student student = new Student();
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setAge(request.getAge());
        student.setSpecialty(request.getSpecialty());
        return student;
    }
    public void putStudent(Student student, StudentRequest request){
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setAge(request.getAge());
        student.setSpecialty(request.getSpecialty());
    }
    public void patchStudent(Student student, StudentPatchRequest request){
        if(request.getFirstName()!= null) student.setFirstName(request.getFirstName());
        if(request.getLastName()!= null) student.setLastName(request.getLastName());
        if(request.getAge()!= null) student.setAge(request.getAge());
        if(request.getSpecialty()!= null) student.setSpecialty(request.getSpecialty());
    }

    public StudentResponse createStudentResponse(Student student){
        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setFirstName(student.getFirstName());
        response.setLastName(student.getLastName());
        response.setAge(student.getAge());
        response.setSpecialty(student.getSpecialty());
        response.setPassportId(student.getPassport() != null ? student.getPassport().getId() : 0);
        return response;
    }

    public List<StudentResponse> createStudentResponseList(List<Student> students){
        List<StudentResponse> responses = new ArrayList<>();
        students.forEach(student -> {responses.add(createStudentResponse(student));
        });
        return responses;
    }

}
