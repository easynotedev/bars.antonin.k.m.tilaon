package com.accenture.tcf.bars.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.apache.log4j.Logger;

public class MySQLDatasource {

	private static Connection conn;
	public static final SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	static Logger logger = Logger.getLogger(MySQLDatasource.class);

	public static Connection getConnection() {
		if(conn==null) {
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bars_db?useSSL=false&serverTimezone=UTC", "root", "root");
			} catch (SQLException e) {
				logger.error(e.getMessage());
			}
		}
		else
			return conn;
		return conn;
	}

	public static SessionFactory getSessionFactory() {
        return factory;
    }
}