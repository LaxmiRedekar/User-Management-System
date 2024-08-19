package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.model.Admin;
import com.model.User;

@WebServlet("/")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		
		switch (path) {
		 case "/add": newUser(request,response);
		 break;
		 
		 case "/insert": insertData(request,response);
		 break;
		 
		 case "/delete": deleteData(request,response);
		 break;
		 
		 case "/edit": editData(request,response);
		 break;
		 
		 case "/update": updateData(request,response);
		 break;
		 
		 case "/list":list(request,response) ;
		 break;
		 
		 case "/validate": validate(request,response);
		 break;
		 
		 default: login(request,response);
		 break;
		}
	}

	
	private void validate(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		Admin a = new Admin(email, pwd);
		UserDao ud = new UserDao();
		
		String status = ud.checkLogin(a);
		
		if(status.equals("success")) {
			try {
				response.sendRedirect("list");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		}
	}


	private void login(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
		
	}


	private void updateData(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		
		User user = new User(id, name, email, city);
		
		UserDao.update(user); 
		try {
			response.sendRedirect("list");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	private void editData(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		User user = UserDao.edit(id);
		request.setAttribute("list", user);
		
		RequestDispatcher rd = request.getRequestDispatcher("UserForm.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) { 
			e.printStackTrace();
		}
		
	}


	private void deleteData(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		UserDao.delete(id);
		try {
			response.sendRedirect("list");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private void insertData(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		
		User user = new User(name, email, city);
		
		UserDao.insert(user);
		try {
			response.sendRedirect("list");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void newUser(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher rd = request.getRequestDispatcher("UserForm.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) { 
			e.printStackTrace();
		}
		
	}


	private void list(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<User> al = UserDao.display();
		
		//share the data to the UserList
		request.setAttribute("display", al);
		RequestDispatcher rd = request.getRequestDispatcher("UserList.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) { 
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
