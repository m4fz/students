package com.students.service;

import com.students.DTO.SubjectRequest;
import com.students.entity.Student;
import com.students.entity.Subject;
import com.students.exceptions.SubjectNotFoundException;
import com.students.mapper.SubjectMapper;
import com.students.repository.StudentRepo;
import com.students.repository.SubjectRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService{
    private final SubjectRepo repo;
    private final StudentRepo studentRepo;
    private final SubjectMapper mapper; //@Qualifier can be used in a constructor to select one of many mappers in,
    // for example, an interface that is implemented in many mapper classes

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> getSubjectList() {
        return new ResponseEntity<>(mapper.toResponseList(repo.findAll()),HttpStatus.OK);
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> getSubjectById(Long id) {
        Optional<Subject> subject = repo.findById(id);
        if (subject.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(mapper.toResponse(subject.get()), HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<?> save(SubjectRequest request) {
        List<Student> students = studentRepo.findAllById(request.getStudents());
        Subject subject = repo.save(mapper.toEntity(request,students));
        return new ResponseEntity<>(mapper.toResponse(subject), HttpStatus.CREATED);
    }

    @Override
    @Transactional
    public void deleteSubject(Long id) {
        repo.deleteById(id);
    }


    @Override
    @Transactional
    public ResponseEntity<?> patchSubject(Long id, SubjectRequest request) {
        Subject subject = repo.findById(id).orElseThrow(() -> new SubjectNotFoundException("subject not found"));
        List<Student> students = studentRepo.findAllById(request.getStudents());
        mapper.putSubject(request,subject, students);
        return new ResponseEntity<>(mapper.toResponse(subject),HttpStatus.OK);
    }

}
