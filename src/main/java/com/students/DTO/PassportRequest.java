package com.students.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PassportRequest {
    @NotBlank(message = "serial is empty")
    private String serialNumber;
    @Size(min = 1)
    private Long studentId;
}
