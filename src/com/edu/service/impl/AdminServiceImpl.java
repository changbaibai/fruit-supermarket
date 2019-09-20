package com.edu.service.impl;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import com.edu.dao.AdminDao;
import com.edu.dao.AdminTypeDao;
import com.edu.po.Auser;
import com.edu.service.AdminService;
//@Service("adminService")
//@Transactional
@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private AdminTypeDao adminTypeDao;
	@Override
	public String login(Auser auser, Model model, HttpSession session) {
		if(adminDao.login(auser) != null && adminDao.login(auser).size() > 0) {
			session.setAttribute("auser", auser);
			session.setAttribute("goodsType", adminTypeDao.selectGoodsType());
			return "admin/indexA";
		}
		model.addAttribute("msg", "密码或是用户名错误！");
		return "admin/login";
	}

}
