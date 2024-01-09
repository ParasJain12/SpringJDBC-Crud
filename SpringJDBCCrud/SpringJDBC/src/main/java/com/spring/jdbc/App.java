package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.jdbc.Entities.Student;
import com.spring.jdbc.dao.StudentDao;

public class App {
	public static void main(String[] args) {
		System.out.println("Program Started!");
		ApplicationContext context = new AnnotationConfigApplicationContext(JDBCConfig.class);
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		// Insert
		/*
		 * Student st = new Student();
		 * st.setStudentName("Anirudh"); 
		 * st.setStudentPhone("897654"); st.setStudentCity("Delhi"); 
		 * int result = studentDao.insert(st); 
		 * System.out.println("Data inserted: " + result);
		 */

		// Update
		/*
		 * Student st1 = new Student(); st1.setStudentName("Anamika");
		 * st1.setStudentPhone("8976540"); st1.setStudentCity("Dehradun"); int result1 =
		 * studentDao.change(st1,2); System.out.println("Data changed: " + result1);
		 */

		// Delete
		/*
		 * int result2 = studentDao.delete(3); System.out.println("Data deleted: " +
		 * result2);
		 */

		// Get data
		Student st2 = studentDao.getStudent(2);
		System.out.println(st2);

		// Get All data 
		List<Student> list = studentDao.getAllStudent(); 
		for(Student s:list)
		{
			System.out.println(s);
		}

	}
}
