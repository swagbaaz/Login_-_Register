package com.baaz.LogRegDAO;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.baaz.userbean.UserBean;

import jakarta.servlet.http.HttpServletRequest;

public class LoginDAO {
	public UserBean userbean=null;
	public UserBean login(HttpServletRequest request){
		try {
			Connection con=DB_ConnectDAO.getCon();
			PreparedStatement ps=con.prepareStatement("select * from registerd_user where userid=? and password=?");
			ps.setString(1, request.getParameter("userid"));
			ps.setString(2,request.getParameter("password"));
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				userbean =new UserBean();
				userbean.setFname(rs.getString(1));
				userbean.setLname(rs.getString(2));
				userbean.setUserid(rs.getString(3));
				userbean.setEmailid(rs.getString(4));
				userbean.setPassword(rs.getString(5));	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userbean;
	}
}
