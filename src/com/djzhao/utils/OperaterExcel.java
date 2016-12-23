package com.djzhao.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.djzhao.model.PrintInfo;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * Excel�����ࡣ
 * 
 * @author djzhao
 * @Date 2016��12��2�� ����9:08:08
 */
public class OperaterExcel {
	/** ����Workbook����, ֻ��Workbook���� */
	private Workbook readBook = null;

	public List<PrintInfo> readAA_APInfos(String path) {
		List<PrintInfo> list = null;
		try {
			InputStream inputStream = new FileInputStream(path);
			// ֱ�Ӵӱ����ļ�����Workbook
			readBook = Workbook.getWorkbook(inputStream);
			// ��ȡ��һ��Sheet��
			Sheet readSheet = readBook.getSheet(0);
			// ��ȡSheet������������������
			// int rsColumns = readSheet.getColumns();
			// ��ȡSheet������������������
			int rsRows = readSheet.getRows();
			if (rsRows > 1) {
				list = new ArrayList<PrintInfo>();
			} else {
				throw new RuntimeException("Excel ���޼�¼��");
			}
			for (int i = 1; i < rsRows; i++) {

				// ��ȡ��Ԫ��
				Cell cell = null;

				PrintInfo printInfo = new PrintInfo();
				// �߱�
				printInfo.setWorkStation("AA.AP");

				// ���
				cell = readSheet.getCell(1, i);
				printInfo.setClasses(Constants.CLASSES.get(cell.getContents().trim()));

				// ��������
				cell = readSheet.getCell(0, i);
				// 2016/11/21
				String dateString = cell.getContents().trim();
				String[] split = dateString.split("[-/ ]");
				printInfo.setProductDate(split[0] + split[1] + split[2]);

				// ���۶�����
				cell = readSheet.getCell(11, i);
				printInfo.setSalesNo(cell.getContents().trim());

				// ���۶�����
				cell = readSheet.getCell(12, i);
				printInfo.setSalesRow(cell.getContents().trim());
				
				// ��ӡ����
				cell = readSheet.getCell(14, i);
				printInfo.setNumber(Integer.parseInt(cell.getContents().trim()));
				
				// ���뼯��
				list.add(printInfo);

			}
			return list;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("�޷���ȡexcel�ļ���");
		} catch (BiffException e) {
			e.printStackTrace();
			throw new RuntimeException("excel�ļ���ʽ�޷���ȡ��");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("�޷���ȡexcel�ļ���");
		}
	}
}
