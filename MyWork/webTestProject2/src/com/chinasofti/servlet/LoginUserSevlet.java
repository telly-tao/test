package com.chinasofti.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.model.User;
import com.chinasofti.service.UserService;
import com.chinasofti.service.impl.UserServiceImpl;


@WebServlet("/login")
public class LoginUserSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
//		String username=request.getParameter("username");
//		String password=request.getParameter("password");
//		UserService server=new UserServiceImpl();
//		User user=server.getUser(username,password);
//		if(user!=null) {
//			response.sendRedirect("index.html");
//		}else {
//			response.sendRedirect("home.html");
//		}
//		ServletContext context =this.getServletContext();
//		context.setAttribute("count", 1);
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		UserService server=new UserServiceImpl();
		User user=server.getUser(username,password);
		if(user!=null) {
//			Cookie cookie=new Cookie("username", user.getUsername());
//			response.addCookie(cookie);
//			System.out.println("add cookie:"+cookie);
			System.out.println(" to home");
			response.sendRedirect("search");

			
		}else {
			response.sendRedirect("userjsp/index.jsp");
		}
	}

}
