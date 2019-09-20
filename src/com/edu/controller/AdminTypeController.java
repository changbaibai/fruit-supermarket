package com.edu.controller;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.edu.service.AdminTypeService;
@Controller
@RequestMapping("/adminType")
public class AdminTypeController extends BaseController{
	@Autowired
	private AdminTypeService adminTypeService;
	/**
	 * ���������ҳ��
	 */
	@RequestMapping("/toAddType")
	public String toAddType(Model model) {
		return adminTypeService.toAddType(model);
	}
	/**
	 * �������
	 */
	@RequestMapping("/addType")
	public String addType(String typename,Model model,HttpSession session) {
		return adminTypeService.addType(typename, model, session);
	}
	/**
	 * ��ɾ��ҳ��
	 */
	@RequestMapping("/toDeleteType")
	public String toDeleteType(Model model) {
		return adminTypeService.toDeleteType(model);
	}
	/**
	 * ɾ������
	 */
	@RequestMapping("/deleteType")
	public String deleteType(Integer id,Model model) {
		return adminTypeService.deleteType(id, model);
	}
	
}
