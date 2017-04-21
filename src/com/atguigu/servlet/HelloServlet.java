package com.atguigu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet implements Servlet {

	public void destroy() {
		System.out.println("destory()...");
	}

	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig()...");
		return null;
	}

	public String getServletInfo() {
		System.out.println("getServletInfo()...");
		return null;
	}

	public void init(ServletConfig servletConfig) throws ServletException {
		System.out.println("init()...");
		
		ServletContext servletContext = servletConfig.getServletContext();
		Enumeration<String> names = servletContext.getInitParameterNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			System.out.println("name:" + name);
		}
		
		String realPath = servletContext.getRealPath("/temp");
		System.out.println("realPaht:" + realPath);
		
		String contextPath = servletContext.getContextPath();
		System.out.println("contextPath:" + contextPath);
	}

	public void service(ServletRequest req, ServletResponse resp)
			throws ServletException, IOException {
		
		Map<String,String[]> requestMap = req.getParameterMap();
		
		
		for(Map.Entry<String, String[]> entry:requestMap.entrySet()){
			
			String key = entry.getKey();
			
			String[] values = entry.getValue();
			
			System.out.println("key:" + key);
			for(String value:values){
				System.out.println("value:" + value);
			}

		}
			
		PrintWriter out = resp.getWriter();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		out.print("<h3>");
		out.print(sdf.format(new Date()));
		out.print("</h3>");
		System.out.println("service()...");
	}

}
