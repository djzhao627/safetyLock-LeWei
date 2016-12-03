package com.djzhao.model;

/**
 * 需要打印的Excel中读取出的数据。
 * 
 * @author djzhao
 * @Date 2016年12月3日 下午3:57:46
 */
public class PrintInfo {
	/** 线别名称 */
	private String lineName;

	/** 班次 A早班，B中班，C晚班 */
	private String classes;

	/** 生成完成时间 */
	private String productDate;

	/** 销售订单号 */
	private String salesNo;

	/** 销售订单行 */
	private String salesRow;

	/** 序列号 */
	private String serialNumber;

	/** 需要打印的数量 */
	private int number;

	/**
	 * @return the lineName
	 */
	public String getLineName() {
		return lineName;
	}

	/**
	 * @param lineName
	 *            the lineName to set
	 */
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	/**
	 * @return the classes
	 */
	public String getClasses() {
		return classes;
	}

	/**
	 * @param classes
	 *            the classes to set
	 */
	public void setClasses(String classes) {
		this.classes = classes;
	}

	/**
	 * @return the productDate
	 */
	public String getProductDate() {
		return productDate;
	}

	/**
	 * @param productDate
	 *            the productDate to set
	 */
	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}

	/**
	 * @return the salesNo
	 */
	public String getSalesNo() {
		return salesNo;
	}

	/**
	 * @param salesNo
	 *            the salesNo to set
	 */
	public void setSalesNo(String salesNo) {
		this.salesNo = salesNo;
	}

	/**
	 * @return the salesRow
	 */
	public String getSalesRow() {
		return salesRow;
	}

	/**
	 * @param salesRow
	 *            the salesRow to set
	 */
	public void setSalesRow(String salesRow) {
		this.salesRow = salesRow;
	}

	/**
	 * @return the serialNumber
	 */
	public String getSerialNumber() {
		return serialNumber;
	}

	/**
	 * @param serialNumber
	 *            the serialNumber to set
	 */
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PrintInfo [lineName=" + lineName + ", classes=" + classes + ", productDate=" + productDate
				+ ", salesNo=" + salesNo + ", salesRow=" + salesRow + ", serialNumber=" + serialNumber + ", number="
				+ number + "]";
	}

}
