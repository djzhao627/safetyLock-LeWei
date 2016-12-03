package com.djzhao.dao;

import org.apache.commons.dbutils.QueryRunner;

import com.djzhao.db.MySqlUtils;
import com.djzhao.model.PrintInfo;

/**
 * MySQl数据库操作。
 * 
 * @author djzhao
 * @Date 2016年12月3日 下午4:29:26
 */
public class MySQLDao {
	private QueryRunner queryRunner = MySqlUtils.getQueryRunner();
	private String sql;
	
	/**
	 * 插入excel信息到数据库。
	 * 
	 * @param e
	 * @return
	 */
	public boolean insertPrintInfo(PrintInfo e) {
		return false;
	}
}
