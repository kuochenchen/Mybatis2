package com.heima.mybatis.junit;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.heima.mybatis.dao.UserDao;
import com.heima.mybatis.dao.imlp.UserDaoImpl;
import com.heima.mybatis.pojo.User;

public class MybatisDaoTest {
	private SqlSessionFactory factory;
	@Before
	public void before() throws IOException{
		//加载核心配置文件
		String resource="SqlMapConfig.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		factory=new SqlSessionFactoryBuilder().build(inputStream);
				
	}
	@Test
	public void testDao(){
		
		UserDao userDao=new UserDaoImpl(factory);
		User user=userDao.selectUserById(10);
		System.out.println(user);
	}
}
