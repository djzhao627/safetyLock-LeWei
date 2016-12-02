package com.djzhao.utils;

import com.djzhao.dao.SqliteDao;

/**
 * �����ࡣ
 * 
 * @author djzhao
 * @Date 2016��11��26�� ����10:08:26
 */
public class Constants {
	public static String EXCELPATH;
	/**
	 * ������ʵ������
	 */
	private Constants(){};
	
	static {
		SqliteDao sd = new SqliteDao();
		EXCELPATH = sd.getExcelPath();
		System.out.println(Constants.EXCELPATH);
	}
}
