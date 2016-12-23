package com.djzhao.view;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.djzhao.dao.SqliteDao;
import com.djzhao.model.Adjustment;
import javax.swing.JSeparator;

/**
 * 调整标签位置。
 * 
 * @author djzhao
 * @Date 2016年11月26日 下午9:15:02
 */
public class AdjustLabelPositionView extends JFrame {
	private static final long serialVersionUID = -7274259983815728490L;
	private static JTextField date_top;
	private static JTextField date_left;
	private static JTextField number_top;
	private static JTextField number_left;
	private static AdjustLabelPositionView alp = null;
	private static JTextField fontSize;
	private static JTextField product_name_top;
	private static JTextField product_name_left;
	private static JTextField type_top;
	private static JTextField type_left;
	private static JTextField other_top;
	private static JTextField other_left;

	public static void main(String[] args) {
		alp = new AdjustLabelPositionView();
		alp.setVisible(true);
	}
	
	public static AdjustLabelPositionView GetAdjustLabelPositionView() {
		if (alp == null) {
			alp = new AdjustLabelPositionView();
		}
		// 更新标签信息。
		try {
			updatePosition();
			updateFontSize();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return alp;
	}

	private AdjustLabelPositionView() {
		double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		setBounds((int) ((screenWidth - 400) / 2), (int) ((screenHeight - 295) / 2), 400, 295);
		// 不可改变窗口大小
		setResizable(false);
		// 设置图标
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("/images/Wittur_Logo.gif")));
		// 设置标题
		setTitle("标签调整");
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\u751F\u4EA7\u65E5\u671F\uFF1A");
		lblNewLabel.setFont(new Font("SimSun", Font.PLAIN, 12));
		lblNewLabel.setBounds(45, 108, 84, 15);
		getContentPane().add(lblNewLabel);

