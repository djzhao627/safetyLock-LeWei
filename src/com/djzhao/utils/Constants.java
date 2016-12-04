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
	
	/** 班次hash表 */
	public static HashMap<String, String> CLASSES = new HashMap<>();
	
	/** 线别名称数组 */
	public static String LINENAME[] = {"AA.AP线", "AMD线", "35100", "35200", "35300", "AMDDOP门机"};
	
	/** 唯一流水线号 */
	public static int SERIALNUMBER = 0;
	
	/** 已经选择的线别索引 */
	public static int SELECTEDLINEINDEX = 0;
	
	/** 日期上边距 */
	public static double LABELDATETOP = 0;
	
	/** 日期左边距 */
	public static double LABELDATELEFT = 0;
	
	/** 编号上边距 */
	public static double LABELSERTOP = 0;
	
	/** 编号左边距 */
	public static double LABELSERLEFT = 0;
	
	/** 标签字体大小 */
	public static int LABELFONTSIZE = 6;
	
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
