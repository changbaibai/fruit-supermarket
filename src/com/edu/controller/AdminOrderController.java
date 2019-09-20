package com.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.service.AdminOrderService;

@Controller
@RequestMapping("/adminOrder")
public class AdminOrderController extends BaseController{
	@Autowired
	private AdminOrderService adminOrderService;
	@RequestMapping("/orderInfo")
	public String orderInfo(Model model) {
		return adminOrderService.orderInfo(model);
	}
	@RequestMapping("/deleteorderManager")
	public String deleteorderManager(Integer id) {
		return adminOrderService.deleteorderManager(id);
	}
}
