package com.chinasofti.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.model.User;
import com.chinasofti.service.UserService;
import com.chinasofti.service.impl.UserServiceImpl;

@WebServlet("/home")
public class HomeUserSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("Utf-8");
		req.setCharacterEncoding("Utf-8");
		UserService server=new UserServiceImpl();
		List<User> users=new ArrayList<User>();
		users =server.RequestList();
		req.setAttribute("userlist", users);
		req.getRequestDispatcher("userjsp/home.jsp").forward(req, resp);
	}

}
