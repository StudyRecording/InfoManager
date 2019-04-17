package hu.web.dao;

import java.util.List;

import hu.web.pojo.User;

public interface UserDao {
	//验证用户（登录）
	User checkUserLoginDao(String name,String pwd);
	
	//修改密码
	int updatePwdDao(int id,String pwd);
	
	//获得所有用户信息
	List<User> useShowDao();
	
	//用户注册
	int userRegDao(User user);
}
