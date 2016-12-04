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
	
	/** ���hash�� */
	public static HashMap<String, String> CLASSES = new HashMap<>();
	
	/** �߱��������� */
	public static String LINENAME[] = {"AA.AP��", "AMD��", "35100", "35200", "35300", "AMDDOP�Ż�"};
	
	/** Ψһ��ˮ�ߺ� */
	public static int SERIALNUMBER = 0;
	
	/** �Ѿ�ѡ����߱����� */
	public static int SELECTEDLINEINDEX = 0;
	
	/** �����ϱ߾� */
	public static double LABELDATETOP = 0;
	
	/** ������߾� */
	public static double LABELDATELEFT = 0;
	
	/** ����ϱ߾� */
	public static double LABELSERTOP = 0;
	
	/** �����߾� */
	public static double LABELSERLEFT = 0;
	
	/** ��ǩ�����С */
	public static int LABELFONTSIZE = 6;
	
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
