package com.baaz.registration;

import java.io.IOException;
import java.io.PrintWriter;

import com.baaz.LogRegDAO.RegDAO;
import com.baaz.userbean.UserBean;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserBean userbean = null;
	RegDAO regdao = null;

	public RegisterServlet() {
	}

	public void init(ServletConfig config) throws ServletException {
		userbean = new UserBean();
		regdao = new RegDAO();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		userbean = null;
		regdao = null;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		userbean.setFname(request.getParameter("fname"));
		userbean.setLname(request.getParameter("lname"));
		userbean.setUserid(request.getParameter("userid"));
		userbean.setEmailid(request.getParameter("emailid"));
		userbean.setPassword(request.getParameter("password"));
		int query = regdao.insert(userbean);
		if (query > 0) {
			out.println("User Registed Successfully...");
		} else {
			out.print("user not registed");
		}

	}

}
