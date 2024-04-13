package com.students.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
@Slf4j

@Data
@AllArgsConstructor
public class ErrorDetails {
    private Date time;
    private String message;
    private String details;
}
