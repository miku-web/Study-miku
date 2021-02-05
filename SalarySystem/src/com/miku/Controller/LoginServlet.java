package com.miku.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.miku.imple.LoginDaoImple;


public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int flag = 0;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println(username);
		System.out.println(password);
		
		LoginDaoImple login = new LoginDaoImple();
		try {
			flag = login.Login(username, password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(flag ==1) {
			request.getSession().setAttribute("username", username);
			request.getRequestDispatcher("/index.html").forward(request, response);
		}
		else {
			
			request.getRequestDispatcher("/Login.html").forward(request, response);
		}

	}

}
