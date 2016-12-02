package com.djzhao.utils;

import java.io.File;

import javax.swing.filechooser.FileFilter;
/**
 * Excel过滤器。
 * 
 * @author djzhao
 * @Date 2016年11月26日 下午7:53:00
 */
public class ExcelFileFilter extends FileFilter {

	@Override
	public boolean accept(File f) {
		return f.isDirectory() || f.getName().endsWith(".xlsx") || f.getName().endsWith(".xls");
	}

	@Override
	public String getDescription() {
		return ".xlsx .xls";
	}

}
