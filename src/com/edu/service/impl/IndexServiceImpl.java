package com.edu.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;




import com.edu.dao.AdminTypeDao;
import com.edu.dao.IndexDao;
import com.edu.service.IndexService;
import com.edu.po.Buser;
import com.edu.po.Goods;



@Service
public class IndexServiceImpl implements IndexService{
	@Autowired
	private IndexDao indexDao;
	@Autowired
	private AdminTypeDao adminTypeDao;

	@Override
	public String before(Model model, HttpSession session, Goods goods) {
		session.setAttribute("goodsType", adminTypeDao.selectGoodsType());
		model.addAttribute("focuslist", indexDao.getFocusOrder());
		if(goods.getId() == null) 
			goods.setId(0);
		model.addAttribute("lastedlist", indexDao.getLastedGoods(goods));
		return "before/index";
	}

	@Override
	public String toRegister(Model model) {
		model.addAttribute("rbuser", new Buser());
		return "before/register";
	}

	@Override
	public String toLogin(Model model) {
		model.addAttribute("lbuser", new Buser());
		return "before/login";
	}

	@Override
	public String goodsDetail(Model model, Integer id) {
		Goods goods = indexDao.selectGoodsById(id);
		model.addAttribute("goods", goods);
		return "before/goodsdetail";
	}



	@Override
	public String search(Model model, String mykey) {
		List<Goods> list = indexDao.search(mykey);
		model.addAttribute("searchlist", list);
		return "before/searchResult";
	}
	
}
