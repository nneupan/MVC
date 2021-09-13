package com.learning.service;

import java.util.List;
/**
 * 
 * @author nilkantha
 *
 */
public interface StudentService {
	public List<StudentDto> getAllStudents();
	
	public StudentDto getStudent (int studentId);
	
	public StudentDto authentication(String email, String password);
	
	public String saveStudent(StudentDto dto);
	
	public String updateStudent (StudentDto dto);
	
	public void deleteStudent(int studentId) throws Exception;
	
	public void logOut() ;

}
