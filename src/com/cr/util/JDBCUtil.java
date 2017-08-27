package com.cr.util;

import java.sql.Connection;
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
	
}
