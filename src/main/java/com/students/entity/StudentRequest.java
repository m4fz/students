package com.students.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class StudentRequest {
    private String firstName;
    private String lastName;
    private Integer age;
    private String specialty;
}

