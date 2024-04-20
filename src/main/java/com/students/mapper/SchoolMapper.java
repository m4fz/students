package com.students.mapper;

import com.students.DTO.PassportPatchRequest;
import com.students.DTO.SchoolRequest;
import com.students.DTO.SchoolResponse;
import com.students.entity.Passport;
import com.students.entity.School;
import com.students.entity.Student;
import com.students.exceptions.PassportNotFoundException;
import com.students.repository.SchoolRepo;
import com.students.repository.StudentRepo;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class SchoolMapper {
    private StudentMapper stMapper;

    public SchoolResponse createSchoolResponse(School school){
        return new SchoolResponse(school.getId(),school.getName(),stMapper.createStudentResponseList(school.getStudentList()));
    }
    public School createSchoolEntity(SchoolRequest request){
        School school = new School();
        school.setName(request.getName());
        return school;
    }
    public List<SchoolResponse> schoolResponseList(List<School> schools) {
        return schools.stream().map(this::createSchoolResponse).toList();

//        можно было:

//        List<SchoolResponse> responses = new ArrayList<>();
//        schools.forEach(school -> {responses.add(createSchoolResponse(school));
//        });
//        return responses;
    }
    public void putSchool(School school, SchoolRequest request){
        school.setName(request.getName());
    }

}
