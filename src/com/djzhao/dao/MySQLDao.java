package com.djzhao.dao;

import org.apache.commons.dbutils.QueryRunner;

import com.djzhao.db.MySqlUtils;
import com.djzhao.model.PrintInfo;

/**
 * MySQl���ݿ������
 * 
 * @author djzhao
 * @Date 2016��12��3�� ����4:29:26
 */
public class MySQLDao {
	private QueryRunner queryRunner = MySqlUtils.getQueryRunner();
	private String sql;
	
	/**
	 * ����excel��Ϣ�����ݿ⡣
	 * 
	 * @param e
	 * @return
	 */
	public boolean insertPrintInfo(PrintInfo e) {
		return false;
	}
}
