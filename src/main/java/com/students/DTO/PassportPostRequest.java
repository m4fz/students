package com.students.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
public class PassportPostRequest {
    @NotBlank(message = "serial is empty")
    private String serialNumber;
    @Size(min = 1)
    private Long studentId;
}
