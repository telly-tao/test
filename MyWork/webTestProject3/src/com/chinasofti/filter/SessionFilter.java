package com.chinasofti.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)arg1;
		HttpServletResponse resp=(HttpServletResponse)arg2;
		HttpSession session=req.getSession();
		if(req.getRequestURI().contains("index.html")||req.getRequestURI().contains("LoginUserSevlet")){
			if(session.getAttribute("name")==null) {
				resp.sendRedirect("index.html");
			}else {
				arg2.doFilter(arg0, arg1);//把请求和响应给第二个过滤器，如果没有把请求和响应给Servlet
				
			}
		}
		else {
			arg2.doFilter(arg0, arg1);//把请求和响应给第二个过滤器，如果没有把请求和响应给Servlet
			
		}
	
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
