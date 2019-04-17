package hu.web.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import hu.web.dao.impl.UserDaoImpl;
import hu.web.pojo.User;
import hu.web.service.UserService;
public class UserServiceImpl implements UserService{

	Logger logger=Logger.getLogger(UserServiceImpl.class);
	UserDaoImpl udi=new UserDaoImpl();
	//验证用户登录
	public User checkUserLoginService(String name, String pwd) {
		//记录日志
		
		logger.debug(name+"请求登录");
		
		
		User u=udi.checkUserLoginDao(name, pwd);
		
		if(u!=null) {
			logger.debug(name+"登录成功");
		}else {
			logger.debug(name+"登录失败");
		}
		
		return u;
	}

	//修改用户密码
	public int updatePwdService(int id, String pwd) {
		
		logger.debug(id+"请求修改密码");
		int num = udi.updatePwdDao(id, pwd);
		if(num>0) {
			logger.debug(id+"修改密码成功");
		}else {
			logger.debug(id+"修改密码失败");
		}
		return num;
	}

	/**
	 * 得到所有用户信息
	 */
	public List<User> userShowService() {
		
		logger.debug("请求所有用户信息");
		List<User> list=udi.useShowDao();
		
		if(list!=null) {
			logger.debug("获得所有用户信息");
		}else {
			logger.debug("请求所有用户信息失败");
		}
		
		return list;
	}

	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	public int userRegService(User user) {
		logger.debug("用户注册");
		int num=udi.userRegDao(user);
		if(num>0) {
			logger.debug("用户注册成功");
		}else {
			logger.debug("用户注册失败");
		}
		return num;
	}

	

	
	
}
