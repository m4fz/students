package com.students;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentsApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(StudentsApplication.class, args);
	}
}
