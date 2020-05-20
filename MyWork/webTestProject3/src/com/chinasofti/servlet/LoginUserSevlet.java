package com.chinasofti.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasofti.model.User;
import com.chinasofti.service.UserService;
import com.chinasofti.service.impl.UserServiceImpl;
import com.chinasofti.util.MsgUtil;
import com.google.gson.Gson;

@WebServlet("/LoginUserSevlet")
public class LoginUserSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Gson gson = new Gson();
		MsgUtil msg = new MsgUtil();
//		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String imgCode = request.getParameter("imgCode");
		String sessionimgCode = (String) session.getAttribute("imgCode");

		PrintWriter out = response.getWriter();
		
		if (imgCode.equals(sessionimgCode)) {
			UserService server = new UserServiceImpl();
			User user = server.getUser(username, password);
			System.out.println("username:" + username);
			if (user != null) {
				session.setAttribute("id", username);
				System.out.println("success:" + username);
				msg.setSuccess(true);
			} else {
				System.out.println("fail:" + username);
				msg.setSuccess(false);
			}
		} else {
			msg.setSuccess(false);
			msg.setMessage("ÑéÖ¤Âë´íÎó£¡");
		}
		out.write(gson.toJson(msg));
		out.flush();
		out.close();
	}

}
