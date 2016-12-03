package com.djzhao.model;

/**
 * ��Ҫ��ӡ��Excel�ж�ȡ�������ݡ�
 * 
 * @author djzhao
 * @Date 2016��12��3�� ����3:57:46
 */
public class PrintInfo {
	/** �߱����� */
	private String lineName;

	/** ��� A��࣬B�а࣬C��� */
	private String classes;

	/** �������ʱ�� */
	private String productDate;

	/** ���۶����� */
	private String salesNo;

	/** ���۶����� */
	private String salesRow;

	/** ���к� */
	private String serialNumber;

	/** ��Ҫ��ӡ������ */
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
