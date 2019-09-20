package com.edu.dao;

import java.util.List;
import java.util.Map;
//
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.edu.po.Goods;


public interface IndexDao {
	public List<Map<String, Object>> getFocusOrder();
	public List<Map<String, Object>> getLastedGoods(Goods goods);
	public Goods selectGoodsById(Integer id);
	public List<Goods> search(String mykey);
}
