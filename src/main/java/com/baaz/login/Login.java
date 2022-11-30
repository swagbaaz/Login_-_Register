package com.baaz.login;

import java.io.IOException;
import java.io.PrintWriter;

import com.baaz.LogRegDAO.LoginDAO;
import com.baaz.userbean.UserBean;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserBean userbean = null;
	LoginDAO logindao = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		userbean = new UserBean();
		logindao = new LoginDAO();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		userbean = null;
		// logindao=null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		if (userbean != null) {
			out.println("Welcome " + userbean.getFname());
		} else {
			out.println("Login Failed");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);

		}
	}

}
