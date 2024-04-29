package com.students.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Entity
@Table(name = "school")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class School implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "school")
    private List<Student> studentList = new ArrayList<>();
//    public void setStudents(List<Student> students){
//        this.studentList = students;
//        students.forEach(student -> student.setSchool(this));
//    }
}
