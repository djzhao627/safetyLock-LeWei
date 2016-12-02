package com.djzhao.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.djzhao.dao.SqliteDao;
import com.djzhao.utils.Constants;
import com.djzhao.utils.ExcelFileFilter;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.HierarchyEvent;

/**
 * 主界面。
 * 
 * @author djzhao
 * @time 2016年11月24日 上午9:28:05
 */
public class MainView extends JFrame {

	private static final long serialVersionUID = -1715638341393673991L;
	private JPanel contentPane;
	/** Excel文件路径 */
	private JTextField dataFilePath;
	/** 标签日期 */
	private JTextField labelDate;
	/** 标签序列号 */
	private JTextField labelSer;
	/** 文件选择器 */
	JFileChooser jfc = new JFileChooser();
	private static DefaultComboBoxModel<String> aModel = new DefaultComboBoxModel<>();
	private JComboBox<String> printerSelector;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setPrinterModel();
					MainView frame = new MainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}
	
	/**
	 * 设置打印机列表模型。
	 */
	private static void setPrinterModel() {
		//构建打印请求属性集  
		HashPrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();  
		//设置打印格式，因为未确定类型，所以选择autosense  
		DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;  
		//查找所有的可用的打印服务  
		PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
		String defaultPrinterName = getDefaultPrinter();
		String printerName = "";
		for (PrintService p : printService) {
			printerName = p.getName();
			if (defaultPrinterName.equals(printerName)) {
				aModel.setSelectedItem(printerName);
			}
			aModel.addElement(printerName);
		}
	}

	/**
	 * 获取默认打印机。
	 * @return 
	 */
	private static String getDefaultPrinter() {
		SqliteDao sd = new SqliteDao();
		String result = null;
		try {
			result = sd.getDefaultPrinterName();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return result;
	}

	/**
	 * Create the frame.
	 */
	public MainView() {
		// 不可改变窗口大小
		setResizable(false);
		// 设置图标
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("/images/Wittur_Logo.gif")));
		// 设置标题
		setTitle("安全锁标签");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		setBounds((int) ((screenWidth - 400) / 2), (int) ((screenHeight - 300) / 2), 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("\u6570\u636E\u6587\u4EF6\uFF1A");
		label.setFont(new Font("SimSun", Font.PLAIN, 12));
		label.setBounds(10, 10, 70, 15);
		contentPane.add(label);

		dataFilePath = new JTextField();
		dataFilePath.setForeground(Color.DARK_GRAY);
		dataFilePath.setText(Constants.EXCELPATH);
		dataFilePath.setToolTipText("\u6587\u4EF6\u76EE\u5F55");
		dataFilePath.setFont(new Font("宋体", Font.PLAIN, 11));
		dataFilePath.setBounds(90, 7, 200, 21);
		contentPane.add(dataFilePath);
		dataFilePath.setColumns(10);

		JButton chosePath = new JButton("\u9009\u62E9");
		chosePath.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 设定只能选择到文件
				jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				// 设置文件过滤
				jfc.setFileFilter(new ExcelFileFilter());
				jfc.setCurrentDirectory(new File(Constants.EXCELPATH));
				// 此句是打开文件选择器界面的触发语句
				int state = jfc.showOpenDialog(null);
				if (state == JFileChooser.CANCEL_OPTION) {
					return;
				} else {
					File file = jfc.getSelectedFile();// file为选择到的文件
					dataFilePath.setText(file.getAbsolutePath());
					// 更新excel路径
					String path = dataFilePath.getText();
					if (!path.isEmpty()) {
						getDefaultPrinter();
						SqliteDao sd = new SqliteDao();
						sd.setExcelPath(path);
						// 设置常量
						Constants.EXCELPATH = path;
					}

				}
			}
		});
		chosePath.setOpaque(false);
		chosePath.setFont(new Font("SimSun", Font.PLAIN, 12));
		chosePath.setBounds(304, 6, 80, 23);
		contentPane.add(chosePath);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 230, 374, 2);
		contentPane.add(separator);

		JLabel label_1 = new JLabel("\u7EBF    \u522B\uFF1A");
		label_1.setFont(new Font("SimSun", Font.PLAIN, 12));
		label_1.setBounds(10, 57, 70, 15);
		contentPane.add(label_1);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("SimSun", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "AA AP\u7EBF", "AMD \u7EBF", "35100", "35200", "35300", "AMD DOP\u95E8\u673A" }));
		comboBox.setBounds(90, 54, 200, 21);
		contentPane.add(comboBox);

		JLabel label_2 = new JLabel("\u751F\u4EA7\u65E5\u671F\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 12));
		label_2.setBounds(10, 106, 70, 15);
		contentPane.add(label_2);

		labelDate = new JTextField();
		labelDate.setText("date");
		labelDate.setOpaque(false);
		labelDate.setEnabled(false);
		labelDate.setBounds(90, 104, 200, 21);
		contentPane.add(labelDate);
		labelDate.setColumns(10);

		JLabel label_3 = new JLabel("\u552F\u4E00\u7F16\u53F7\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 12));
		label_3.setBounds(10, 159, 70, 15);
		contentPane.add(label_3);

		labelSer = new JTextField();
		labelSer.setText("serialNumber");
		labelSer.setOpaque(false);
		labelSer.setEnabled(false);
		labelSer.setColumns(10);
		labelSer.setBounds(90, 157, 200, 21);
		contentPane.add(labelSer);

		JButton btnNewButton = new JButton("\u8C03\u6574\u6807\u7B7E");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdjustLabelPositionView alpv = AdjustLabelPositionView.GetAdjustLabelPositionView();
				alpv.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("SimSun", Font.PLAIN, 12));
		btnNewButton.setOpaque(false);
		btnNewButton.setBounds(10, 242, 93, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u8865\u6253\u5370");
		btnNewButton_1.setFont(new Font("SimSun", Font.PLAIN, 12));
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setBounds(113, 242, 93, 23);
		contentPane.add(btnNewButton_1);

		JButton button_1 = new JButton("\u6253\u5370");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String date = labelDate.getText().toString().trim();
				String serialNumber = labelSer.getText().toString().trim();
				if (date.isEmpty() || serialNumber.isEmpty()) {
					JOptionPane.showMessageDialog(null, "标签信息不足！");
					return;
				}
				File path = new File(dataFilePath.getText().toString());
				if (!path.exists()) {
					JOptionPane.showMessageDialog(null, "数据文件路径无效！");
					return;
				}
			}
		});
		button_1.setFont(new Font("SimSun", Font.PLAIN, 12));
		button_1.setBounds(304, 197, 80, 23);
		contentPane.add(button_1);

		JLabel label_4 = new JLabel("\u6253 \u5370 \u673A\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 12));
		label_4.setBounds(10, 201, 70, 15);
		contentPane.add(label_4);

		printerSelector = new JComboBox<String>();
		printerSelector.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					// 更改默认打印机
					SqliteDao sd = new SqliteDao();
					try {
						sd.setDefaultPrinterName(printerSelector.getSelectedItem().toString());
					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
			}
		});
		printerSelector.setForeground(Color.BLACK);
		printerSelector.setFont(new Font("宋体", Font.ITALIC, 12));
		printerSelector.setModel(aModel);
		printerSelector.setBounds(90, 199, 200, 21);
		contentPane.add(printerSelector);
		
		JButton btnNewButton_2 = new JButton("\u5237\u65B0");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				File path = new File(dataFilePath.getText().toString());
				if (!path.exists()) {
					JOptionPane.showMessageDialog(null, "数据文件路径无效！");
					return;
				}
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.ITALIC, 12));
		btnNewButton_2.setBounds(304, 102, 80, 23);
		contentPane.add(btnNewButton_2);
	}
	public void getLineAAInfo() {
		
	}
}
