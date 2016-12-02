package com.djzhao.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.djzhao.db.SqliteUtils;
import com.djzhao.model.Adjustment;

/**
 * Sqlite数据库操作。
 * 
 * @author djzhao
 * @Date 2016年11月26日 下午7:54:11
 */
public class SqliteDao {
	QueryRunner queryRunner = SqliteUtils.getQueryRunner();
	private String sql;

	/**
	 * 获取excel路径。
	 * 
	 * @return
	 */
	public String getExcelPath() {
		sql = "select value from defaultSettings where key = 'excelPath'";
		try {
			return queryRunner.query(sql, new ScalarHandler<String>());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("无法读取excel路径数据！");
		}
	}

	/**
	 * 设置excel路径。
	 * 
	 * @param path
	 * @return
	 */
	public boolean setExcelPath(String path) {
		sql = "update defaultSettings set value = ? where key = 'excelPath'";
		try {
			return queryRunner.update(sql, path) > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("无法更新excel路径数据！");
		}
	}

	/**
	 * 获取标签位置。
	 * 
	 * @return
	 */
	public List<Adjustment> getPosition() {
		sql = "select name, top, left from printAdjustment";
		try {
			return queryRunner.query(sql, new BeanListHandler<Adjustment>(Adjustment.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("无法获取标签的位置数据！");
		}
	}
	
	/**
	 * 更新标签位置。
	 * 
	 * @param a
	 * @return
	 */
	public boolean setPosition(Adjustment a) {
		sql = "update printAdjustment set top = ?, left = ? where name = ?";
		try {
			return queryRunner.update(sql, a.getTop(), a.getLeft(), a.getName()) > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("无法更新标签的位置数据！");
		}
	}
	
	/**
	 * 获取默认打印机。
	 * 
	 * @return
	 */
	public String getDefaultPrinterName() {
		sql = "select value from defaultSettings where key = 'defaultPrinterName'";
		try {
			return queryRunner.query(sql, new ScalarHandler<String>());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("无法读取默认打印机！");
		}
	}
	
	/**
	 * 设置默认打印机。
	 * 
	 * @param name
	 * @return
	 */
	public boolean setDefaultPrinterName(String name) {
		sql = "update defaultSettings set value = ? where key = 'defaultPrinterName'";
		try {
			return queryRunner.update(sql, name) > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("无法更新默认打印机！");
		}
	}
}
