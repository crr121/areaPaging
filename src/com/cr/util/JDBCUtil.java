package com.cr.util;

/*import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtil {
	 static ComboPooledDataSource DataSource =	new ComboPooledDataSource();
	 public static Connection getConnection(){
		 try {
			DataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return null;
	 }
	
}*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JDBCUtil {
	
private static ResourceBundle rb = ResourceBundle.getBundle("jdbc");
	
	static{
		try {
			Class.forName(rb.getString("driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConnection(){
		Connection  con = null;
		try {
			con = DriverManager.getConnection(rb.getString("url"),rb.getString("user"), rb.getString("pwd"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
