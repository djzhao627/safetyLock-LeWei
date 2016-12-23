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
 * Excel操作类。
 * 
 * @author djzhao
 * @Date 2016年12月2日 上午9:08:08
 */
public class OperaterExcel {
	/** 构建Workbook对象, 只读Workbook对象 */
	private Workbook readBook = null;

	public List<PrintInfo> readAA_APInfos(String path) {
		List<PrintInfo> list = null;
		try {
			InputStream inputStream = new FileInputStream(path);
			// 直接从本地文件创建Workbook
			readBook = Workbook.getWorkbook(inputStream);
			// 获取第一张Sheet表
			Sheet readSheet = readBook.getSheet(0);
			// 获取Sheet表中所包含的总列数
			// int rsColumns = readSheet.getColumns();
			// 获取Sheet表中所包含的总行数
			int rsRows = readSheet.getRows();
			if (rsRows > 1) {
				list = new ArrayList<PrintInfo>();
			} else {
				throw new RuntimeException("Excel 中无记录！");
			}
			for (int i = 1; i < rsRows; i++) {

				// 获取单元格
				Cell cell = null;

				PrintInfo printInfo = new PrintInfo();
				// 线别
				printInfo.setWorkStation("AA.AP");

				// 班次
				cell = readSheet.getCell(1, i);
				printInfo.setClasses(Constants.CLASSES.get(cell.getContents().trim()));

				// 生产日期
				cell = readSheet.getCell(0, i);
				// 2016/11/21
				String dateString = cell.getContents().trim();
				String[] split = dateString.split("[-/ ]");
				printInfo.setProductDate(split[0] + split[1] + split[2]);

				// 销售订单号
				cell = readSheet.getCell(11, i);
				printInfo.setSalesNo(cell.getContents().trim());

				// 销售订单行
				cell = readSheet.getCell(12, i);
				printInfo.setSalesRow(cell.getContents().trim());
				
				// 打印数量
				cell = readSheet.getCell(14, i);
				printInfo.setNumber(Integer.parseInt(cell.getContents().trim()));
				
				// 加入集合
				list.add(printInfo);

			}
			return list;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("无法读取excel文件！");
		} catch (BiffException e) {
			e.printStackTrace();
			throw new RuntimeException("excel文件格式无法读取！");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("无法读取excel文件！");
		}
	}
}
