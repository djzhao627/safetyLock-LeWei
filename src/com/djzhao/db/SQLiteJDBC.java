package com.djzhao.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * SQLite。
 * 
 * @author djzhao
 * @Date 2016年11月26日 下午5:53:43
 */
public class SQLiteJDBC {

	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:C:\\config\\safetyLock\\safetyLock.db");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return connection;
	}
}