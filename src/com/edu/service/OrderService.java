package com.edu.service;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
public interface OrderService {
	public String orderSubmit(Model model, HttpSession session,Integer amount);
	public String pay(Integer ordersn);
}
