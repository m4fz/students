package com.students.DTO;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//making a DTO object
public class StudentPatchRequest {
    private String firstName;
    private String lastName;
    private Integer age;
    private String specialty;
    private Long schoolId;
}

