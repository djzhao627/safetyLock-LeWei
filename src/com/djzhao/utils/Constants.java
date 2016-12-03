package com.djzhao.utils;

import java.util.HashMap;

import com.djzhao.dao.SqliteDao;

/**
 * �����ࡣ
 * 
 * @author djzhao
 * @Date 2016��11��26�� ����10:08:26
 */
public class Constants {
	/** Excel �ļ�·�� */
	public static String EXCELPATH;
	
	public static HashMap<String, String> CLASSES = new HashMap<>();
	
	/**
	 * ������ʵ������
	 */
	private Constants(){};
	
	static {
		// ��ȡĬ��·��
		SqliteDao sd = new SqliteDao();
		EXCELPATH = sd.getExcelPath();
		// System.out.println(Constants.EXCELPATH);
		// ���ð����Ϣ
		CLASSES.put("��", "A");
		CLASSES.put("��", "B");
		CLASSES.put("��", "B");
		CLASSES.put("��", "C");
		CLASSES.put("ҹ", "C");
	}
}
