package com.edu.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController extends BaseBeforeController{
	@Autowired
	private CartService cartService;
	/**
	 * ��ע��Ʒ
	 */
	@RequestMapping("/focus")
	public String focus(Model model,Integer id, HttpSession session) {
		return cartService.focus(model, id, session);
	}
	/**
	 * ��ӹ��ﳵ
	 */
	@RequestMapping("/putCart")
	public String putCart(Model model,Integer shoppingnum, Integer id, HttpSession session) {
		return cartService.putCart(model, shoppingnum, id, session);
	}
	/**
	 * ��ѯ���ﳵ
	 */
	@RequestMapping("/selectCart")
	public String selectCart(Model model, HttpSession session) {
		return cartService.selectCart(model, session);
	}
	/**
	 * ɾ�����ﳵ
	 */
	@RequestMapping("/deleteAgoods")
	public String deleteAgoods(Integer id,HttpSession session) {
		return cartService.deleteAgoods(id, session);
	}
	/**
	 * ��չ��ﳵ
	 */
	@RequestMapping("/clear")
	public String clear(HttpSession session) {
		return cartService.clear(session);
	}
	/**
	 * ȥ����
	 */
	@RequestMapping("/orderConfirm")
	public String orderConfirm(Model model, HttpSession session) {
		return cartService.orderConfirm(model, session);
	}
}
