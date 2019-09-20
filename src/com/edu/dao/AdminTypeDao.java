package com.edu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.edu.po.Goods;
import com.edu.po.GoodsType;
//@Repository("adminTypeDao")
//@Mapper
public interface AdminTypeDao {
	public List<GoodsType> selectGoodsType();
	public int addType(String typename);
	public int deleteType(Integer id);
	public List<Goods> selectGoodsByType(Integer id);
}
