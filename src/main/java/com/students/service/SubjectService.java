package com.students.service;

import com.students.DTO.StudentPatchRequest;
import com.students.DTO.StudentPostRequest;
import com.students.DTO.SubjectRequest;
import com.students.DTO.SubjectResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SubjectService {
    ResponseEntity<?> getSubjectList();

    ResponseEntity<?> getSubjectById(Long id);
    ResponseEntity<?> save(SubjectRequest request);

    void deleteSubject(Long id);


    ResponseEntity<?> patchSubject(Long id, SubjectRequest request);

}
