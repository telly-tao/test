package com.chinasofti.model;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

public class User {
	private int id;
	
	private String username;
	
	private String password;
	
	private String sex;

	private String jg;
	
	private String jianjie;
	
	private String love;
	
	

	public User() {
	}

	public User(HttpServletRequest req) {
		this.username=req.getParameter("username");
		this.password = req.getParameter("password");
		this.sex = req.getParameter("sex");
		this.jg = req.getParameter("jg");
		this.jianjie = req.getParameter("jianjie");
		String[] loves = req.getParameterValues("love");
		if(loves != null && loves.length != 0) {
			love = Arrays.toString(loves).replace("[", "").replace("]", "");
		}
	}
	
	public String getLove() {
		return love;
	}

	public void setLove(String love) {
		this.love = love;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getJg() {
		return jg;
	}

	public void setJg(String jg) {
		this.jg = jg;
	}

	public String getJianjie() {
		return jianjie;
	}

	public void setJianjie(String jianjie) {
		this.jianjie = jianjie;
	}
	
	

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", sex=" + sex + ", jg=" + jg
				+ ", jianjie=" + jianjie + ", love=" + love + "]";
	}

}
