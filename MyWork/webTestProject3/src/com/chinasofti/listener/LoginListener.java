package com.chinasofti.listener;

import java.util.Date;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class LoginListener implements HttpSessionAttributeListener {

	@SuppressWarnings("deprecation")
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		String name=event.getName();
		if(name.equals("id")) {
			Date d=new Date();
			System.out.println("ÓÃ»§"+event.getValue()+"¡¾µÇÂ¼¡¿" +d.toLocaleString());
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub

	}

}
