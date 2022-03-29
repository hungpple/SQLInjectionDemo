package com.example.SQLInjectionDemo.controller;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.ArrayList;

import com.example.SQLInjectionDemo.model.*;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class UserController {
	@Autowired
	private IUserDAO userDAO;
	
	public UserController() {
	}
	
	@RequestMapping("/user")
	public ModelAndView DisplayLogin(ModelAndView model) {
		User user = new User();
    	model.addObject("user", user);
    	model.setViewName("login_page");
        return model;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String ProcessLogin(@ModelAttribute User user, HttpServletRequest request) {
		User aUser = userDAO.getUser(user.getUserName(), user.getPassword());
		if(aUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("username", aUser.getUserName());
			return "home";
		}
		return "login_page";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String ProcessLogout(@ModelAttribute User user, HttpServletRequest request, HttpSession session) {
		String username = (String) session.getAttribute("username");
		if(username != null) {
			session.invalidate();
			return "home";
		}
		return "home";
	}
	
	@RequestMapping(value = "/new_account", method = RequestMethod.GET)
    public ModelAndView creatNewUserForm(ModelAndView model) {
    	User newUser = new User();
    	model.addObject("user", newUser);
    	model.setViewName("sign_up");
        return model;
    }
	
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute User user, HttpServletRequest request) {
		// check if account exsited
		if(userDAO.checkUserById(user.getUserName()) == null) {
			userDAO.addUser(user);
		} else {
			request.setAttribute("errorMessage", "The account have not created successfully! Please try again.");
			String s = (String)request.getAttribute("errorMessage");
			return new ModelAndView ("redirect:/new_account");
		}

        return new ModelAndView ("redirect:/");
    }
	
	
	
}
