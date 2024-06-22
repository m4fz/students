package com.students.DTO;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class StudentResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String specialty;
    private Long passportId;
    private Long schoolId;

}
