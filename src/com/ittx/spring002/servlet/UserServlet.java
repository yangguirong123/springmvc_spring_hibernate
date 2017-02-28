package com.ittx.spring002.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ittx.spring002.model.User;
import com.ittx.spring002.server.UserServer;
import com.ittx.spring002.server.impl.UserServerImpl;

@WebServlet({ "/UserServlet", "/userservlet.do" })
public class UserServlet extends HttpServlet {
	private UserServer userServer;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String number = request.getParameter("number");
		
		User user = new User(userName,Integer.parseInt(number));
		
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		userServer = (UserServer) ctx.getBean("userServer");
		
		userServer.addUser(user);
		
		request.getRequestDispatcher("success.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
