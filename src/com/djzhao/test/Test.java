package com.djzhao.test;

import java.io.File;
import java.util.List;

import com.djzhao.model.PrintInfo;
import com.djzhao.utils.ExcelUtil;
import com.djzhao.view.AdjustLabelPositionView;

public class Test {
	@org.junit.Test
	public void TestReadexcel() {
		try {
			List<PrintInfo> list = ExcelUtil.readExcel(new File("E:\\WindowsDesktop\\LeWei\\外包\\安全锁\\副本副本班次计划.xlsx"));
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@org.junit.Test
	public void TestAdjustView() {
		AdjustLabelPositionView apv = AdjustLabelPositionView.GetAdjustLabelPositionView();
		apv.setVisible(true);
	}
}
