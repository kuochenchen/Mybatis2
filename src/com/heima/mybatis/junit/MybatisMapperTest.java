package com.heima.mybatis.junit;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.heima.mybatis.pojo.User;

import mapper.UserMapper;

public class MybatisMapperTest {
	@Test
	public void testMapper() throws IOException{
		//加载核心配置文件
		String resource="SqlMapConfig.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session=factory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user=userMapper.findUserById(10);
		System.out.println(user);
	}
}
