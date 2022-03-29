package com.example.SQLInjectionDemo.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.example.SQLInjectionDemo.model.*;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class StudentController {
	private List<Student> students = new ArrayList<Student>();
	@Autowired
	private IStudentDAO studentDAO;
	//private LoginSessionManager loginSession;
	
	public StudentController() {
	//	loginSession = new LoginSessionManager();
	}
	
//	
//	@RequestMapping("/")
//	public String FirstController() {
//		System.out.print("General Chill");
//		return "home";
//	}
//	
	// List all student
	@RequestMapping(value = "/student_list", method = RequestMethod.GET)
	public ModelAndView  ListAllStudents(ModelAndView model) throws IOException{
	    List<Student> listStudent = studentDAO.getStudents();
	    model.addObject("studentList", listStudent);
	    model.setViewName("student_list");
	 
	    return model;
	}
	
	
	//Search student
	@GetMapping("/search") 
	public ModelAndView searchStudent(HttpServletRequest request, ModelAndView model) {
	    String studentId = String.valueOf(request.getParameter("id"));
	    List<Student> studentList = studentDAO.getStudentById(studentId);
	    model.addObject("studentList", studentList);
	    model.setViewName("student_list");
	 
	    return model;
	}
	
	
	// Add student form
	@RequestMapping(value = "/add_student", method = RequestMethod.GET)
    public ModelAndView addNewStudentForm(ModelAndView model, HttpSession session) {
		String username = (String) session.getAttribute("username");
		if(username != null) {
			System.out.print(username);
			Student newStudent = new Student();
	    	model.addObject("student", newStudent);
	    	model.setViewName("add_student");
	        return model;
		}else {
			return new ModelAndView ("redirect:/login");
		}
    }
	
	
	// Edit student form
	@RequestMapping(value = "/update_student", method = RequestMethod.GET)
    public ModelAndView updateStudentForm(HttpServletRequest request, ModelAndView model, HttpSession session) {
		String username = (String) session.getAttribute("username");
		if(username != null) {
			String id = String.valueOf(request.getParameter("id"));
			Student student = studentDAO.getStudentById(id).get(0);
			model.addObject("student", student);
	    	model.setViewName("update_student");
	        return model;
		}else {
			return new ModelAndView ("redirect:/login");
		}
    }
	
	// Save student
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveStudent(@ModelAttribute Student student) {
		if(student.getId() > 0) {
			studentDAO.updateStudent(student);
		} else {
			studentDAO.addStudent(student);
		}

        return new ModelAndView ("redirect:/student_list");
    }
	
	
	// Delete student
	@GetMapping("/delete") 
	public ModelAndView deleteStudent(HttpServletRequest request, HttpSession session) {
		String username = (String) session.getAttribute("username");
		if(username != null) {
		    int studentId = Integer.parseInt(request.getParameter("id"));
		    studentDAO.deleteStudent(studentId);
		    return new ModelAndView("redirect:/student_list");
		}else {
			return new ModelAndView ("redirect:/login");
		}
	}
	
}
