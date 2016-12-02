package com.djzhao.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 数据库工具类<br>
 * 1.初始化C3P0连接池<br>
 * 2.创建DbUtils核心工具类对象
 * 
 * @author djzhao
 * @time 2016年8月3日
 */
public class SqliteUtils {

	private static DataSource dataSource;

	/**
	 * 初始化C3P0连接池
	 */
	static {
		dataSource = new ComboPooledDataSource("sqlite_config");// 不传参则使用默认配置
	}
	
	/**
	 * 创建DbUtils核心工具类对象
	 * @return
	 */
	public static QueryRunner getQueryRunner() {
		return new QueryRunner(dataSource);
	}
	
	/**
	 * 获取一个连接。
	 * @return
	 */
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection =  dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
