package com.students.DTO;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PassportResponse {
    private Long id;

    private String serialNumber;

    private Long studentId;
}
