package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.Entities.Student;

public interface StudentDao {
    public int insert(Student st);
    
    public int change(Student st,int studentId);
    
    public int delete(int studentId);
    
    public Student getStudent(int studentId);
    
    public List<Student> getAllStudent();
}
