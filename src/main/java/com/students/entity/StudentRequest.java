package com.students.entity;

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

