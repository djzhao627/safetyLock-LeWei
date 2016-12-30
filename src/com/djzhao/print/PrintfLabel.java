package com.djzhao.print;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashAttributeSet;
import javax.print.attribute.standard.PrinterName;

import com.djzhao.utils.Constants;

public class PrintfLabel implements Printable {

	/** ��ӡ������ */
	private String printerName = "Foxit Reader Plus Printer";

	/** �������� */
	private String productDate = "161201";

	/** ��Ʒ��� */
	private String serialNumber = "AA.AP161201A001";

	/** ��Ʒ���� **/
	private String productName = "AMDL";

	/** ���� **/
	private String type = "������";

	/** ���� */
	private String other = "TSX F34002220160004";

	/** ��߾� */
	private double paddingLeft = 0;

	/** �ϱ߾� */
	private double paddingTop = 0;

	/**
	 * @return the printerName
	 */
	public String getPrinterName() {
		return printerName;
	}

	/**
	 * @param printerName
	 *            the printerName to set
	 */
	public void setPrinterName(String printerName) {
		this.printerName = printerName;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName
	 *            the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the other
	 */
	public String getOther() {
		return other;
	}

	/**
	 * @param other
	 *            the other to set
	 */
	public void setOther(String other) {
		this.other = other;
	}

	/**
	 * @return the paddingLeft
	 */
	public double getPaddingLeft() {
		return paddingLeft;
	}

	/**
	 * @param paddingLeft
	 *            the paddingLeft to set
	 */
	public void setPaddingLeft(double paddingLeft) {
		this.paddingLeft = paddingLeft;
	}

	/**
	 * @return the paddingTop
	 */
	public double getPaddingTop() {
		return paddingTop;
	}

	/**
	 * @param paddingTop
	 *            the paddingTop to set
	 */
	public void setPaddingTop(double paddingTop) {
		this.paddingTop = paddingTop;
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
	 * ���ñ߾ࡣ
	 * 
	 * @param paddingLeft
	 * @param paddingTop
	 */
	public void setPadding(double paddingLeft, double paddingTop) {
		this.paddingLeft = paddingLeft;
		this.paddingTop = paddingTop;
	}

	public PrintfLabel(String printerName) {
		super();
		this.printerName = printerName;
	}

	public PrintfLabel() {
		super();
	}

	/**
	 * @param Graphicָ����ӡ��ͼ�λ���
	 * @param PageFormatָ����ӡҳ��ʽ��ҳ���С�Ե�Ϊ������λ��1��Ϊ1Ӣ�ŵ�1/72��1Ӣ��Ϊ25.4���ס�A4ֽ����Ϊ595��
	 *            842�㣩
	 * @param pageIndexָ��ҳ��
	 **/
	public int print(Graphics gra, PageFormat pf, int pageIndex) throws PrinterException {
		// Component c = null;
		// ת����Graphics2D
		Graphics2D g2 = (Graphics2D) gra;
		// ���ô�ӡ��ɫΪ��ɫ
		g2.setColor(Color.black);

		// ��ӡ�������
		// double x = pf.getImageableX();
		// double y = pf.getImageableY();

		switch (pageIndex) {
		case 0:
			// ���ô�ӡ���壨�������ơ���ʽ�͵��С�����������ƿ�������������߼����ƣ�
			// Javaƽ̨���������������ϵ�У�Serif��SansSerif��Monospaced��Dialog �� DialogInput
			Font font = new Font("������", Font.BOLD, Constants.LABELFONTSIZE);
			g2.setFont(font);// ��������
			// BasicStroke bs_3=new BasicStroke(0.5f);
			// float[] dash1 = {2.0f};
			// ���ô�ӡ�ߵ����ԡ�
			// 1.�߿� 2��3����֪����4���հ׵Ŀ�ȣ�5�����ߵĿ�ȣ�6��ƫ����
			// g2.setStroke(new BasicStroke(0.5f, BasicStroke.CAP_BUTT,
			// BasicStroke.JOIN_MITER, 2.0f, dash1, 0.0f));
			// g2.setStroke(bs_3);//�����߿�
			// float heigth = font.getSize2D();// ����߶�
			// -1- ��Graphics2Dֱ�����
			// ���ַ��Ļ���(���²�)λ���û��ռ��е� (x, y) λ�ô�
			// g2.drawLine(10,10,200,300);
			// Image codeImg = null;
			// try {
			// codeImg = ImageIO.read(new
			// File("C:\\toolsZ\\codeZ\\Code128.png"));
			// } catch (IOException e) {
			// e.printStackTrace();
			// throw new RuntimeException("�޷��������룡");
			// }

			g2.drawString(productName, (float) (Constants.LABELPRODUCTNAMELEFT + 23.61),
					(float) (Constants.LABELPRODUCTNAMETOP + 41));
			g2.drawString(type, (float) (Constants.LABELTYPELEFT + 23.61), (float) (Constants.LABELTYPETOP + 48));
			g2.drawString(productDate, (float) (Constants.LABELDATELEFT + 23.61),
					(float) (Constants.LABELDATETOP + 58));
			g2.drawString(serialNumber, (float) (Constants.LABELSERLEFT + 23.61), (float) (Constants.LABELSERTOP + 65));
			g2.drawString(other, (float) (Constants.LABELOTHERLEFT + 23.61), (float) (Constants.LABELOTHERTOP + 74));

			// g2.drawImage(codeImg, (int) (x + 14), (int) (y + 38), (int)
			// (codeImg.getWidth(null) * 0.56), (int) (15), c);
			return PAGE_EXISTS;
		default:
			return NO_SUCH_PAGE;
		}

	}

	public static void main(String[] args) {

		// ͨ���������顢�ĵ�
		Book book = new Book();
		// ���ó�����
		PageFormat pf = new PageFormat();
		pf.setOrientation(PageFormat.PORTRAIT);
		// ͨ��Paper����ҳ��Ŀհױ߾�Ϳɴ�ӡ���򡣱�����ʵ�ʴ�ӡֽ�Ŵ�С�����
		Paper p = new Paper();
		p.setSize(70.822, 113.3147);// ֽ�Ŵ�С
		// A4(595 X 842)���ô�ӡ������ʵ0��0Ӧ����72��72����ΪA4ֽ��Ĭ��X,Y�߾���72
		p.setImageableArea(0, 0, 70.822, 113.3147);
		pf.setPaper(p);
		// �� PageFormat �� Printable ��ӵ����У����һ��ҳ��
		book.append(new PrintfLabel(), pf);

		// ��ȡ��ӡ�������
		PrinterJob job = PrinterJob.getPrinterJob();

		HashAttributeSet hs = new HashAttributeSet();

		String printerName = "Foxit Reader Plus Printer";

		hs.add(new PrinterName(printerName, null));

		PrintService[] pss = PrintServiceLookup.lookupPrintServices(null, hs);

		try {
			job.setPrintService(pss[0]);
		} catch (PrinterException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// ���ô�ӡ��
		job.setPageable(book);

		try {
			// ������printDialog��ʾ��ӡ�Ի������û�ȷ�Ϻ��ӡ��Ҳ����ֱ�Ӵ�ӡ
			// boolean a=job.printDialog();
			// if(a)
			// {
			job.print();
			// }
		} catch (PrinterException e) {
			e.printStackTrace();
		}
	}

	public void printcode() {

		// ͨ���������顢�ĵ�
		Book book = new Book();

		PageFormat pageFormat = new PageFormat();
		// ��ӡ����
		pageFormat.setOrientation(PageFormat.PORTRAIT);
		// ͨ��Paper����ҳ��Ŀհױ߾�Ϳɴ�ӡ���򡣱�����ʵ�ʴ�ӡֽ�Ŵ�С�����
		Paper paper = new Paper();
		paper.setSize(70.822, 113.3147);// ֽ�Ŵ�С
		// A4(595 X 842)���ô�ӡ������ʵ0��0Ӧ����72��72����ΪA4ֽ��Ĭ��X,Y�߾���72
		paper.setImageableArea(paddingLeft, paddingTop, 70.822, 113.3147);
		pageFormat.setPaper(paper);
		// �� PageFormat �� Printable ��ӵ����У����һ��ҳ��
		book.append(this, pageFormat);

		// ��ȡ��ӡ�������
		PrinterJob printJob = PrinterJob.getPrinterJob();

		HashAttributeSet hashAttributeSet = new HashAttributeSet();

		hashAttributeSet.add(new PrinterName(printerName, null));

		PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, hashAttributeSet);

		try {
			printJob.setPrintService(printServices[0]);
		} catch (PrinterException e1) {
			e1.printStackTrace();
			throw new RuntimeException(e1.getMessage());
		}

		// ���ô�ӡ��
		printJob.setPageable(book);
		try {
			// ������printDialog��ʾ��ӡ�Ի������û�ȷ�Ϻ��ӡ��Ҳ����ֱ�Ӵ�ӡ
			// boolean a=job.printDialog();
			// if(a)
			// {
			printJob.print();
			// }
		} catch (PrinterException e) {
			e.printStackTrace();
		}

	}
}