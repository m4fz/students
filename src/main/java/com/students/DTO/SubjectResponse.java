package com.students.DTO;

import com.students.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.el.lang.ELArithmetic;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectResponse {
    private Long id;
    private String name;
    private List<StudentResponse> students;


}
