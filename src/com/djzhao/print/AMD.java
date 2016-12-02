package com.djzhao.print;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashAttributeSet;
import javax.print.attribute.standard.PrinterName;

public class AMD implements Printable {

	/** ��ӡ������ */
	private String printerName = "ZDesigner 105SLPlus-300dpi ZPL";

	/** ��Ʒ�� */
	private String productCode = "AMDL2R-800-222-1FF";
	/** �������� */
	private String type = "Certifcation Documents CE";
	/** ֤���� */
	private String certNo = "Certifcation Documents CE";
	/** ���к� */
	private String sn = "162000001";
	/** ���۵��� */
	private String salesNo = "CNSIHG123456";
	/** ���� */
	private String dateStr = "2015/02/23";
	/** ���ݿ��е������� */
	private String code = "C2L2M000M00N080#160409000000000000004101";
	/** ���Ϻ� */
	private String item = "2L2M000M00N080";
	/** �������� */
	private String desc = "AA01C�Ҽ�PL= 800SF50";
	/** ��ˮ�� */
	private String sno = "151502020";

	/** ��߾� */
	private double paddingLeft = 0;

	/** �ϱ߾� */
	private double paddingTop = 0;

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

	public AMD(String printerName, String productCode, String type, String certNo, String sn, String salesNo,
			String dateStr, String code, String item, String desc, String sno) {
		super();
		this.printerName = printerName;
		this.productCode = productCode;
		this.type = type;
		this.certNo = certNo;
		this.sn = sn;
		this.salesNo = salesNo;
		this.dateStr = dateStr;
		this.code = code;
		this.item = item;
		this.desc = desc;
		this.sno = sno;
	}

	public AMD() {
		super();
	}

	/**
	 * @param Graphicָ����ӡ��ͼ�λ���
	 * @param PageFormatָ����ӡҳ��ʽ��ҳ���С�Ե�Ϊ������λ��1��Ϊ1Ӣ�ŵ�1/72��1Ӣ��Ϊ25.4���ס�A4ֽ����Ϊ595��
	 *            842�㣩
	 * @param pageIndexָ��ҳ��
	 **/
	public int print(Graphics gra, PageFormat pf, int pageIndex) throws PrinterException {
		Component c = null;
		// ת����Graphics2D
		Graphics2D g2 = (Graphics2D) gra;
		// ���ô�ӡ��ɫΪ��ɫ
		g2.setColor(Color.black);

		// ��ӡ�������
		double x = pf.getImageableX();
		double y = pf.getImageableY();

		switch (pageIndex) {
		case 0:
			// ���ô�ӡ���壨�������ơ���ʽ�͵��С�����������ƿ�������������߼����ƣ�
			// Javaƽ̨���������������ϵ�У�Serif��SansSerif��Monospaced��Dialog �� DialogInput
			Font font = new Font("������", Font.BOLD, 12);
			g2.setFont(font);// ��������
			g2.drawString(productCode, (float) (x + 58), (float) (y + 25f));

			font = new Font("������", Font.BOLD, 7);
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
			Image codeImg = null;
			try {
				codeImg = ImageIO.read(new File("C:\\toolsZ\\codeZ\\amd.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			g2.drawString(type, (float) (x + 88), (float) (y + 47));
			g2.drawString(certNo, (float) (x + 88), (float) (y + 56));
			g2.drawString(sn, (float) (x + 88), (float) (y + 66));
			g2.drawString(salesNo, (float) (x + 88), (float) (y + 76));
			g2.drawString(dateStr, (float) (x + 88), (float) (y + 87));

			g2.drawImage(codeImg, (int) (x + 242), (int) (y + 48), c);

			int indexSharp = code.indexOf('#');

			font = new Font("������", Font.BOLD, 6);
			g2.setFont(font);// ��������

			// ������Ŀ��
			g2.drawString("��Ŀ�ţ�", (float) (x + 293), (float) (y + 22));
			g2.drawString(code.substring(indexSharp + 7, indexSharp + 13), (float) (x + 293), (float) (y + 30));

			// ������ˮ��
			g2.drawString("��ˮ�ţ�", (float) (x + 293), (float) (y + 41));
			g2.drawString(sno, (float) (x + 293), (float) (y + 48));

			// �������Ϻ�
			g2.drawString("���Ϻţ�", (float) (x + 293), (float) (y + 59));
			g2.drawString(item, (float) (x + 293), (float) (y + 66));

			// ������������
			g2.drawString("����������", (float) (x + 293), (float) (y + 77));
			int len = desc.length();
			if (len > 15) {
				g2.drawString(desc.substring(0, 15), (float) (x + 293), (float) (y + 84));
				g2.drawString(desc.substring(15, len), (float) (x + 293), (float) (y + 90));
			} else {
				g2.drawString(desc, (float) (x + 293), (float) (y + 84));
			}

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
		pf.setOrientation(PageFormat.LANDSCAPE);
		// ͨ��Paper����ҳ��Ŀհױ߾�Ϳɴ�ӡ���򡣱�����ʵ�ʴ�ӡֽ�Ŵ�С�����
		Paper p = new Paper();
		p.setSize(95, 380);// ֽ�Ŵ�С
		p.setImageableArea(0, 0, 95, 380);// A4(595 X
											// 842)���ô�ӡ������ʵ0��0Ӧ����72��72����ΪA4ֽ��Ĭ��X,Y�߾���72
		pf.setPaper(p);
		// �� PageFormat �� Printable ��ӵ����У����һ��ҳ��
		book.append(new AMD(), pf);

		// ��ȡ��ӡ�������
		PrinterJob job = PrinterJob.getPrinterJob();

		HashAttributeSet hs = new HashAttributeSet();

		String printerName = "ZDesigner ZM400 300 dpi (ZPL) (���� 2)";

		hs.add(new PrinterName(printerName, null));

		PrintService[] pss = PrintServiceLookup.lookupPrintServices(null, hs);

		try {
			job.setPrintService(pss[0]);
		} catch (PrinterException e1) {
			e1.printStackTrace();
		}

		// ���ô�ӡ��
		job.setPageable(book);

		try {
			// ������printDialog��ʾ��ӡ�Ի������û�ȷ�Ϻ��ӡ��Ҳ����ֱ�Ӵ�ӡ
			// boolean a = job.printDialog();
			// if (a) {
			job.print();
			// }
		} catch (PrinterException e) {
			e.printStackTrace();
		}
	}

	public void printcode() {

		// ͨ���������顢�ĵ�
		Book book = new Book();
		// ���ó�����
		PageFormat pf = new PageFormat();
		pf.setOrientation(PageFormat.LANDSCAPE);
		// ͨ��Paper����ҳ��Ŀհױ߾�Ϳɴ�ӡ���򡣱�����ʵ�ʴ�ӡֽ�Ŵ�С�����
		Paper p = new Paper();
		p.setSize(95, 380);// ֽ�Ŵ�С
		p.setImageableArea(paddingLeft, paddingTop, 95, 380);// A4(595 X
		// 842)���ô�ӡ������ʵ0��0Ӧ����72��72����ΪA4ֽ��Ĭ��X,Y�߾���72
		pf.setPaper(p);
		// �� PageFormat �� Printable ��ӵ����У����һ��ҳ��
		book.append(new AMD(printerName, productCode, type, certNo, sn, salesNo, dateStr, code, item, desc, sno), pf);

		// ��ȡ��ӡ�������
		PrinterJob job = PrinterJob.getPrinterJob();

		HashAttributeSet hs = new HashAttributeSet();

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
}