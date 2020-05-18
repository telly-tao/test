package com.chinasofti.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.dao.UserDao;
import com.chinasofti.model.User;
import com.chinasofti.util.DbUtil;
import com.chinasofti.util.IDbUtil;

public class UserDaoImpl implements UserDao {
	@Override
	public User login(String username, String password) {
		User user = null;
		IDbUtil db=new DbUtil();
	
		String sql = "select * from tb_user where username='" + username + "' and password=MD5('" + password + "')";
		try {
			ResultSet rs = db.query(sql);
			if (rs.next()) {
				user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getString("sex"));
				user.setJg(rs.getString("jg"));
				user.setLove(rs.getString("love"));
				user.setJianjie(rs.getString("jianjie"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeQurey();
		}
		return user;
	}
	@Override
	public int reg(User user) {
		IDbUtil db=new DbUtil();
		String username=user.getUsername();
		String password=user.getPassword();
		String sex=user.getSex();
		String jg=user.getJg();
		String jianjie=user.getJianjie();
		String love=user.getLove();
		String sql="insert into tb_user (username,password,sex,jg,jianjie,love) values("
				+ "'"+username+"',"
						+ "MD5('"+password+"'),"
								+ "'"+sex+"',"
										+ "'"+jg+"',"
												+ "'"+jianjie+"',"
														+ "'"+love+"')";
		int result=db.update(sql);
		System.out.println("sql:"+sql+"执行结果:"+result);
		return result;
	}
	@Override
	public List<User> RequestList() {
		IDbUtil db = new DbUtil();
		List<User> list = new ArrayList<User>();
		// 从数据库获取数据
		String sql = "select * from tb_user";
		ResultSet rs = db.query(sql);
		try {
			boolean s=rs.next();
			while (s) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getString("sex"));
				user.setJg(rs.getString("jg"));
				user.setJianjie(rs.getString("jianjie"));
				user.setLove(rs.getString("love"));
				System.out.println("rs:" + rs.next());
				list.add(user);
				System.out.println("test:" + list);
			}
			System.out.println("sql:" + sql + "执行结果:" + rs);

		} catch (Exception e) {
			e.getStackTrace();
		}
		db.closeQurey();
		return list;
	}
}
