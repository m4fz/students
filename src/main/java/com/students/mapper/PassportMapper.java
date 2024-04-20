package com.students.mapper;

import com.students.DTO.*;
import com.students.entity.Passport;
import com.students.entity.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
//mapper class that is used to change properties of table entries
public class PassportMapper {
    public Passport createPassportEntity(PassportRequest request, Student student){
        Passport passport = new Passport();
        passport.setSerialNumber(request.getSerialNumber());
        passport.setStudent(student);
        return passport;
    }
    public void putPassport(Passport passport, PassportRequest request, Student student){
        passport.setSerialNumber(request.getSerialNumber());
        passport.setStudent(student);
    }
    public void patchPassport(Passport passport, PassportPatchRequest request, Student student){
        if(request.getSerialNumber()!= null) passport.setSerialNumber(request.getSerialNumber());
        if(request.getStudentId()!= null) passport.setStudent(student);
    }
    public PassportResponse createPassportResponse(Passport passport){
        PassportResponse response = new PassportResponse();
        response.setId((passport.getId()));
        response.setSerialNumber(passport.getSerialNumber());
        response.setStudentId(passport.getStudent() != null ? passport.getStudent().getId() : 0);
        return response;
    }

    public List<PassportResponse> createPassportResponseList(List<Passport> passports){
        List<PassportResponse> responses = new ArrayList<>();
        passports.forEach(passport -> {responses.add(createPassportResponse(passport));
        });
        return responses;
    }
}
