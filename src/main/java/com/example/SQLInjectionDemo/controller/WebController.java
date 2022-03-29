package com.example.SQLInjectionDemo.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.example.SQLInjectionDemo.model.IUserDAO;
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
public class WebController {
	//private LoginSessionManager loginSession;
	public WebController (HttpSession session) {
	}
	
	
	@RequestMapping("/")
	public String FirstController(HttpSession session) {
		String username = (String) session.getAttribute("username");
		if(username != null) {
			//session.invalidate();
			System.out.print(username);
		}else {
			System.out.print("failllllllllllllllllllledddddddddddddddddddd");
		}
		
		return "home";
	}
	
//	@RequestMapping("/error")
//	public String ErrorHandler(HttpSession session) {
//		
//		return "home";
//	}
}
