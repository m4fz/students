package com.students.DTO;

import com.students.entity.Student;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectRequest {
    @NotEmpty
    private String name;
    @Nullable
    private List<Long> students;
}
