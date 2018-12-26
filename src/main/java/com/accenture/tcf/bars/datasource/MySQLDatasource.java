package com.accenture.tcf.bars.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDatasource {

	 static String url = "jdbc:mysql://localhost/bars_db?useTimezone=true&serverTimezone=UTC";
	 static String username = "root";
	 static String password = "root";

	public MySQLDatasource(){

	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url,username,password);
	}

}
