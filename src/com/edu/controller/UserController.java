package com.edu.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.po.Buser;
import com.edu.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/register")
	public String register(@ModelAttribute Buser buser,Model model, HttpSession session) {
		return userService.register(buser, model, session);
	}

	@RequestMapping("/login.action")
	public String login(@ModelAttribute Buser buser,Model model, HttpSession session) {
		return userService.login(buser, model, session);
	}
	@RequestMapping("/exit")
	public String exit(HttpSession session) {
		session.invalidate();
		return "forward:/before";
	}
}
