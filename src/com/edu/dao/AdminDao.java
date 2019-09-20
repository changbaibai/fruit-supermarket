package com.edu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
//import org.apache.ibatis.annotations.Param;
//import org.apache.ibatis.session.RowBounds;
import com.edu.po.Auser;

public interface AdminDao {
	public List<Auser> login(Auser auser);
}
