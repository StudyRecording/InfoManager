package hu.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import hu.web.pojo.User;
import hu.web.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	
	Logger logger=Logger.getLogger(UserServlet.class);
	UserServiceImpl usi=new UserServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//�����������Ӧ����
		req.setCharacterEncoding("utf8");
		resp.setContentType("text/html;charset=utf8");
		//������ر�ǩ���ݣ��鿴�Ƿ��ǵ�¼��
		String oper=req.getParameter("oper");
		if(oper==null) {
			logger.debug("��������ȡʧ��");
		}
		
		if("login".equals(oper)) {
			//�û���¼��֤
			checkUserLogin(req, resp);
		}else if("out".equals(oper)) {
			//�û��˳�
			userOut(req,resp);
		}else if("pwd".equals(oper)) {
			//��������
			updatePwd(req,resp);
		}else if("reg".equals(oper)) {
			userReg(req,resp);
		}else if("show".equals(oper)) {
			userShow(req,resp);
		}else {
			logger.debug("����������");
		}
		
		
		
	}
	
	/**
	 * ע���û�
	 * @param req
	 * @param resp
	 */
	private void userReg(HttpServletRequest req, HttpServletResponse resp) {
		//����������ݲ�������ش���
		String name=req.getParameter("uname");
		String pwd=req.getParameter("pwd");
		String sex=req.getParameter("sex");
		String ageStr=req.getParameter("age");
		int age=0;
		if("".equals(ageStr)) {
			age=0;			
		}else {
			age=Integer.parseInt(ageStr);
		}
		String birth=req.getParameter("birth");
		
		String[] arr=birth.split("/");
		
		birth=arr[2]+"-"+arr[0]+"-"+arr[1];
		
		User user=new User(0, name, pwd, sex, age, birth);
		
		int num = usi.userRegService(user);
		
		if(num>0) {
			HttpSession hs=req.getSession();
			hs.setAttribute("flag", 2);
			
			try {
				resp.sendRedirect("/infomanager/login.jsp");
			} catch (IOException e) {
				logger.debug("ע���ض���ʧ��");
			}
		}
		
	}

	/**
	 * ��ʾ�����û���Ϣ
	 */
	private void userShow(HttpServletRequest req, HttpServletResponse resp) {
		
		List<User> list=usi.userShowService();
		if(list!=null) {
			req.setAttribute("userList", list);
			
			try {
				req.getRequestDispatcher("/user/usershow.jsp").forward(req, resp);
				return;
			} catch (ServletException e) {
				logger.debug("��ȡ�����û���Ϣת��ʧ��");
			} catch (IOException e) {
				logger.debug("��ȡ�����û���Ϣת��ʧ��");
			}
			
		}
		
		
	}

	/**
	 * �޸�����
	 * @param req
	 * @param resp
	 */
	private void updatePwd(HttpServletRequest req, HttpServletResponse resp) {
		//�õ�������
		String newPwd=req.getParameter("newPwd");
		
		//�õ��û�id
		HttpSession hs=req.getSession();
		User user=(User)hs.getAttribute("user");
		int id=user.getUid();
		//�޸�����
		int num = usi.updatePwdService(id, newPwd);
		
		//����session
		user.setPwd(newPwd);
		hs.setAttribute("user", user);
		
		if(num>0) {
			
			hs.setAttribute("flag", 1);
			try {
				resp.sendRedirect("/infomanager/login.jsp");
			} catch (IOException e) {
				logger.debug("�޸������ض���ʧ��");
			}
		}
		
	}

	/**
	 * �˳���¼
	 * @param req
	 * @param resp
	 */
	private void userOut(HttpServletRequest req,HttpServletResponse resp) {
		HttpSession hs=req.getSession();
		
		hs.invalidate();
		
		try {
			resp.sendRedirect("/infomanager/login.jsp");
		} catch (IOException e) {
			logger.debug("�˳��ض������");
		}
	}
	
	/**
	 * �û���¼��֤
	 * @param req
	 * @param resp
	 */
	
	private void checkUserLogin(HttpServletRequest req,HttpServletResponse resp) {
		
		//�õ�ҳ����������û���������
		String name=req.getParameter("uname");
		String pwd=req.getParameter("pwd");
		System.out.println(name+":"+pwd);
		
		User user=usi.checkUserLoginService(name, pwd);
		if(user!=null) {
			try {
				
				HttpSession hs=req.getSession();
				hs.setAttribute("user", user);
				
				resp.sendRedirect("/infomanager/main/main.jsp");
				return;
			} catch (IOException e) {
				logger.debug("������ҳ�ض���ʧ��");
			}
		}else {
			
			req.setAttribute("flag2", "success");
			/*
			 * HttpSession hs=req.getSession(); hs.setAttribute("flag", 0);
			 */
			
			try {
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
				return;
			} catch (ServletException e) {
				logger.debug("����ת��ʧ��");
			} catch (IOException e) {
				logger.debug("����ת��ʧ��");
			}
		}
		
	}
}
