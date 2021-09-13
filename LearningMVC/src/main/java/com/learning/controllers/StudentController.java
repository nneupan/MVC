package com.learning.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learning.service.StudentDto;
import com.learning.service.StudentService;
/**
 * 
 * @author nilkantha
 *
 */
@Controller
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@GetMapping ("/testing")
	public String test() {
		System.out.println("My controller is called.");
		return "hello";
	}
	

	@GetMapping("/getAllStudent")
	public String getAllStudents(Model model) {
		// Call Service to Get Student List
		List<StudentDto> students = studentService.getAllStudents();
		// Set List in Request
		model.addAttribute("studentList", students);

		return "showAllStudents"; // JSP File Name
	}

	@GetMapping("/StudentDetail")
	public String getStudent(@RequestParam int studentId, Model model) {
		// get StudentId
		// Get STudent Details from Service
		StudentDto dto = studentService.getStudent(studentId);
		// Pass the Student in request
		model.addAttribute("student", dto);

		return "showStudent"; // JSP file name
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	//@GetMapping("/home")
	@GetMapping({"/home","/"})
	public String home() {
		return "index";
	}

	@PostMapping("/authentication")
	public String authentication(@RequestParam String email, @RequestParam String password, Model model,
			HttpSession session) {
		// Call Authentication in StudentDTO
		try {
			StudentDto dto = studentService.authentication(email, password);
			if (dto != null) {
				model.addAttribute("student", dto);
				session.setAttribute("studentData", dto);
				return "redirect:home";
			} else {
				model.addAttribute("message", "Email or Password is not correct.");
				return "login";
			}
		} catch (Exception ex) {
			model.addAttribute("message", "Email or Password is not correct.");
			return "login";
		}

	}

	@GetMapping("/Registration")
	public String register() {
		return "registration";
	}

	@PostMapping("/register")
	public String registration(@ModelAttribute StudentDto dto, Model model) {
		// Call Save Student in studentService
		String message = studentService.saveStudent(dto);

		// Add attribute in model
		model.addAttribute("message", message);
		return "registration";
	}

	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam int studentId, Model model) {
		String message = null;

		// StudentService deleteStudent method
		try {
			studentService.deleteStudent(studentId);
			message = "Deleted Successfully.";
		} catch (Exception e) {
			message = "Error on deletion";
		}
		// Update message
		model.addAttribute("message", message);
		// return what you want to show or redirect to page

		return "redirect:getAllStudent"; // redirect to the page
	}

	@GetMapping("/updateStudent")
	public String updateStudent(@RequestParam int studentId, Model model) {
		// call StudentDto studentService get Student so that you will have the old data
		// to update
		StudentDto dto = studentService.getStudent(studentId);
		// Add attribute in model
		model.addAttribute("student", dto);
		return "updateStudent";
	}

	@PostMapping("/updateStudent")
	public String editStudent(@ModelAttribute StudentDto dto, Model model) {
		// Call Update Stduent
		String message = studentService.updateStudent(dto);
		// Add attribute in model
		model.addAttribute("message", message);
		// return
		// where you want to land.
		return "updateStudent";
	}

	@GetMapping("/logout")
	public String logOut(Model model, HttpSession session) {
		// Anything to do with Model???
		session.setAttribute("studentData", null);
		if (session != null) {
			session.removeAttribute("studentData");
		}
		return "redirect:login";
	}

}
