package com.learning.repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learning.entity.StudentEntity;

//@Repository
/**
 * StudentORMRepository implemented using SPRINGBOOT so no need of this class.
 * 
 * @author nilkantha
 *
 */
@Deprecated
public class StudentRepositoryImpl implements StudentRepository {

	@Autowired
	@Qualifier("pkDataSource")
	private DataSource datasource;

	private JdbcTemplate jdbcTemplate;

	// Default Constructor for the class.
	public StudentRepositoryImpl() {

	}

	@PostConstruct
	private void init() {
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	public List<StudentEntity> findAllStudents() {
		List<StudentEntity> students = jdbcTemplate.query("select * from student",
				new BeanPropertyRowMapper(StudentEntity.class));
		return students;
	}

	public StudentEntity findStudentById(int studentId) {
		StudentEntity entity = jdbcTemplate.queryForObject("select * from student where studentId=?",
				new Object[] { studentId }, new BeanPropertyRowMapper(StudentEntity.class));

		return entity;
	}

	public StudentEntity authenticate(String email, String password) {
		StudentEntity entity = jdbcTemplate.queryForObject("select * from student where email=? and password=?",
				new Object[] { email, password }, new BeanPropertyRowMapper(StudentEntity.class));
		return entity;
	}

	public String saveStudent(StudentEntity entity) {
		Object[] data = { entity.getName(), entity.getEmail(), entity.getPassword(), entity.getMobile(),
				entity.getAddress() };
		String updateQuery = "insert into student (name, email, password, mobile, address) values (?,?,?,?,?)";
		int rowCount = jdbcTemplate.update(updateQuery, data);
		return rowCount > 0 ? "Insert Successful" : "Insert Failed.";
	}

	public String updateStudentById(StudentEntity entity) {
		Object[] data = { entity.getName(), entity.getEmail(), entity.getPassword(), entity.getMobile(),
				entity.getAddress(), entity.getStudentId() };
		String updateQuery = "update student set name=?, email=?, password=?, mobile=?, address=? where studentId=?";
		int rowCount = jdbcTemplate.update(updateQuery, data);
		return rowCount > 0 ? "Update Successful" : "Update Failed.";

	}

	public void deleteStudentById(int studentId) throws Exception {
		jdbcTemplate.update("delete from student where studentId=?", new Object[] { studentId });

	}

}
