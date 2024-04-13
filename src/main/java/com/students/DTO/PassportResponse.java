package com.students.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PassportResponse {
    private Long id;

    private String serialNumber;

    private Long studentId;
}
