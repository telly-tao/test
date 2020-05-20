package com.chinasofti.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class LoginOut implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		Object obj= event.getSession().getAttribute("id");
		if(obj!=null) {
			System.out.println("用户"+obj.toString()+"退出了");
		}
		
	}

	

}
