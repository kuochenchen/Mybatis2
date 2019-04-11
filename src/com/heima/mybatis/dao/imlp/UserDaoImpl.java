package com.heima.mybatis.dao.imlp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.heima.mybatis.dao.UserDao;
import com.heima.mybatis.pojo.User;

public class UserDaoImpl implements UserDao{
	//注入工厂
	private SqlSessionFactory factory;

	public UserDaoImpl(SqlSessionFactory factory) {
		this.factory = factory;
	}
	//通过用户ID查询一个用户
	@Override
	public User selectUserById(Integer id){
		SqlSession session=factory.openSession();
		return session.selectOne("test.findUserById",11);		
	}
	public List<User> selectUserByUsername(Integer id){
		SqlSession session=factory.openSession();
		return session.selectList("test.findUserById",11);		
	}
	
	
}
