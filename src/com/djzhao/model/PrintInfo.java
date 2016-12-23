package com.djzhao.model;

/**
 * 需要打印的Excel中读取出的数据。
 * 
 * @author djzhao
 * @Date 2016年12月3日 下午3:57:46
 */
public class PrintInfo {
	/** 线别名称(工位) */
	private String workStation;

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

	/** 物料描述S **/
	private String materialDescS;

	/** 物料描述T **/
	private String materialDescT;

	/** 物料号S **/
	private String materialNumberS;

	/** 物料号T **/
	private String materialNumberT;

	/** 客户 **/
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
