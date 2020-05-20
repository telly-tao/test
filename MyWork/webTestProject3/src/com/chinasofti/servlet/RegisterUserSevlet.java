package com.chinasofti.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.model.User;
import com.chinasofti.service.UserService;
import com.chinasofti.service.impl.UserServiceImpl;
import com.chinasofti.util.MsgUtil;
import com.google.gson.Gson;

@WebServlet("/RegisterUserSevlet")
public class RegisterUserSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request,response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		User user = new User(request);
		UserService userService = new UserServiceImpl();
		int row = userService.reg(user);
		Cookie[]  cookies=request.getCookies();
		System.out.println("cookies:"+cookies);
		if(cookies!=null&&cookies.length!=0) {
			for(Cookie c:cookies) {
				System.out.println("name:"+c.getName()+",value:"+c.getValue());
			}
		}
		Gson gson=new Gson();
		MsgUtil msg=new MsgUtil();
		PrintWriter out=response.getWriter();
		if(row != 0) {
			msg.setSuccess(true);
			
		}else {
			msg.setSuccess(false);
		}
		System.out.println("msg:"+msg);
		out.write(gson.toJson(msg));
		out.flush();
		out.close();
	}

}
