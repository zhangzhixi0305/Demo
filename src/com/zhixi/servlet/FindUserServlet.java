package com.zhixi.servlet;

import com.zhixi.domain.User;
import com.zhixi.service.UserService;
import com.zhixi.service.UserServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindUserServlet extends HttpServlet {
	private UserService userService = new UserServiceImpl();
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String userName = request.getParameter("username");
		response.setContentType("text/html;charset=UTF-8");
		User user=userService.findByName(userName);
		int id=user.getId();
		String name=user.getName();
		String pass=user.getPass();
		Date logintime=user.getLoginTime();
		PrintWriter out= response.getWriter();
		out.write("ID:"+id+"<br/>姓名:"+name+"<br/>密码:"+pass+"<br/>注册时间:"+logintime);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
