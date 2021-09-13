package com.learning.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learning.entity.StudentEntity;
/**
 * 
 * @author nilkantha
 *
 */
@Repository("StudentORMRepositoryImpl")
public class StudentORMRepositoryImpl implements StudentRepository {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public List<StudentEntity> findAllStudents() {
		List<StudentEntity> students = getSession().createQuery("from StudentEntity").getResultList();
		return students;
	}

	public StudentEntity findStudentById(int studentId) {
		TypedQuery<StudentEntity> query = getSession()
				.createQuery("from StudentEntity t where t.studentId=:pStudentId");
		query.setParameter("pStudentId", studentId);

		StudentEntity student = query.getSingleResult();
		return student;
	}

	public StudentEntity authenticate(String email, String password) {
		// Need Error Check
		// for invalidate userId and Password
		@SuppressWarnings("unchecked")
		TypedQuery<StudentEntity> query = getSession()
				.createQuery("from StudentEntity t where t.email=:pEmail and t.password=:pPassword");
		query.setParameter("pEmail", email);
		query.setParameter("pPassword", password);
		StudentEntity student = null;
		student = query.getSingleResult();

		//
		return student;

	}

	public String saveStudent(StudentEntity entity) throws Exception {
		try {
			getSession().save(entity);
		} catch (Exception e) {
			return "Error while Saving Student.";
		}

		return "success"; // Need to check if there is save failure.
	}

	public String updateStudentById(StudentEntity entity) throws Exception {
		try {
			getSession().merge(entity);
		} catch (Exception e) {
			return "Error while Saving Student.";
		}

		return "success"; // Need To check if there is any error.
	}

	public void deleteStudentById(int studentId) throws Exception {
		StudentEntity entity = findStudentById(studentId);
		getSession().delete(entity);
	}

}
