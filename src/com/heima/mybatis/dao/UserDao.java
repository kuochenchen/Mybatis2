package com.heima.mybatis.dao;

import com.heima.mybatis.pojo.User;

public interface UserDao {
	public User selectUserById(Integer id);
}