		JLabel label = new JLabel("\u4E0A\u8FB9\u8DDD");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("SimSun", Font.PLAIN, 12));
		label.setBounds(139, 10, 65, 15);
		getContentPane().add(label);

		JLabel label_1 = new JLabel("\u5DE6\u8FB9\u8DDD");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("SimSun", Font.PLAIN, 12));
		label_1.setBounds(259, 10, 66, 15);
		getContentPane().add(label_1);

		date_top = new JTextField();
		date_top.setText("0");
		date_top.setHorizontalAlignment(SwingConstants.CENTER);
		date_top.setBounds(138, 105, 66, 21);
		getContentPane().add(date_top);
		date_top.setColumns(10);

		date_left = new JTextField();
		date_left.setText("0");
		date_left.setHorizontalAlignment(SwingConstants.CENTER);
		date_left.setBounds(259, 105, 66, 21);
		getContentPane().add(date_left);
		date_left.setColumns(10);

		JLabel label_2 = new JLabel("\u552F\u4E00\u7F16\u53F7\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 12));
		label_2.setBounds(45, 138, 84, 15);
		getContentPane().add(label_2);

		number_top = new JTextField();
		number_top.setText("0");
		number_top.setHorizontalAlignment(SwingConstants.CENTER);
		number_top.setColumns(10);
		number_top.setBounds(138, 135, 66, 21);
		getContentPane().add(number_top);

		number_left = new JTextField();
		number_left.setText("0");
		number_left.setHorizontalAlignment(SwingConstants.CENTER);
		number_left.setColumns(10);
		number_left.setBounds(259, 135, 66, 21);
		getContentPane().add(number_left);

		JButton button = new JButton("\u63D0\u4EA4");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					String date_top_str = date_top.getText().toString().trim().isEmpty() ? "0" : date_top.getText().toString();
					String date_left_str = date_left.getText().toString().trim().isEmpty() ? "0"
							: date_left.getText().toString();
					String number_top_str = number_top.getText().toString().trim().isEmpty() ? "0"
							: number_top.getText().toString();
					String number_left_str = number_left.getText().toString().trim().isEmpty() ? "0"
							: number_left.getText().toString();
					String product_name_top_str = product_name_top.getText().toString().trim().isEmpty() ? "0"
							: product_name_top.getText().toString();
					String product_name_left_str = product_name_left.getText().toString().trim().isEmpty() ? "0"
							: product_name_left.getText().toString();
					String type_top_str = type_top.getText().toString().trim().isEmpty() ? "0"
							: type_top.getText().toString();
					String type_left_str = type_left.getText().toString().trim().isEmpty() ? "0"
							: type_left.getText().toString();
					String other_top_str = other_top.getText().toString().trim().isEmpty() ? "0"
							: other_top.getText().toString();
					String other_left_str = other_left.getText().toString().trim().isEmpty() ? "0"
							: other_left.getText().toString();

					SqliteDao sd = new SqliteDao();
					
					int size = 0;
					try {
						size = Integer.parseInt(fontSize.getText().toString().trim());
					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "输入的数字有误！");
						return;
					}
					
					if (!sd.setFontSize(size)) {
						JOptionPane.showMessageDialog(null, "无法更新标签字体大小！");
					}
					// 提交新的边距
					Adjustment adjustment = new Adjustment();
					adjustment.setName("date");
					adjustment.setLeft(Double.parseDouble(date_left_str));
					adjustment.setTop(Double.parseDouble(date_top_str));
					if (!sd.setPosition(adjustment)) {
						JOptionPane.showMessageDialog(null, "无法更新标签的位置数据！");
						return;
					}
					adjustment.setName("serialNumber");
					adjustment.setLeft(Double.parseDouble(number_left_str));
					adjustment.setTop(Double.parseDouble(number_top_str));
					if (!sd.setPosition(adjustment)) {
						JOptionPane.showMessageDialog(null, "无法更新标签的位置数据！");
						return;
					}
					adjustment.setName("productName");
					adjustment.setLeft(Double.parseDouble(product_name_left_str));
					adjustment.setTop(Double.parseDouble(product_name_top_str));
					if (!sd.setPosition(adjustment)) {
						JOptionPane.showMessageDialog(null, "无法更新标签的位置数据！");
						return;
					}
					adjustment.setName("type");
					adjustment.setLeft(Double.parseDouble(type_left_str));
					adjustment.setTop(Double.parseDouble(type_top_str));
					if (!sd.setPosition(adjustment)) {
						JOptionPane.showMessageDialog(null, "无法更新标签的位置数据！");
						return;
					}
					adjustment.setName("other");
					adjustment.setLeft(Double.parseDouble(other_left_str));
					adjustment.setTop(Double.parseDouble(other_top_str));
					if (!sd.setPosition(adjustment)) {
						JOptionPane.showMessageDialog(null, "无法更新标签的位置数据！");
						return;
					}
					JOptionPane.showMessageDialog(null, "标签的位置数据已经更新！");
				} catch (NumberFormatException e1) {
					// e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "您的输入不正确！");
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
		button.setBounds(260, 235, 65, 23);
		getContentPane().add(button);

		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 重置
				date_top.setText("0");
				date_left.setText("0");
				type_top.setText("0");
				type_left.setText("0");
				other_top.setText("0");
				other_left.setText("0");
				number_top.setText("0");
				number_left.setText("0");
				product_name_top.setText("0");
				product_name_left.setText("0");
			}
		});
		button_1.setBounds(139, 235, 65, 23);
		getContentPane().add(button_1);

		JLabel label_3 = new JLabel("\u5B57\u4F53\u5927\u5C0F\uFF1A");
		label_3.setBounds(45, 198, 84, 15);
		getContentPane().add(label_3);

		fontSize = new JTextField();
		fontSize.setText("6");
		fontSize.setHorizontalAlignment(SwingConstants.CENTER);
		fontSize.setBounds(138, 195, 66, 21);
		getContentPane().add(fontSize);
		fontSize.setColumns(10);
		
		JLabel label_4 = new JLabel("\u63A7    \u4EF6");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("宋体", Font.PLAIN, 12));
		label_4.setBounds(33, 10, 75, 15);
		getContentPane().add(label_4);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 35, 374, 9);
		getContentPane().add(separator);
		
		JLabel label_5 = new JLabel("\u4EA7\u54C1\u540D\u79F0\uFF1A");
		label_5.setFont(new Font("宋体", Font.PLAIN, 12));
		label_5.setBounds(45, 48, 84, 15);
		getContentPane().add(label_5);
		
		product_name_top = new JTextField();
		product_name_top.setText("0");
		product_name_top.setHorizontalAlignment(SwingConstants.CENTER);
		product_name_top.setColumns(10);
		product_name_top.setBounds(138, 45, 66, 21);
		getContentPane().add(product_name_top);
		
		product_name_left = new JTextField();
		product_name_left.setText("0");
		product_name_left.setHorizontalAlignment(SwingConstants.CENTER);
		product_name_left.setColumns(10);
		product_name_left.setBounds(259, 45, 66, 21);
		getContentPane().add(product_name_left);
		
		JLabel label_6 = new JLabel("\u7C7B    \u578B\uFF1A");
		label_6.setFont(new Font("宋体", Font.PLAIN, 12));
		label_6.setBounds(45, 78, 84, 15);
		getContentPane().add(label_6);
		
		type_top = new JTextField();
		type_top.setText("0");
		type_top.setHorizontalAlignment(SwingConstants.CENTER);
		type_top.setColumns(10);
		type_top.setBounds(138, 75, 66, 21);
		getContentPane().add(type_top);
		
		type_left = new JTextField();
		type_left.setText("0");
		type_left.setHorizontalAlignment(SwingConstants.CENTER);
		type_left.setColumns(10);
		type_left.setBounds(259, 75, 66, 21);
		getContentPane().add(type_left);
		
		JLabel label_7 = new JLabel("\u5176\u4ED6\u5185\u5BB9\uFF1A");
		label_7.setFont(new Font("宋体", Font.PLAIN, 12));
		label_7.setBounds(45, 168, 84, 15);
		getContentPane().add(label_7);
		
		other_top = new JTextField();
		other_top.setText("0");
		other_top.setHorizontalAlignment(SwingConstants.CENTER);
		other_top.setColumns(10);
		other_top.setBounds(138, 165, 66, 21);
		getContentPane().add(other_top);
		
		other_left = new JTextField();
		other_left.setText("0");
		other_left.setHorizontalAlignment(SwingConstants.CENTER);
		other_left.setColumns(10);
		other_left.setBounds(259, 165, 66, 21);
		getContentPane().add(other_left);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 225, 374, 9);
		getContentPane().add(separator_1);

	}

	/**
	 * 更新标签字体大小。
	 */
	private static void updateFontSize() {
		SqliteDao sd = new SqliteDao();
		String size = sd.getFontSize();
		fontSize.setText(size);
	}

	/**
	 * 更新标签位置信息。
	 */
	private static void updatePosition() {
		SqliteDao sd = new SqliteDao();
		List<Adjustment> list = sd.getPosition();
		if (!list.isEmpty()) {
			date_top.setText(list.get(0).getTop() + "");
			date_left.setText(list.get(0).getLeft() + "");
			number_top.setText(list.get(1).getTop() + "");
			number_left.setText(list.get(1).getLeft() + "");
			product_name_top.setText(list.get(2).getTop() + "");
			product_name_left.setText(list.get(2).getLeft() + "");
			type_top.setText(list.get(3).getTop() + "");
			type_left.setText(list.get(3).getLeft() + "");
			other_top.setText(list.get(4).getTop() + "");
			other_left.setText(list.get(4).getLeft() + "");
		}
	}
}
