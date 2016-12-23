package com.djzhao.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

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
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;

import com.djzhao.dao.MySQLDao;
import com.djzhao.dao.SqliteDao;
import com.djzhao.model.Adjustment;
import com.djzhao.model.PrintInfo;
import com.djzhao.print.PrintfLabel;
import com.djzhao.utils.Constants;
import com.djzhao.utils.ExcelFileFilter;
import com.djzhao.utils.ExcelUtil;
import javax.swing.SwingConstants;

/**
 * �����档
 * 
 * @author djzhao
 * @time 2016��11��24�� ����9:28:05
 */
public class MainView extends JFrame {

	private static final long serialVersionUID = -1715638341393673991L;
	private JPanel contentPane;
	/** Excel�ļ�·�� */
	private JTextField dataFilePath;
	/** ��ǩ���� */
	private JTextField labelDate;
	/** ��ǩ���к� */
	private JTextField labelSer;
	/** �ļ�ѡ���� */
	JFileChooser jfc = new JFileChooser();
	private static DefaultComboBoxModel<String> aModel = new DefaultComboBoxModel<>();
	private JComboBox<String> printerSelector;
	// private static JComboBox<String> lineName;
	private JButton btnPrint;
	private JButton btnChoose;
	private JButton btnAdjust;
	private JButton btnReprint;
	private JLabel printProcess;
	private JTextField labelProductName;
	private JTextField labelType;
	private JTextField labelOther;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
					// getDefaultSelectedLine();
					setPrinterModel();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}

	/**
	 * ���ô�ӡ���б�ģ�͡�
	 */
	private static void setPrinterModel() {
		// ������ӡ�������Լ�
		HashPrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
		// ���ô�ӡ��ʽ����Ϊδȷ�����ͣ�����ѡ��autosense
		DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
		// �������еĿ��õĴ�ӡ����
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
	 * ��ȡĬ�ϴ�ӡ����
	 * 
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
	 * ��ȡĬ���߱�
	 */
	// private static void getDefaultSelectedLine() {
	// try {
	// SqliteDao sd = new SqliteDao();
	// lineName.setSelectedIndex(Integer.parseInt(sd.getDefaultSelectedLine().trim()));
	// Constants.SELECTEDLINEINDEX = lineName.getSelectedIndex();
	// } catch (Exception e) {
	// e.printStackTrace();
	// JOptionPane.showMessageDialog(null, e.getMessage());
	// }
	// }

	/**
	 * Create the frame.
	 */
	public MainView() {
		// ���ɸı䴰�ڴ�С
		setResizable(false);
		// ����ͼ��
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("/images/Wittur_Logo.gif")));
		// ���ñ���
		setTitle("��ȫ����ǩ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		setBounds((int) ((screenWidth - 400) / 2), (int) ((screenHeight - 300) / 2), 400, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("\u6570\u636E\u6587\u4EF6\uFF1A");
		label.setFont(new Font("SimSun", Font.PLAIN, 12));
		label.setBounds(10, 12, 70, 15);
		contentPane.add(label);

		dataFilePath = new JTextField();
		dataFilePath.setForeground(Color.DARK_GRAY);
		dataFilePath.setText(Constants.EXCELPATH);
		dataFilePath.setToolTipText("\u6587\u4EF6\u76EE\u5F55");
		dataFilePath.setFont(new Font("����", Font.PLAIN, 11));
		dataFilePath.setBounds(90, 10, 200, 21);
		contentPane.add(dataFilePath);
		dataFilePath.setColumns(10);

		btnChoose = new JButton("\u9009\u62E9");
		btnChoose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// �趨ֻ��ѡ���ļ�
				jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				// �����ļ�����
				jfc.setFileFilter(new ExcelFileFilter());
				jfc.setCurrentDirectory(new File(Constants.EXCELPATH));
				// �˾��Ǵ��ļ�ѡ��������Ĵ������
				int state = jfc.showOpenDialog(null);
				if (state == JFileChooser.CANCEL_OPTION) {
					return;
				} else {
					File file = jfc.getSelectedFile();// fileΪѡ�񵽵��ļ�
					dataFilePath.setText(file.getAbsolutePath());
					// ����excel·��
					String path = dataFilePath.getText();
					if (!path.isEmpty()) {
						getDefaultPrinter();
						SqliteDao sd = new SqliteDao();
						sd.setExcelPath(path);
						// ���ó���
						Constants.EXCELPATH = path;
					}

				}
			}
		});
		btnChoose.setOpaque(false);
		btnChoose.setFont(new Font("SimSun", Font.PLAIN, 12));
		btnChoose.setBounds(304, 6, 80, 23);
		contentPane.add(btnChoose);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 260, 374, 2);
		contentPane.add(separator);

		JLabel label_1 = new JLabel("\u4EA7\u54C1\u540D\u79F0\uFF1A");
		label_1.setFont(new Font("SimSun", Font.PLAIN, 12));
		label_1.setBounds(10, 58, 70, 15);
		contentPane.add(label_1);

		// lineName = new JComboBox<String>();
		// lineName.addItemListener(new ItemListener() {
		// public void itemStateChanged(ItemEvent e) {
		// // ����Ĭ���߱�
		// if (e.getStateChange() == ItemEvent.SELECTED) {
		// Constants.SELECTEDLINEINDEX = lineName.getSelectedIndex();
		// SqliteDao sqliteDao = new SqliteDao();
		// try {
		// sqliteDao.setDefaultSelectedLine(lineName.getSelectedIndex());
		// } catch (Exception e1) {
		// e1.printStackTrace();
		// JOptionPane.showMessageDialog(null, e1.getMessage());
		// }
		// }
		// }
		// });
		// lineName.setFont(new Font("SimSun", Font.PLAIN, 12));
		// lineName.setModel(new
		// DefaultComboBoxModel<String>(Constants.LINENAME));
		// lineName.setBounds(90, 54, 200, 21);
		// contentPane.add(lineName);

		JLabel label_2 = new JLabel("\u751F\u4EA7\u65E5\u671F\uFF1A");
		label_2.setFont(new Font("����", Font.PLAIN, 12));
		label_2.setBounds(10, 128, 70, 15);
		contentPane.add(label_2);

		labelDate = new JTextField();
		labelDate.setOpaque(false);
		labelDate.setEnabled(false);
		labelDate.setBounds(90, 125, 200, 21);
		contentPane.add(labelDate);
		labelDate.setColumns(10);

		JLabel label_3 = new JLabel("\u4EA7\u54C1\u7F16\u53F7\uFF1A");
		label_3.setFont(new Font("����", Font.PLAIN, 12));
		label_3.setBounds(10, 163, 70, 15);
		contentPane.add(label_3);

		labelSer = new JTextField();
		labelSer.setOpaque(false);
		labelSer.setEnabled(false);
		labelSer.setColumns(10);
		labelSer.setBounds(90, 160, 200, 21);
		contentPane.add(labelSer);

		btnAdjust = new JButton("\u8C03\u6574\u6807\u7B7E");
		btnAdjust.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdjustLabelPositionView alpv = AdjustLabelPositionView.GetAdjustLabelPositionView();
				alpv.setVisible(true);
			}
		});
		btnAdjust.setFont(new Font("SimSun", Font.PLAIN, 12));
		btnAdjust.setOpaque(false);
		btnAdjust.setBounds(10, 272, 93, 23);
		contentPane.add(btnAdjust);

		btnReprint = new JButton("\u8865\u6253\u5370");
		btnReprint.setFont(new Font("SimSun", Font.PLAIN, 12));
		btnReprint.setOpaque(false);
		btnReprint.setBounds(113, 272, 93, 23);
		contentPane.add(btnReprint);

		btnPrint = new JButton("\u6253\u5370");
		btnPrint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (btnPrint.isEnabled()) {
					// ���ò��ɽ�����������
					setUnableOperator();
					// ��ӡ
					goPrint().execute();
				}
			}
		});
		btnPrint.setFont(new Font("SimSun", Font.PLAIN, 12));
		btnPrint.setBounds(304, 227, 80, 23);
		contentPane.add(btnPrint);

		JLabel label_4 = new JLabel("\u6253 \u5370 \u673A\uFF1A");
		label_4.setFont(new Font("����", Font.PLAIN, 12));
		label_4.setBounds(10, 231, 70, 15);
		contentPane.add(label_4);

		printerSelector = new JComboBox<String>();
		printerSelector.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					// ����Ĭ�ϴ�ӡ��
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
		printerSelector.setFont(new Font("����", Font.ITALIC, 12));
		printerSelector.setModel(aModel);
		printerSelector.setBounds(90, 229, 200, 21);
		contentPane.add(printerSelector);

		printProcess = new JLabel("");
		printProcess.setFont(new Font("����", Font.ITALIC, 12));
		printProcess.setHorizontalAlignment(SwingConstants.RIGHT);
		printProcess.setBounds(279, 280, 105, 15);
		contentPane.add(printProcess);
		
		labelProductName = new JTextField();
		labelProductName.setEditable(false);
		labelProductName.setBounds(90, 55, 200, 21);
		contentPane.add(labelProductName);
		labelProductName.setColumns(10);
		
		labelType = new JTextField();
		labelType.setEditable(false);
		labelType.setColumns(10);
		labelType.setBounds(90, 90, 200, 21);
		contentPane.add(labelType);
		
		JLabel label_5 = new JLabel("\u7C7B    \u578B\uFF1A");
		label_5.setFont(new Font("����", Font.PLAIN, 12));
		label_5.setBounds(10, 93, 70, 15);
		contentPane.add(label_5);
		
		labelOther = new JTextField();
		labelOther.setEditable(false);
		labelOther.setColumns(10);
		labelOther.setBounds(90, 195, 200, 21);
		contentPane.add(labelOther);
		
		JLabel lblCertificate = new JLabel("\u8BC1    \u4E66\uFF1A");
		lblCertificate.setFont(new Font("����", Font.PLAIN, 12));
		lblCertificate.setBounds(10, 198, 70, 15);
		contentPane.add(lblCertificate);
	}

	/**
	 * ���ò��ɼ���������
	 */
	private void setUnableOperator() {
		dataFilePath.setEnabled(false);
		printerSelector.setEnabled(false);
		// lineName.setEnabled(false);
		btnAdjust.setEnabled(false);
		btnChoose.setEnabled(false);
		btnPrint.setEnabled(false);
		btnReprint.setEnabled(false);
	}

	/**
	 * ���ÿɼ���������
	 */
	private void setEnableOperator() {
		dataFilePath.setEnabled(true);
		printerSelector.setEnabled(true);
		// lineName.setEnabled(true);
		btnAdjust.setEnabled(true);
		btnChoose.setEnabled(true);
		btnPrint.setEnabled(true);
		btnReprint.setEnabled(true);
	}

	/**
	 * ���кŸ�ʽ����
	 * 
	 * @param serialNumber
	 * @return
	 */
	private String serialNumberLengthFormat(int serialNumber) {
		if (serialNumber > 100) {
			return serialNumber + "";
		} else if (serialNumber < 10) {
			return "00" + serialNumber;
		} else {
			return "0" + serialNumber;
		}
	}

	/**
	 * ���̴߳�ӡ��
	 * 
	 * @return
	 */
	private SwingWorker<Void, Void> goPrint() {
		SwingWorker<Void, Void> print = new SwingWorker<Void, Void>() {

			@Override
			protected Void doInBackground() {
				try {
					File path = new File(dataFilePath.getText().toString());
					if (!path.exists()) {
						JOptionPane.showMessageDialog(null, "�����ļ�·����Ч��");
						return null;
					}
					// ������ѡ�߱�
					// Constants.SELECTEDLINEINDEX =
					// lineName.getSelectedIndex();
					// ��ȡ��Ϣ
					List<PrintInfo> list = ExcelUtil.readExcel(path);
					// System.out.println(list);
					if (list.size() > 0) {
						// ʵ������ӡ������
						PrintfLabel print = new PrintfLabel(printerSelector.getSelectedItem().toString());
						
						// ���ñ߾�
						SqliteDao sd = new SqliteDao();
						try {
							List<Adjustment> position = sd.getPosition();
							Constants.LABELDATELEFT = position.get(0).getLeft();
							Constants.LABELDATETOP = position.get(0).getTop();
							Constants.LABELSERLEFT = position.get(1).getLeft();
							Constants.LABELSERTOP = position.get(1).getTop();
							Constants.LABELPRODUCTNAMELEFT = position.get(2).getLeft();
							Constants.LABELPRODUCTNAMETOP = position.get(2).getTop();
							Constants.LABELTYPELEFT = position.get(3).getLeft();
							Constants.LABELTYPETOP = position.get(3).getTop();
							Constants.LABELOTHERLEFT = position.get(4).getLeft();
							Constants.LABELOTHERTOP = position.get(4).getTop();
						} catch (Exception e) {
							e.printStackTrace();
							JOptionPane.showMessageDialog(null, "���ñ߾�������⣺\n" + e.getMessage());
						}
						
						// ���������С
						try {
							Constants.LABELFONTSIZE = Integer.parseInt(sd.getFontSize());
						} catch (Exception e) {
							e.printStackTrace();
							JOptionPane.showMessageDialog(null, "���������С�������⣺\n" + e.getMessage());
						}
						
						for (PrintInfo p : list) {
							
							// ����������Ϣ
							print = generateOtherInfo(print, p);
							
							// ���ñ�ǩ������
							print.setProductDate(p.getProductDate());
							
							int number = p.getNumber();
							MySQLDao md = new MySQLDao();
							// ��ȡ���к�
							if (md.getSerialNumber(number)) {
								// label��������
								labelDate.setText(p.getProductDate());
								// label��Ʒ��
								labelProductName.setText(print.getProductName());
								// label����
								labelType.setText(print.getType());
								// label֤��
								labelOther.setText(print.getOther());
								for (int i = 0; i < number; i++) {
									// �������к�
									p.setSerialNumber(formatWorkStation(p.getWorkStation()) + p.getClasses() + p.getProductDate()
											+ serialNumberLengthFormat(Constants.SERIALNUMBER++));
									// label��Ʒ���
									labelSer.setText(p.getSerialNumber());
									
									// ���� ��ǩ�ı��
									print.setSerialNumber(p.getSerialNumber());
									
									// ���͵���ӡ��
									print.printcode();
									
									// �洢�����ݿ�
									md.insertPrintInfo(p);
									
									// �����û�������ʾ
									printProcess.setText((i + 1) + "/" + number);
									// ˯��
									Thread.sleep(200);
								}
							}
						}
					}
					return null;
				} catch (HeadlessException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "IO�쳣��");
				} catch (NullPointerException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "������Ϣ��ƥ�䣡");
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "ERROE : " + e.getMessage());
				} finally {
					// ����Ϊ���Լ�������
					setEnableOperator();
				}
				return null;
			}


		};
		return print;
	}
	
	/**
	 * ��ȡ������Ϣ����Ʒ�������͡�������Ϣ��
	 * 
	 * @param print
	 * @param p
	 * @return
	 */
	private PrintfLabel generateOtherInfo(PrintfLabel print, PrintInfo p) {
		String S = p.getMaterialDescS();
		String T = p.getMaterialDescT();
		String C = p.getCustomer();
		if (S.contains("AMD") && S.contains("�Ҽ�") && "ͨ��".equals(C)){
			print.setProductName("AMDL");
			print.setType("������");
			print.setOther("TSX F34002220160004");
		} else if (S.contains("AMD") && S.contains("�Ż�") && S.contains("��") && S.contains("R5/D10") && "ͨ��".equals(C)) {
			print.setProductName("AMDC-R1/R5");
			print.setType("������");
			print.setOther("TSX F34002220160005");
		} else if (S.contains("AMD�Ż��� R2") && "ͨ��".equals(C)) {
			print.setProductName("AMDC-R2");
			print.setType("������");
			print.setOther("TX F340-022-16 0015");
		} else if (S.contains("AMD�Ż��� R6") && "ͨ��".equals(C)) {
			print.setProductName("AMDC-R6");
			print.setType("������");
			print.setOther("TSX F34002220160003");
		} else if ((S.contains("A-P") || S.contains("AP") || S.contains("Augusta")) && "".equals(C)) {
			print.setProductName("3215-Augusta");
			print.setType("������");
			print.setOther("TX F340-022-15 0021");
		} else if ((S.contains("A-P") || S.contains("AP") || S.contains("A-A") || S.contains("AA")) && "ͨ��".equals(C)) {
			print.setProductName("3215-Augusta");
			print.setType("������");
			print.setOther("TX F340-022-15 0022");
		} else if ((S.contains("A-E") || S.contains("AE") || S.contains("Aug-ECO")) && "Ѹ��".equals(C)) {
			print.setProductName("Augusta- ECO 2.X");
			print.setType("������");
			print.setOther("TX F340-022-15 0096");
		} else if ((S.contains("A-E") || S.contains("AE") || S.contains("Aug-ECO")) && "".equals(C)) {
			print.setProductName("Augusta- ECO");
			print.setType("������");
			print.setOther("TSX F34002220160049");
		} else if (S.contains("�Ҽ�") && S.contains("IP20") && T.contains("Hydra") && "".equals(C)) {
			print.setProductName("3201-Hydra");
			print.setType("������");
			print.setOther("TX F340-022-15 0056");
		} else if (S.contains("�Ҽ�") && S.contains("IP54") && T.contains("Hydra") && "".equals(C)) {
			print.setProductName("Hydra");
			print.setType("������");
			print.setOther("TX F340-022-16 0013");
		} else if ((S.contains("PEG") || S.contains("ECO") || S.contains("MID") || S.contains("SPA")) && S.contains("�Ż�") && S.contains("��") && S.contains("IP20") && "".equals(C)) {
			print.setProductName("Hydra Plus /Pegasus");
			print.setType("������");
			print.setOther("TSX F34002220160002");
		} else if ((S.contains("PEG") || S.contains("ECO") || S.contains("MID") || S.contains("SPA")) && S.contains("�Ż�") && S.contains("��") && S.contains("IP54") && "".equals(C)) {
			print.setProductName("Hydra Plus /Pegasus");
			print.setType("������");
			print.setOther("TX F340-022-16 0012");
		} else if (S.contains("ARM") && S.contains("��") && "".equals(C)){
			print.setProductName("Hydra ARM");
			print.setType("������");
			print.setOther("TX B340-022-15 0109");
		} else if (S.contains("�Ҽ�") && S.contains("IP20") && T.contains("Pegasus") && "".equals(C)){
			print.setProductName("3214-Pegasus");
			print.setType("������");
			print.setOther("TX F340-022-15 0060");
		} else if (S.contains("�Ҽ�") && S.contains("IP54") && T.contains("Pegasus") && "".equals(C)){
			print.setProductName("Pegasus");
			print.setType("������");
			print.setOther("TX F340-022-16 0011");
		} else if ("".equals(C)){
			print.setProductName("Augusta MD");
			print.setType("������");
			print.setOther("TX F340-022-15 0120");
		} else {
			throw new RuntimeException("�����޷�ƥ�䣡");
		}
		
		return print;
	}
	
	/**
	 * ��ʽ��������(��λ),���Ȳ���5λʱĩβ���㡣
	 * 
	 * @param name ��Ҫ������ַ���
	 * @return ת������ַ���
	 */
	public String formatWorkStation(String name) {
		if (null == name) {
			throw new RuntimeException("��λ����Ϊ�գ�");
		}
		while (name.length() < 5) {
			name += "0";
		}
		return name;
	}
}
