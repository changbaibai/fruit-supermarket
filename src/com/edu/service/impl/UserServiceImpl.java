package com.edu.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.edu.dao.UserDao;
import com.edu.service.UserService;
import com.edu.po.Buser;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	@Override
	public String register(Buser buser, Model model, HttpSession session) {

		int n = userDao.register(buser);
		if(n > 0) {
			return "before/login";
		}else {
			model.addAttribute("msg", "注册成功！");
			return "before/register";
		}
	}

	@Override
	public String login(Buser buser, Model model, HttpSession session) {
		Buser ruser = null;
		List<Buser> list = userDao.login(buser);
		if(list.size() > 0) {
			ruser = list.get(0);
		}
		if(ruser != null) {
			session.setAttribute("bruser", ruser);
			return "forward:/before";
		}else {
			model.addAttribute("msg", "用户名或密码错误！");
			return "before/login";
		}
	}
}
