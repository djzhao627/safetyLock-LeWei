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

	/** 打印机名称 */
	private String printerName = "Foxit Reader Plus Printer";

	/** 生产日期 */
	private String productDate = "161201";

	/** 产品编号 */
	private String serialNumber = "AA.AP161201A001";

	/** 产品名称 **/
	private String productName = "AMDL";

	/** 类型 **/
	private String type = "层门锁";

	/** 其他 */
	private String other = "TSX F34002220160004";

	/** 左边距 */
	private double paddingLeft = 0;

	/** 上边距 */
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
	 * 设置边距。
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
	 * @param Graphic指明打印的图形环境
	 * @param PageFormat指明打印页格式（页面大小以点为计量单位，1点为1英才的1/72，1英寸为25.4毫米。A4纸大致为595×
	 *            842点）
	 * @param pageIndex指明页号
	 **/
	public int print(Graphics gra, PageFormat pf, int pageIndex) throws PrinterException {
		// Component c = null;
		// 转换成Graphics2D
		Graphics2D g2 = (Graphics2D) gra;
		// 设置打印颜色为黑色
		g2.setColor(Color.black);

		// 打印起点坐标
		// double x = pf.getImageableX();
		// double y = pf.getImageableY();

		switch (pageIndex) {
		case 0:
			// 设置打印字体（字体名称、样式和点大小）（字体名称可以是物理或者逻辑名称）
			// Java平台所定义的五种字体系列：Serif、SansSerif、Monospaced、Dialog 和 DialogInput
			Font font = new Font("新宋体", Font.BOLD, Constants.LABELFONTSIZE);
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
			// Image codeImg = null;
			// try {
			// codeImg = ImageIO.read(new
			// File("C:\\toolsZ\\codeZ\\Code128.png"));
			// } catch (IOException e) {
			// e.printStackTrace();
			// throw new RuntimeException("无法加载条码！");
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

		// 通俗理解就是书、文档
		Book book = new Book();
		// 设置成竖打
		PageFormat pf = new PageFormat();
		pf.setOrientation(PageFormat.PORTRAIT);
		// 通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。
		Paper p = new Paper();
		p.setSize(70.822, 113.3147);// 纸张大小
		// A4(595 X 842)设置打印区域，其实0，0应该是72，72，因为A4纸的默认X,Y边距是72
		p.setImageableArea(0, 0, 70.822, 113.3147);
		pf.setPaper(p);
		// 把 PageFormat 和 Printable 添加到书中，组成一个页面
		book.append(new PrintfLabel(), pf);

		// 获取打印服务对象
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

	public void printcode() {

		// 通俗理解就是书、文档
		Book book = new Book();

		PageFormat pageFormat = new PageFormat();
		// 打印方向
		pageFormat.setOrientation(PageFormat.PORTRAIT);
		// 通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。
		Paper paper = new Paper();
		paper.setSize(70.822, 113.3147);// 纸张大小
		// A4(595 X 842)设置打印区域，其实0，0应该是72，72，因为A4纸的默认X,Y边距是72
		paper.setImageableArea(paddingLeft, paddingTop, 70.822, 113.3147);
		pageFormat.setPaper(paper);
		// 把 PageFormat 和 Printable 添加到书中，组成一个页面
		book.append(this, pageFormat);

		// 获取打印服务对象
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

		// 设置打印类
		printJob.setPageable(book);
		try {
			// 可以用printDialog显示打印对话框，在用户确认后打印；也可以直接打印
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