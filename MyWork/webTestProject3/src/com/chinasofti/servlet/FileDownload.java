package com.chinasofti.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/fileDownload")
public class FileDownload extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileName=req.getParameter("fileName");
		
		//…Ë÷√œÏ”¶Õ∑
		resp.addHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(fileName,"utf-8"));
		resp.setContentType("application/x-download");
		
		FileInputStream fis=new FileInputStream(new File("D:\\Tools\\files\\"+fileName));
		ServletOutputStream out =resp.getOutputStream();
		
		int c=0;
		byte[] buf=new byte[1024];
		while((c=fis.read(buf,0,buf.length))!=-1) {
			out.write(buf,0,c);
		}
		fis.close();
		out.close();
		
	}

	
}
