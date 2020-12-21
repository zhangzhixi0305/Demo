package com.zhixi.servlet;

import com.zhixi.domain.User;
import com.zhixi.service.UserService;
import com.zhixi.service.UserServiceImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertUserServlet extends HttpServlet {

	private UserService userService = new UserServiceImpl();
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("username");
		String userPass = request.getParameter("userpass");
		User entity = new User(userName,userPass, null);
		boolean flag = userService.insert(entity);
		if(flag){
			 request.setAttribute("flag", true);
			 request.getRequestDispatcher("insert.jsp").forward(request, response);
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
