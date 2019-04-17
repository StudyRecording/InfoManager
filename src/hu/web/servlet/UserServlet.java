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
		//设置请求和响应编码
		req.setCharacterEncoding("utf8");
		resp.setContentType("text/html;charset=utf8");
		//获得隐藏标签内容，查看是否是登录表单
		String oper=req.getParameter("oper");
		if(oper==null) {
			logger.debug("操作符获取失败");
		}
		
		if("login".equals(oper)) {
			//用户登录验证
			checkUserLogin(req, resp);
		}else if("out".equals(oper)) {
			//用户退出
			userOut(req,resp);
		}else if("pwd".equals(oper)) {
			//更新密码
			updatePwd(req,resp);
		}else if("reg".equals(oper)) {
			userReg(req,resp);
		}else if("show".equals(oper)) {
			userShow(req,resp);
		}else {
			logger.debug("操作符错误");
		}
		
		
		
	}
	
	/**
	 * 注册用户
	 * @param req
	 * @param resp
	 */
	private void userReg(HttpServletRequest req, HttpServletResponse resp) {
		//获得请求数据并进行相关处理
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
				logger.debug("注册重定向失败");
			}
		}
		
	}

	/**
	 * 显示所有用户信息
	 */
	private void userShow(HttpServletRequest req, HttpServletResponse resp) {
		
		List<User> list=usi.userShowService();
		if(list!=null) {
			req.setAttribute("userList", list);
			
			try {
				req.getRequestDispatcher("/user/usershow.jsp").forward(req, resp);
				return;
			} catch (ServletException e) {
				logger.debug("获取所有用户信息转发失败");
			} catch (IOException e) {
				logger.debug("获取所有用户信息转发失败");
			}
			
		}
		
		
	}

	/**
	 * 修改密码
	 * @param req
	 * @param resp
	 */
	private void updatePwd(HttpServletRequest req, HttpServletResponse resp) {
		//得到新密码
		String newPwd=req.getParameter("newPwd");
		
		//得到用户id
		HttpSession hs=req.getSession();
		User user=(User)hs.getAttribute("user");
		int id=user.getUid();
		//修改密码
		int num = usi.updatePwdService(id, newPwd);
		
		//设置session
		user.setPwd(newPwd);
		hs.setAttribute("user", user);
		
		if(num>0) {
			
			hs.setAttribute("flag", 1);
			try {
				resp.sendRedirect("/infomanager/login.jsp");
			} catch (IOException e) {
				logger.debug("修改密码重定向失败");
			}
		}
		
	}

	/**
	 * 退出登录
	 * @param req
	 * @param resp
	 */
	private void userOut(HttpServletRequest req,HttpServletResponse resp) {
		HttpSession hs=req.getSession();
		
		hs.invalidate();
		
		try {
			resp.sendRedirect("/infomanager/login.jsp");
		} catch (IOException e) {
			logger.debug("退出重定向错误");
		}
	}
	
	/**
	 * 用户登录验证
	 * @param req
	 * @param resp
	 */
	
	private void checkUserLogin(HttpServletRequest req,HttpServletResponse resp) {
		
		//得到页面中输入的用户名和密码
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
				logger.debug("进入主页重定向失败");
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
				logger.debug("请求转发失败");
			} catch (IOException e) {
				logger.debug("请求转发失败");
			}
		}
		
	}
}
