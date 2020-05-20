package com.chinasofti.listener;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.chinasofti.util.DbUtil;

public class ContextListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		ServletContext context=event.getServletContext();
		DbUtil db=new DbUtil();
		Integer i=(Integer) context.getAttribute("count");
		if(i!=null) {
			String sql="update tb_count SET usercount='"+i+"' ";
			System.out.println("sql:"+sql);
			db.update(sql);
			//context.setAttribute("count", i);
		}
		
		System.out.println("上下文被销毁了");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("上下文被创建了");
		String sql="select usercount from tb_count";
		DbUtil db=new DbUtil();
		ResultSet rs= db.query(sql);
		try {
			rs.next();
			Integer i=rs.getInt("usercount")+1;
			ServletContext context=event.getServletContext();
			context.setAttribute("count", i);
			System.out.println("访问"+i+"次成功！");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.closeQurey();
		}
	}
}
