package com.chinasofti.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.util.DbUtil;
import com.chinasofti.util.MsgUtil;
import com.google.gson.Gson;

@WebServlet("/CheckNameServlet")
public class CheckNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DbUtil db=new DbUtil();
		String username=request.getParameter("username");
		String sql="select username from tb_user where username='"+username+"'";
		System.out.println("username:"+username);
		ResultSet rs=db.query(sql);
		Gson gson=new Gson();
		MsgUtil msg=new MsgUtil();
		PrintWriter out=response.getWriter();
		try {
			boolean bl=rs.next();
			if(bl) {
				System.out.println("success:"+username);
				msg.setSuccess(true);

			} else {
				System.out.println("fail:"+username);
				msg.setSuccess(false);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			db.closeQurey();
		}
		System.out.println("msg:"+msg);
		out.write(gson.toJson(msg));
		out.flush();
		out.close();
		
	}

}
