package mapper;

import java.util.List;

import com.heima.mybatis.pojo.*;

public interface UserMapper {
	
	
	//遵循四个原则
	//接口方法名===User.xml中的id名 
	//返回值类型   与Mapper.xml文件的返回值类型一致
	//方法的入参类型与Mapper.xml中的入参类型一致
	//命名空间绑定此接口
	public User findUserById(Integer id);
	public Integer countUser();
}
