package hu.web.service;

import java.util.List;

import hu.web.pojo.User;


public interface UserService {
	//��֤��¼
	User checkUserLoginService(String name,String pwd);
	
	//�޸�����
	int updatePwdService(int id,String pwd);
	
	//�õ������û���Ϣ
	List<User> userShowService();
	
	//�û�ע��
	int userRegService(User user);
}
