package com.students.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
@Entity
@Table(name = "passport")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
// creating a new table with its columns
public class Passport implements Serializable {
    //specifying the id and making it a primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //making other columns
    @Column(unique = true)
    private String serialNumber;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;
    public void setStudent(Student student){
        this.student = student;
        student.setPassport(this);
    }
}
