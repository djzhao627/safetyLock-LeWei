package com.djzhao.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ���ݿ⹤����<br>
 * 1.��ʼ��C3P0���ӳ�<br>
 * 2.����DbUtils���Ĺ��������
 * 
 * @author djzhao
 * @time 2016��8��3��
 */
public class SqliteUtils {

	private static DataSource dataSource;

	/**
	 * ��ʼ��C3P0���ӳ�
	 */
	static {
		dataSource = new ComboPooledDataSource("sqlite_config");// ��������ʹ��Ĭ������
	}
	
	/**
	 * ����DbUtils���Ĺ��������
	 * @return
	 */
	public static QueryRunner getQueryRunner() {
		return new QueryRunner(dataSource);
	}
	
	/**
	 * ��ȡһ�����ӡ�
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
