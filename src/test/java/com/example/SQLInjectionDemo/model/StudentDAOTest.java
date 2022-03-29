package com.example.SQLInjectionDemo.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class StudentDAOTest {

	private DriverManagerDataSource dataSource;
	private StudentDAO dao;
	
//	@BeforeEach
//	void beforeEachTest() {
//		dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/studentdb");
//		dataSource.setUsername("root");
//		dataSource.setPassword("root");
//		
//		dao = new StudentDAO(dataSource);
//	}
//	
//	@Test
//	void testSave() {
//		Student student = new Student("Hung Le", "hl@gmail.com", "235 Nguyen Tat Thanh", "12/10");
//		int result = dao.addStudent(student);
//		assertTrue(result > 0);
//	}
//	
//	@Test
//	void testGetStudents() {
//		assertTrue(1 >0);
//	}
//
//	@Test
//	void testGetStudentById() {
//		assertTrue(1 >0);
//	}

//	@Test
//	void testUpdateStudent() {
//		Student student = new Student(7, "Vincent Le", "hl@gmail.com", "235 Nguyen Tat Thanh", "12/10"); 
//		int result = dao.updateStudent(student);
//		assertTrue(result > 0);
//	}

//	@Test
//	void testAddStudent() {
//		assertTrue(1 >0);
//	}
//
//	@Test
//	void testDeleteStudent() { 
//		int i = 9;
//		int result = dao.deleteStudent(i);
//		assertTrue(result > 0);
//	}

}
