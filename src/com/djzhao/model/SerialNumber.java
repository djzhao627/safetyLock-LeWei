package com.djzhao.model;

/**
 * Ψһ���к�ģ�͡�
 * 
 * @author djzhao
 * @Date 2016��12��4�� ����10:55:31
 */
public class SerialNumber {
	/** ��ӡ���� */
	private String printDate;

	/** �߱�ID */
	private int lineNameId;

	/** Ψһ���к� */
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
