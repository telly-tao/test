package com.chinasofti.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.model.User;
import com.chinasofti.service.UserService;
import com.chinasofti.service.impl.UserServiceImpl;
import com.chinasofti.util.TurnPageUtil;
@WebServlet("/search")
public class SearchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pg=req.getParameter("page");
		if(pg!=null&&!pg.equals("")) {
			TurnPageUtil.page=Integer.parseInt(pg);
		}
		String username=req.getParameter("username");
		UserService server=new UserServiceImpl();
		List<User> users =server.SerarchList(username);
		int count =server.countpage(username);
		
		System.out.println(users);
		int page=TurnPageUtil.page;
		
		req.setAttribute("userlist", users);
		req.setAttribute("searchname", username);
		req.setAttribute("page",page);
		req.setAttribute("count",count);
		req.getRequestDispatcher("userjsp/home.jsp").forward(req, resp);

	}

	
}
