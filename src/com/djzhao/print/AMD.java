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

	/** 打印机名称 */
	private String printerName = "Foxit Reader Plus Printer";

	/** 产品码 */
	private String productCode = "AMDL2R-800-222-1FF";
	/** 部件类型 */
	private String type = "Certifcation Documents CE";
	/** 证书编号 */
	private String certNo = "Certifcation Documents CE";
	/** 序列号 */
	private String sn = "162000001";
	/** 销售单号 */
	private String salesNo = "CNSIHG123456";
	/** 日期 */
	private String dateStr = "2015/02/23";
	/** 数据库中的序列码 */
	private String code = "C2L2M000M00N080#160409000000000000004101";
	/** 物料号 */
	private String item = "2L2M000M00N080";
	/** 物料描述 */
	private String desc = "AA01C挂件PL= 800SF50";
	/** 流水号 */
	private String sno = "151502020";

	/** 左边距 */
	private double paddingLeft = 0;

	/** 上边距 */
	private double paddingTop = 0;

	/**
	 * 设置边距。
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
	 * @param Graphic指明打印的图形环境
	 * @param PageFormat指明打印页格式（页面大小以点为计量单位，1点为1英才的1/72，1英寸为25.4毫米。A4纸大致为595×
	 *            842点）
	 * @param pageIndex指明页号
	 **/
	public int print(Graphics gra, PageFormat pf, int pageIndex) throws PrinterException {
		Component c = null;
		// 转换成Graphics2D
		Graphics2D g2 = (Graphics2D) gra;
		// 设置打印颜色为黑色
		g2.setColor(Color.black);

		// 打印起点坐标
		double x = pf.getImageableX();
		double y = pf.getImageableY();

		switch (pageIndex) {
		case 0:
			// 设置打印字体（字体名称、样式和点大小）（字体名称可以是物理或者逻辑名称）
			// Java平台所定义的五种字体系列：Serif、SansSerif、Monospaced、Dialog 和 DialogInput
			Font font = new Font("新宋体", Font.BOLD, 12);
			g2.setFont(font);// 设置字体
			g2.drawString(productCode, (float) (x + 58), (float) (y + 25f));

			font = new Font("新宋体", Font.BOLD, 7);
			g2.setFont(font);// 设置字体
			// BasicStroke bs_3=new BasicStroke(0.5f);
			// float[] dash1 = {2.0f};
			// 设置打印线的属性。
			// 1.线宽 2、3、不知道，4、空白的宽度，5、虚线的宽度，6、偏移量
			// g2.setStroke(new BasicStroke(0.5f, BasicStroke.CAP_BUTT,
			// BasicStroke.JOIN_MITER, 2.0f, dash1, 0.0f));
			// g2.setStroke(bs_3);//设置线宽
			// float heigth = font.getSize2D();// 字体高度
			// -1- 用Graphics2D直接输出
			// 首字符的基线(右下部)位于用户空间中的 (x, y) 位置处
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

			font = new Font("新宋体", Font.BOLD, 6);
			g2.setFont(font);// 设置字体

			// 绘制项目号
			g2.drawString("项目号：", (float) (x + 293), (float) (y + 22));
			g2.drawString(code.substring(indexSharp + 7, indexSharp + 13), (float) (x + 293), (float) (y + 30));

			// 绘制流水号
			g2.drawString("流水号：", (float) (x + 293), (float) (y + 41));
			g2.drawString(sno, (float) (x + 293), (float) (y + 48));

			// 绘制物料号
			g2.drawString("物料号：", (float) (x + 293), (float) (y + 59));
			g2.drawString(item, (float) (x + 293), (float) (y + 66));

			// 绘制物料描述
			g2.drawString("物料描述：", (float) (x + 293), (float) (y + 77));
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

		// 通俗理解就是书、文档
		Book book = new Book();
		// 设置成竖打
		PageFormat pf = new PageFormat();
		pf.setOrientation(PageFormat.LANDSCAPE);
		// 通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。
		Paper p = new Paper();
		p.setSize(95, 380);// 纸张大小
		p.setImageableArea(0, 0, 95, 380);// A4(595 X
											// 842)设置打印区域，其实0，0应该是72，72，因为A4纸的默认X,Y边距是72
		pf.setPaper(p);
		// 把 PageFormat 和 Printable 添加到书中，组成一个页面
		book.append(new AMD(), pf);

		// 获取打印服务对象
		PrinterJob job = PrinterJob.getPrinterJob();

		HashAttributeSet hs = new HashAttributeSet();

		String printerName = "Foxit Reader Plus Printer";

		hs.add(new PrinterName(printerName, null));

		PrintService[] pss = PrintServiceLookup.lookupPrintServices(null, hs);

		try {
			job.setPrintService(pss[0]);
		} catch (PrinterException e1) {
			e1.printStackTrace();
		}

		// 设置打印类
		job.setPageable(book);

		try {
			// 可以用printDialog显示打印对话框，在用户确认后打印；也可以直接打印
			// boolean a = job.printDialog();
			// if (a) {
			job.print();
			// }
		} catch (PrinterException e) {
			e.printStackTrace();
		}
	}

	public void printcode() {

		// 通俗理解就是书、文档
		Book book = new Book();
		// 设置成竖打
		PageFormat pf = new PageFormat();
		pf.setOrientation(PageFormat.LANDSCAPE);
		// 通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。
		Paper p = new Paper();
		p.setSize(95, 380);// 纸张大小
		p.setImageableArea(paddingLeft, paddingTop, 95, 380);// A4(595 X
		// 842)设置打印区域，其实0，0应该是72，72，因为A4纸的默认X,Y边距是72
		pf.setPaper(p);
		// 把 PageFormat 和 Printable 添加到书中，组成一个页面
		book.append(new AMD(printerName, productCode, type, certNo, sn, salesNo, dateStr, code, item, desc, sno), pf);

		// 获取打印服务对象
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

		// 设置打印类
		job.setPageable(book);

		try {
			// 可以用printDialog显示打印对话框，在用户确认后打印；也可以直接打印
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