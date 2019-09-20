package com.edu.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.edu.dao.AdminOrderDao;
import com.edu.service.AdminOrderService;

//@Service("adminOrderService")
//@Transactional
@Service
public class AdminOrderServiceImpl implements AdminOrderService{
	@Autowired
	private AdminOrderDao adminOrderDao;
	@Override
	public String orderInfo(Model model) {
		List<Map<String,Object>> list = adminOrderDao.orderInfo();
		model.addAttribute("orderList", list);
		return "admin/orderManager";
	}
	@Override
	public String deleteorderManager(Integer id) {
		//��ɾ����ϸ
		adminOrderDao.deleteOrderDetail(id);
		//��ɾ����������
		adminOrderDao.deleteOrderBase(id);
		return "forward:/adminOrder/orderInfo";
	}

}
