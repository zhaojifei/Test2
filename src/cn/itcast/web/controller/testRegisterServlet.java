package cn.itcast.web.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class testRegisterServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Enumeration e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String name = (String)e.nextElement();
			String value = request.getParameter(name);
			System.out.println(value);
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Enumeration e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String name = (String)e.nextElement();
			String value = request.getParameter(name);
			System.out.println(value);
		}
	}

}
