package hu.web.service;

import java.util.List;

import hu.web.pojo.User;


public interface UserService {
	//验证登录
	User checkUserLoginService(String name,String pwd);
	
	//修改密码
	int updatePwdService(int id,String pwd);
	
	//得到所有用户信息
	List<User> userShowService();
	
	//用户注册
	int userRegService(User user);
}
