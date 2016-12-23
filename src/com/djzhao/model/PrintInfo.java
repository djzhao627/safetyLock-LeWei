package com.djzhao.model;

/**
 * ��Ҫ��ӡ��Excel�ж�ȡ�������ݡ�
 * 
 * @author djzhao
 * @Date 2016��12��3�� ����3:57:46
 */
public class PrintInfo {
	/** �߱�����(��λ) */
	private String workStation;

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

	/** ��������S **/
	private String materialDescS;

	/** ��������T **/
	private String materialDescT;

	/** ���Ϻ�S **/
	private String materialNumberS;

	/** ���Ϻ�T **/
	private String materialNumberT;

	/** �ͻ� **/
	private String customer;

	/**
	 * @return the workStation
	 */
	public String getWorkStation() {
		return workStation;
	}

	/**
	 * @param workStation
	 *            the workStation to set
	 */
	public void setWorkStation(String workStation) {
		this.workStation = workStation;
	}

	/**
	 * @return the materialDescS
	 */
	public String getMaterialDescS() {
		return materialDescS;
	}

	/**
	 * @param materialDescS
	 *            the materialDescS to set
	 */
	public void setMaterialDescS(String materialDescS) {
		this.materialDescS = materialDescS;
	}

	/**
	 * @return the materialDescT
	 */
	public String getMaterialDescT() {
		return materialDescT;
	}

	/**
	 * @param materialDescT
	 *            the materialDescT to set
	 */
	public void setMaterialDescT(String materialDescT) {
		this.materialDescT = materialDescT;
	}

	/**
	 * @return the materialNumberS
	 */
	public String getMaterialNumberS() {
		return materialNumberS;
	}

	/**
	 * @param materialNumberS
	 *            the materialNumberS to set
	 */
	public void setMaterialNumberS(String materialNumberS) {
		this.materialNumberS = materialNumberS;
	}

	/**
	 * @return the materialNumberT
	 */
	public String getMaterialNumberT() {
		return materialNumberT;
	}

	/**
	 * @param materialNumberT
	 *            the materialNumberT to set
	 */
	public void setMaterialNumberT(String materialNumberT) {
		this.materialNumberT = materialNumberT;
	}

	/**
	 * @return the customer
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
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
		return "PrintInfo [workStation=" + workStation + ", classes=" + classes + ", productDate=" + productDate
				+ ", salesNo=" + salesNo + ", salesRow=" + salesRow + ", serialNumber=" + serialNumber + ", number="
				+ number + ", materialDescS=" + materialDescS + ", materialDescT=" + materialDescT
				+ ", materialNumberS=" + materialNumberS + ", materialNumberT=" + materialNumberT + ", customer="
				+ customer + "]";
	}

}
