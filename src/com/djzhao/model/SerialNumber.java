package com.djzhao.model;

/**
 * 唯一序列号模型。
 * 
 * @author djzhao
 * @Date 2016年12月4日 上午10:55:31
 */
public class SerialNumber {
	/** 打印日期 */
	private String printDate;

	/** 线别ID */
	private int lineNameId;

	/** 唯一序列号 */
	private int serialNumber;

	/**
	 * @return the printDate
	 */
	public String getPrintDate() {
		return printDate;
	}

	/**
	 * @param printDate
	 *            the printDate to set
	 */
	public void setPrintDate(String printDate) {
		this.printDate = printDate;
	}

	/**
	 * @return the lineNameId
	 */
	public int getLineNameId() {
		return lineNameId;
	}

	/**
	 * @param lineNameId
	 *            the lineNameId to set
	 */
	public void setLineNameId(int lineNameId) {
		this.lineNameId = lineNameId;
	}

	/**
	 * @return the serialNumber
	 */
	public int getSerialNumber() {
		return serialNumber;
	}

	/**
	 * @param serialNumber
	 *            the serialNumber to set
	 */
	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SerialNumber [printDate=" + printDate + ", lineNameId=" + lineNameId + ", serialNumber=" + serialNumber
				+ "]";
	}

}
