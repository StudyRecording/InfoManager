package hu.web.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import hu.web.dao.impl.UserDaoImpl;
import hu.web.pojo.User;
import hu.web.service.UserService;
public class UserServiceImpl implements UserService{

	Logger logger=Logger.getLogger(UserServiceImpl.class);
	UserDaoImpl udi=new UserDaoImpl();
	//��֤�û���¼
	public User checkUserLoginService(String name, String pwd) {
		//��¼��־
		
		logger.debug(name+"�����¼");
		
		
		User u=udi.checkUserLoginDao(name, pwd);
		
		if(u!=null) {
			logger.debug(name+"��¼�ɹ�");
		}else {
			logger.debug(name+"��¼ʧ��");
		}
		
		return u;
	}

	//�޸��û�����
	public int updatePwdService(int id, String pwd) {
		
		logger.debug(id+"�����޸�����");
		int num = udi.updatePwdDao(id, pwd);
		if(num>0) {
			logger.debug(id+"�޸�����ɹ�");
		}else {
			logger.debug(id+"�޸�����ʧ��");
		}
		return num;
	}

	/**
	 * �õ������û���Ϣ
	 */
	public List<User> userShowService() {
		
		logger.debug("���������û���Ϣ");
		List<User> list=udi.useShowDao();
		
		if(list!=null) {
			logger.debug("��������û���Ϣ");
		}else {
			logger.debug("���������û���Ϣʧ��");
		}
		
		return list;
	}

	/**
	 * �û�ע��
	 * @param user
	 * @return
	 */
	public int userRegService(User user) {
		logger.debug("�û�ע��");
		int num=udi.userRegDao(user);
		if(num>0) {
			logger.debug("�û�ע��ɹ�");
		}else {
			logger.debug("�û�ע��ʧ��");
		}
		return num;
	}

	

	
	
}
