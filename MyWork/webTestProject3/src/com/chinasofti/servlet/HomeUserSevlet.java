package com.chinasofti.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.model.User;
import com.chinasofti.service.UserService;
import com.chinasofti.service.impl.UserServiceImpl;
import com.chinasofti.util.MsgUtil;
import com.google.gson.Gson;

@WebServlet("/home")
public class HomeUserSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Gson gson = new Gson();
		MsgUtil msg = new MsgUtil();
		String username=req.getParameter("username");
		UserService server=new UserServiceImpl();
		List<User> users =server.RequestList(username);
		System.out.println(users);
		PrintWriter out=resp.getWriter();
		if(users!=null) {
			msg.setSuccess(true);
			msg.setMessage(gson.toJson(users));
			System.out.println("gsonMsg:"+gson.toJson(msg));
			System.out.println("gsonUsers:"+gson.toJson(users));
			out.write(gson.toJson(msg));
			
		}else {
			msg.setSuccess(false);
			System.out.println("gsonMsg:"+gson.toJson(msg));
			out.write(gson.toJson(msg));
		}
		out.flush();
		out.close();
	}

}
