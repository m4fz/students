package com.students.DTO;

import lombok.*;

@Data
@AllArgsConstructor
//making a DTO object
public class StudentPatchRequest {
    private String firstName;
    private String lastName;
    private Integer age;
    private String specialty;
}

