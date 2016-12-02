package com.djzhao.utils;

import com.djzhao.dao.SqliteDao;

/**
 * 常量类。
 * 
 * @author djzhao
 * @Date 2016年11月26日 上午10:08:26
 */
public class Constants {
	public static String EXCELPATH;
	/**
	 * 不允许实例化。
	 */
	private Constants(){};
	
	static {
		SqliteDao sd = new SqliteDao();
		EXCELPATH = sd.getExcelPath();
		System.out.println(Constants.EXCELPATH);
	}
}
