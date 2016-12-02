package com.djzhao.utils;

import java.io.File;

import javax.swing.filechooser.FileFilter;
/**
 * Excel��������
 * 
 * @author djzhao
 * @Date 2016��11��26�� ����7:53:00
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
