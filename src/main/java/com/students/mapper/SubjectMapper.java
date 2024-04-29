package com.students.mapper;

import com.students.DTO.SubjectRequest;
import com.students.DTO.SubjectResponse;
import com.students.entity.Student;
import com.students.entity.Subject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SubjectMapper {
    private final StudentMapper studentMapper;
    public Subject toEntity(SubjectRequest request,List<Student> students) {
        Subject subject = new Subject();
        subject.setName(request.getName());
        subject.setStudents(students);
        return subject;
    }

    public void putSubject(SubjectRequest request, Subject entity, List<Student> students) {
        entity.setName(request.getName());
        entity.setStudents(students);
    }

    public void patchSubject(SubjectRequest request, Subject entity, List<Student> students) {
        entity.setName(request.getName());
        entity.setStudents(students);
}
    public SubjectResponse toResponse(Subject entity){
        if(entity == null) return new SubjectResponse();
        return new SubjectResponse(entity.getId(), entity.getName(), studentMapper.toResponseList(entity.getStudents()));
    }
    public List<SubjectResponse> toResponseList(List<Subject> entityList){
        if(entityList == null) return Collections.emptyList();
        return entityList.stream().map(entity -> new SubjectResponse(entity.getId(),entity.getName(),
                studentMapper.toResponseList(entity.getStudents()))).toList();
    }
}
