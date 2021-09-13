package com.learning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learning.entity.StudentEntity;
import com.learning.repository.StudentRepository;
/**
 * 
 * @author nilkantha
 *
 */
@Service
@Transactional
public class StudentServiceImpl  implements StudentService{
	
	@Autowired
	StudentRepository studentRepository;

	public List<StudentDto> getAllStudents() {
		List <StudentDto> studentDtos = new ArrayList<StudentDto>();
		List <StudentEntity> studentEntity = studentRepository.findAllStudents();
		
		for (StudentEntity entity: studentEntity) {
			StudentDto dto = new StudentDto();
			BeanUtils.copyProperties(entity, dto);
			studentDtos.add(dto);
		}
		return studentDtos;
	}

	public StudentDto getStudent(int studentId) {
		StudentDto dto = new StudentDto();
		StudentEntity entity = studentRepository.findStudentById(studentId);
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	public StudentDto authentication(String email, String password) {
		StudentDto dto = new StudentDto();
		StudentEntity entity = studentRepository.authenticate(email, password);
		BeanUtils.copyProperties(entity, dto);
		return dto;
	
	}

	public String saveStudent(StudentDto dto) {

		StudentEntity entity = new StudentEntity();
		BeanUtils.copyProperties(dto, entity);
		String message = "";
		try {
			message = studentRepository.saveStudent(entity);
		} catch (Exception e) {
			message = "Error while Saving Student";
		}
		return message;
		
	}

	public String updateStudent(StudentDto dto) {
		StudentEntity entity = new StudentEntity();
		BeanUtils.copyProperties(dto, entity);
		String message = "";
		try {
			message = studentRepository.updateStudentById(entity);
		} catch (Exception e) {
			message = "Error while Updating Student";
		}
		return message;
	
	}

	public void deleteStudent(int studentId) throws Exception {
		studentRepository.deleteStudentById(studentId);
	}

	public void logOut() {
		// TODO Auto-generated method stub
		
	}

}
