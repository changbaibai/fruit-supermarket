package com.edu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.edu.po.Buser;

public interface UserDao {
	public int register(Buser buser);
	public List<Buser> login(Buser buser);
}
