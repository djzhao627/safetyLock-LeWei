package com.djzhao.model;

/**
 * ��ǩ����ģ�͡�
 * 
 * @author djzhao
 * @Date 2016��11��26�� ����7:57:06
 */
public class Adjustment {
	/** �ֶ��� */
	private String name;
	
	/** �ϱ߾� */
	private double top;
	
	/** ��߾� */
	private double left;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the top
	 */
	public double getTop() {
		return top;
	}

	/**
	 * @param top the top to set
	 */
	public void setTop(double top) {
		this.top = top;
	}

	/**
	 * @return the left
	 */
	public double getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(double left) {
		this.left = left;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Adjustment [name=" + name + ", top=" + top + ", left=" + left + "]";
	}
	
	
}
