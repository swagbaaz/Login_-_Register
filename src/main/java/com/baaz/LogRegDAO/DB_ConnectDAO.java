package com.baaz.LogRegDAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_ConnectDAO {
	private static Connection con;
	private DB_ConnectDAO() { }
	static {
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","spring","spring");
		}catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public static Connection getCon() {
		return con;
	}
}
