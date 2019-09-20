package com.edu.service;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.edu.po.Auser;

public interface AdminService {
	public String login(Auser auser, Model model, HttpSession session);
}
