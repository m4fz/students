package com.students;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class StudentsApplication {

	public static void main(String[] args) {
		log.info("Student app is running");
		var context = SpringApplication.run(StudentsApplication.class, args);
	}
}
