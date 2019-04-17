package hu.web.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.web.dao.UserDao;
import hu.web.pojo.User;

public class UserDaoImpl implements UserDao{

	/**
	 * 登录验证
	 */
	public User checkUserLoginDao(String name, String pwd) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		User u=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?"
					+ "serverTimezone=Asia/Shanghai&useSSL=false"
					, "scott", "hu970218");
			
			String sql="select * from t_user where uname=? and pwd=?";
			
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, name);
			ps.setString(2, pwd);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				u=new User();
				u.setUid(rs.getInt("uid"));
				u.setAge(rs.getInt("age"));
				u.setBirth(rs.getString("birth"));
				u.setPwd(rs.getString("pwd"));
				u.setSex(rs.getString("sex"));
				u.setUname(rs.getString("uname"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps!=null) {
				
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(conn!=null) {
				
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return u;
	}

	/**
	 * 更新密码
	 */
	public int updatePwdDao(int id, String pwd) {
		Connection conn=null;
		PreparedStatement ps=null;
		int num=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?"
					+ "serverTimezone=Asia/Shanghai&useSSL=false"
					, "scott", "hu970218");
			
			String sql="update t_user set pwd=? where uid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, pwd);
			ps.setInt(2, id);
			
			num=ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(ps!=null) {
				
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(conn!=null) {
				
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return num;
	}

	/**
	 * 获得所有用户信息
	 */
	public List<User> useShowDao() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<User> list=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?"
					+ "serverTimezone=Asia/Shanghai&useSSL=false"
					, "scott", "hu970218");
			
			String sql="select * from t_user";
			
			ps=conn.prepareStatement(sql);
			
			rs=ps.executeQuery();
			list=new ArrayList<User>();
			while(rs.next()) {
			    User u=new User();
				u.setUid(rs.getInt("uid"));
				u.setAge(rs.getInt("age"));
				u.setBirth(rs.getString("birth"));
				u.setPwd(rs.getString("pwd"));
				u.setSex(rs.getString("sex"));
				u.setUname(rs.getString("uname"));
				list.add(u);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps!=null) {
				
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(conn!=null) {
				
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	/**
	 * 用户注册
	 */
	public int userRegDao(User user) {
		Connection conn=null;
		PreparedStatement ps=null;
		int num=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?"
					+ "serverTimezone=Asia/Shanghai&useSSL=false"
					, "scott", "hu970218");
			
			String sql="insert into t_user values(default,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUname());
			ps.setString(2, user.getPwd());
			ps.setString(3, user.getSex());
			ps.setInt(4, user.getAge());
			ps.setString(5, user.getBirth());
			num=ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(ps!=null) {
				
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(conn!=null) {
				
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return num;
	}
	
	
	
	
	
}
