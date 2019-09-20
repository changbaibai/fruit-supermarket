package com.edu.service;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.edu.po.Buser;

public interface UserService {
	public String register(Buser buser,Model model, HttpSession session);
	public String login(Buser buser,Model model, HttpSession session);
}
