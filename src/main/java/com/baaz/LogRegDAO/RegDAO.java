package com.baaz.LogRegDAO;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.baaz.userbean.UserBean;

public class RegDAO implements Serializable {
	public int query;
	public int insert(UserBean userbean) {
		try {

			Connection con = DB_ConnectDAO.getCon();
			PreparedStatement ps=con.prepareStatement("insert into  REGISTERD_USERS values(?,?,?,?,?)");
			ps.setString(1, userbean.getFname());
			ps.setString(2, userbean.getLname());
			ps.setString(3, userbean.getUserid());
			ps.setString(4, userbean.getEmailid());
			ps.setString(5, userbean.getPassword());
			query=ps.executeUpdate();				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return query;
		
	}
}
