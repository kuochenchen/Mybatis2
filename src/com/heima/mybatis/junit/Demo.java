package com.heima.mybatis.junit;


import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.heima.mybatis.pojo.User;

public class Demo {
	@Test
	public void test1() throws IOException{
		//加载核心配置文件
		String resource="SqlMapConfig.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = factory.openSession();
		//执行sql语句
		User user=sqlSession.selectOne("test.findUserById", 10);
		System.out.println(user);
	}
	@Test
	public void findUserByUsername() throws IOException{
		//加载核心配置文件
		String resource="SqlMapConfig.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = factory.openSession();
		//执行sql语句
		List<User> user=sqlSession.selectList("test.findUserByUsername", "五");
		System.out.println(user);
	}
	//添加用户
	@Test
	public void insertUser() throws IOException{
		//加载核心配置文件
		String resource="SqlMapConfig.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = factory.openSession();
		//执行sql语句
		User user1=new User();
		user1.setUsername("何炅");
		user1.setSex("男");
		user1.setBirthday(new Date());
		user1.setAddress("北京");
		sqlSession.insert("test.insertUser", user1);
		sqlSession.commit();
		System.out.println(user1.getId());
		
		//保存订单
		
	}
	@Test
	public void updateUser() throws IOException{
		//加载核心配置文件
		String resource="SqlMapConfig.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = factory.openSession();
		//执行sql语句
		User user1=new User();
		user1.setUsername("何炅");
		user1.setSex("女");
		user1.setBirthday(new Date());
		user1.setAddress("北京");
		sqlSession.insert("test.updateUserById", user1);
		sqlSession.commit();
		System.out.println(user1.getId());
		
		//保存订单
		
	}
}
