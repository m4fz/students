package com.students.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "passport")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
