package com.students.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
//making a DTO object
public class StudentRequest {
    @NotBlank(message = "firstName is empty")
    private String firstName;

    @NotBlank(message = "lastName is empty")
    private String lastName;

    @Min(value = 0, message = "Min value is 0")
    @Max(value = 120, message = "Max value is 120")
    @NotNull(message = "age is null")
    private Integer age;

    @NotBlank(message = "specialty is empty")
    private String specialty;
}

