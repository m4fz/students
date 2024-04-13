//package com.students.entity;
//
//import jakarta.persistence.*;
//import lombok.*;
//import lombok.extern.slf4j.Slf4j;
//
//import java.io.Serializable;
//import java.util.List;
//
//@Slf4j
//@Entity
//@Table(name = "school")
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public class School implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private long id;
//    @OneToMany(mappedBy = "School")
//    private List<Student> studentList;
//
//}
