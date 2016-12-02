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
 * Sqlite���ݿ������
 * 
 * @author djzhao
 * @Date 2016��11��26�� ����7:54:11
 */
public class SqliteDao {
	QueryRunner queryRunner = SqliteUtils.getQueryRunner();
	private String sql;

	/**
	 * ��ȡexcel·����
	 * 
	 * @return
	 */
	public String getExcelPath() {
		sql = "select value from defaultSettings where key = 'excelPath'";
		try {
			return queryRunner.query(sql, new ScalarHandler<String>());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("�޷���ȡexcel·�����ݣ�");
		}
	}

	/**
	 * ����excel·����
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
			throw new RuntimeException("�޷�����excel·�����ݣ�");
		}
	}

	/**
	 * ��ȡ��ǩλ�á�
	 * 
	 * @return
	 */
	public List<Adjustment> getPosition() {
		sql = "select name, top, left from printAdjustment";
		try {
			return queryRunner.query(sql, new BeanListHandler<Adjustment>(Adjustment.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("�޷���ȡ��ǩ��λ�����ݣ�");
		}
	}
	
	/**
	 * ���±�ǩλ�á�
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
			throw new RuntimeException("�޷����±�ǩ��λ�����ݣ�");
		}
	}
	
	/**
	 * ��ȡĬ�ϴ�ӡ����
	 * 
	 * @return
	 */
	public String getDefaultPrinterName() {
		sql = "select value from defaultSettings where key = 'defaultPrinterName'";
		try {
			return queryRunner.query(sql, new ScalarHandler<String>());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("�޷���ȡĬ�ϴ�ӡ����");
		}
	}
	
	/**
	 * ����Ĭ�ϴ�ӡ����
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
			throw new RuntimeException("�޷�����Ĭ�ϴ�ӡ����");
		}
	}
}
