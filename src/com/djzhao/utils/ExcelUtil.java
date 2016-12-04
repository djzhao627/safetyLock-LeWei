package com.djzhao.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.djzhao.model.PrintInfo;

/*
 * 
 * 所需jar包
 * 下载地址http://www.apache.org/dyn/closer.cgi/poi/release/bin/poi-bin-3.9-20121203
 * .zip <br />
 * poi-3.7-20101029.jar poi-ooxml-3.7-20101029.jar<br />
 * poi-ooxml-schemas-3.7-20101029.jar xmlbeans-2.3.0.jar dom4j-1.6.1.jar
 * 
 * 
 */

/**
 * Excel操作类。
 * 
 * @author djzhao
 * @Date 2016年12月3日 上午10:37:24
 */
public class ExcelUtil {

	/** 六位年月日 */
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");

	/** excel数据列 */
	private static List<int[]> dataColum = new ArrayList<int[]>();

	static {
		// AA.AP
		dataColum.add(new int[] { 0, 1, 11, 12, 14 });
		// AMD
		dataColum.add(new int[] { 0, 1, 10, 11, 13 });
		// 35100
		dataColum.add(new int[] { 0, 1, 9, 10, 19 });
		// 35200
		dataColum.add(new int[] { 0, 1, 9, 10, 19 });
		// 35300
		dataColum.add(new int[] { 0, 1, 8, 9, 12 });
		// AMDDOP门机
		dataColum.add(new int[] { 1, 4, 0, 8, 13 });
	}

	/** 禁止实例化 */
	private ExcelUtil() {
	};

	public static void main(String[] args) {
		File file = new File("E:\\WindowsDesktop\\LeWei\\外包\\安全锁\\班次计划.xlsx");
		try {
			List<PrintInfo> list = readExcel(file);
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 对外提供读取excel 的方法
	 */
	public static List<PrintInfo> readExcel(File file) throws IOException {
		String fileName = file.getName();

		String extension = fileName.lastIndexOf(".") == -1 ? "" : fileName.substring(fileName.lastIndexOf(".") + 1);
		if ("xls".equals(extension)) {
			return read2003Excel(file);
		} else if ("xlsx".equals(extension)) {
			return read2007Excel(file);
		} else {
			throw new IOException("不支持的文件类型");
		}
	}

	/**
	 * 读取 office 2003 excel
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@SuppressWarnings("deprecation")
	private static List<PrintInfo> read2003Excel(File file) throws IOException {
		List<PrintInfo> list = new ArrayList<PrintInfo>();
		HSSFWorkbook hwb = new HSSFWorkbook(new FileInputStream(file));
		HSSFSheet sheet = hwb.getSheetAt(0);
		HSSFRow row = null;
		HSSFCell cell = null;
		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			row = sheet.getRow(i);
			if (row == null) {
				continue;
			}

			// String sheetName = sheet.getSheetName();

			PrintInfo printInfo = new PrintInfo();
			// 线别
			printInfo.setLineName(Constants.LINENAME[Constants.SELECTEDLINEINDEX]);

			String str = "";
			// 生产日期
			cell = row.getCell(dataColum.get(Constants.SELECTEDLINEINDEX)[0]);
			if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
				str = cell.getStringCellValue().substring(2);
			} else {
				str = sdf.format(cell.getDateCellValue());
			}
			printInfo.setProductDate(str);

			// 班次
			cell = row.getCell(dataColum.get(Constants.SELECTEDLINEINDEX)[1]);
			cell.setCellType(CellType.STRING);
			str = cell.getStringCellValue().trim();
			printInfo.setClasses(Constants.CLASSES.get(str));

			// 销售订单号
			cell = row.getCell(dataColum.get(Constants.SELECTEDLINEINDEX)[2]);
			cell.setCellType(CellType.STRING);
			str = cell.getStringCellValue().trim();
			printInfo.setSalesNo(str);

			// 销售订单行
			cell = row.getCell(dataColum.get(Constants.SELECTEDLINEINDEX)[3]);
			cell.setCellType(CellType.STRING);
			str = cell.getStringCellValue().trim();
			printInfo.setSalesRow(str);

			// 打印数量
			cell = row.getCell(dataColum.get(Constants.SELECTEDLINEINDEX)[4]);
			cell.setCellType(CellType.STRING);
			str = cell.getStringCellValue().trim();
			printInfo.setNumber(Integer.parseInt(str));

			// 加入集合
			list.add(printInfo);
		}
		hwb.close();
		return list;
	}

	/**
	 * 读取Office 2007 excel
	 */
	@SuppressWarnings("deprecation")
	private static List<PrintInfo> read2007Excel(File file) throws IOException {
		List<PrintInfo> list = new ArrayList<PrintInfo>();
		// 构造 XSSFWorkbook 对象，strPath 传入文件路径
		XSSFWorkbook xwb = new XSSFWorkbook(new FileInputStream(file));
		// 读取第一章表格内容
		XSSFSheet sheet = xwb.getSheetAt(0);
		XSSFRow row = null;
		XSSFCell cell = null;
		for (int i = 1; i <= sheet.getPhysicalNumberOfRows(); i++) {
			row = sheet.getRow(i);
			if (row == null) {
				continue;
			}
			PrintInfo printInfo = new PrintInfo();
			// 线别
			printInfo.setLineName(Constants.LINENAME[Constants.SELECTEDLINEINDEX]);

			String str = "";
			// 生产日期
			cell = row.getCell(dataColum.get(Constants.SELECTEDLINEINDEX)[0]);
			if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
				str = cell.getStringCellValue().substring(2);
			} else {
				str = sdf.format(cell.getDateCellValue());
			}
			printInfo.setProductDate(str);

			// 班次
			cell = row.getCell(dataColum.get(Constants.SELECTEDLINEINDEX)[1]);
			cell.setCellType(CellType.STRING);
			str = cell.getStringCellValue().trim();
			printInfo.setClasses(Constants.CLASSES.get(str));

			// 销售订单号
			cell = row.getCell(dataColum.get(Constants.SELECTEDLINEINDEX)[2]);
			cell.setCellType(CellType.STRING);
			str = cell.getStringCellValue().trim();
			printInfo.setSalesNo(str);

			// 销售订单行
			cell = row.getCell(dataColum.get(Constants.SELECTEDLINEINDEX)[3]);
			cell.setCellType(CellType.STRING);
			str = cell.getStringCellValue().trim();
			printInfo.setSalesRow(str);

			// 打印数量
			cell = row.getCell(dataColum.get(Constants.SELECTEDLINEINDEX)[4]);
			cell.setCellType(CellType.STRING);
			str = cell.getStringCellValue().trim();
			printInfo.setNumber(Integer.parseInt(str));

			// 加入集合
			list.add(printInfo);
		}
		xwb.close();
		return list;
	}
}