package com.ittx.spring002.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ittx.spring002.dao.UserDao;
import com.ittx.spring002.dao.impl.UserDaoImpl;
import com.ittx.spring002.model.User;
import com.ittx.spring002.utils.PageUtil;

@WebServlet({ "/PagerServlet", "/pagerservlet.servlet" })
public class PagerServlet extends HttpServlet {
	private UserDao userDao = new UserDaoImpl();
	private int currentPage = 1;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pageNum = request.getParameter("pageNum");
		if(pageNum != null && !"".equals(pageNum)){
			currentPage = Integer.parseInt(pageNum);
		}
		
		PageUtil pageUtil = new PageUtil(10, 26, currentPage);
		
		List<User> lists = userDao.getPageUtilsUserLists(pageUtil.getFromIndex(), pageUtil.getPageSize());
		
		request.setAttribute("userLists", lists);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPage", pageUtil.getPageCount());
		
		request.getRequestDispatcher("list_user_pager.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	
	
}
