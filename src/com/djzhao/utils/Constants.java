package com.djzhao.utils;

import java.util.HashMap;

import com.djzhao.dao.SqliteDao;

/**
 * 常量类。
 * 
 * @author djzhao
 * @Date 2016年11月26日 上午10:08:26
 */
public class Constants {
	/** Excel 文件路径 */
	public static String EXCELPATH;
	
	public static HashMap<String, String> CLASSES = new HashMap<>();
	
	/**
	 * 不允许实例化。
	 */
	private Constants(){};
	
	static {
		// 获取默认路径
		SqliteDao sd = new SqliteDao();
		EXCELPATH = sd.getExcelPath();
		// System.out.println(Constants.EXCELPATH);
		// 设置班次信息
		CLASSES.put("早", "A");
		CLASSES.put("中", "B");
		CLASSES.put("午", "B");
		CLASSES.put("晚", "C");
		CLASSES.put("夜", "C");
	}
}
