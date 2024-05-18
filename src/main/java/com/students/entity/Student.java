package com.students.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
// creating a new table with its columns
public class Student implements Serializable {
    //specifying the id and making it a primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    //making other columns
    private String firstName;
    private String lastName;
    private Integer age;
    private String specialty;
    @OneToOne(mappedBy = "student", cascade = CascadeType.REMOVE)
    private Passport passport;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "school_id")
    private School school;

    @ManyToMany(mappedBy = "students")
    private List<Subject> subjects;

//    public void setSchool(School school){
//        this.school = school;
//        school.setStudents(new ArrayList<>(List.of(this)));
//    }
}
