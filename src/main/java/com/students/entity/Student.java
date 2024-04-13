package com.students.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
@Slf4j
@Data
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
    private String firstName;
    private String lastName;
    private Integer age;
    private String specialty;
    @OneToOne(mappedBy = "student")
    private Passport passport;
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "school_id", referencedColumnName = "id")
//    private School school;
}
