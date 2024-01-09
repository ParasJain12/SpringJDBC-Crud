package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.Entities.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(Student st) {
		String query = "insert into students(sName,sPhone,sCity) values(?,?,?)";
		int r = this.jdbcTemplate.update(query, st.getStudentName(), st.getStudentPhone(), st.getStudentCity());
		return r;
	}

	public int change(Student st, int studentId) {
		String query = "update students set sName=?,sPhone=?,scity=? where sId=?";
		int r = this.jdbcTemplate.update(query, st.getStudentName(), st.getStudentPhone(), st.getStudentCity(),
				studentId);
		return r;
	}

	public int delete(int studentId) {
		String query = "delete from students where sId=?";
		int r = this.jdbcTemplate.update(query, studentId);
		return r;
	}

	public Student getStudent(int studentId) {
		String query = "select * from students where sId=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
		return student;
	}

	public List<Student> getAllStudent() {
		String query = "select * from students";
		List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());
		return students;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
