package hu.web.dao;

import java.util.List;

import hu.web.pojo.User;

public interface UserDao {
	//��֤�û�����¼��
	User checkUserLoginDao(String name,String pwd);
	
	//�޸�����
	int updatePwdDao(int id,String pwd);
	
	//��������û���Ϣ
	List<User> useShowDao();
	
	//�û�ע��
	int userRegDao(User user);
}
