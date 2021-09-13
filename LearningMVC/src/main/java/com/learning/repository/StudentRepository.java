package com.learning.repository;

import java.util.List;

import com.learning.entity.StudentEntity;
/**
 * 
 * @author nilkantha
 *
 */
public interface StudentRepository {

	public List<StudentEntity> findAllStudents();

	public StudentEntity findStudentById(int studentId);

	public StudentEntity authenticate(String email, String password);

	public String saveStudent(StudentEntity entity) throws Exception;

	public String updateStudentById(StudentEntity entity) throws Exception;

	public void deleteStudentById(int studentId) throws Exception;

}
