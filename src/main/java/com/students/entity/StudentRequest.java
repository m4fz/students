package com.students.entity;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
//making a DTO object
public class StudentRequest {
    private String firstName;
    private String lastName;
    private Integer age;
    private String specialty;
}

