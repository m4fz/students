package com.students.mapper;

import com.students.DTO.SchoolRequest;
import com.students.DTO.SchoolResponse;
import com.students.entity.School;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SchoolMapper {
    private final StudentMapper stMapper;

    public SchoolResponse toResponse(School school){
        return new SchoolResponse(school.getId(),school.getName(),stMapper.toResponseList(school.getStudentList()));
    }
    public School toEntity(SchoolRequest request){
        School school = new School();
        school.setName(request.getName());
        return school;
    }
    public List<SchoolResponse> toResponseList(List<School> schools) {
        return schools.stream().map(this::toResponse).toList();

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
