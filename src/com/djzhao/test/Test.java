package com.djzhao.test;

import java.io.File;
import java.util.List;

import com.djzhao.model.PrintInfo;
import com.djzhao.utils.ExcelUtil;
import com.djzhao.utils.OperaterExcel;

public class Test {
	@org.junit.Test
	public void TestReadexcel() {
		OperaterExcel o = new OperaterExcel();
		try {
			List<PrintInfo> list = ExcelUtil.readExcel(new File("E:\\WindowsDesktop\\LeWei\\外包\\安全锁\\班次计划.xls"));
//			System.out.println(list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
