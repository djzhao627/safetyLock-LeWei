package com.djzhao.view;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.SwingConstants;

import com.djzhao.dao.SqliteDao;
import com.djzhao.model.Adjustment;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

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

	public static AdjustLabelPositionView GetAdjustLabelPositionView() {
		if (alp == null) {
			alp = new AdjustLabelPositionView();
		}
		// 更新标签信息。
		updatePosition();
		return alp;
	}

	private AdjustLabelPositionView() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {

			}

			public void windowLostFocus(WindowEvent e) {
			}
		});
		double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		setBounds((int) ((screenWidth - 400) / 2), (int) ((screenHeight - 250) / 2), 400, 250);
		// 不可改变窗口大小
		setResizable(false);
		// 设置图标
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("/images/Wittur_Logo.gif")));
		// 设置标题
		setTitle("标签调整");
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\u751F\u4EA7\u65E5\u671F\uFF1A");
		lblNewLabel.setFont(new Font("SimSun", Font.PLAIN, 12));
		lblNewLabel.setBounds(45, 70, 84, 15);
		getContentPane().add(lblNewLabel);

		JLabel label = new JLabel("\u4E0A\u8FB9\u8DDD");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("SimSun", Font.PLAIN, 12));
		label.setBounds(140, 30, 65, 15);
		getContentPane().add(label);

		JLabel label_1 = new JLabel("\u5DE6\u8FB9\u8DDD");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("SimSun", Font.PLAIN, 12));
		label_1.setBounds(260, 30, 66, 15);
		getContentPane().add(label_1);

		date_top = new JTextField();
		date_top.setText("0");
		date_top.setHorizontalAlignment(SwingConstants.CENTER);
		date_top.setBounds(139, 67, 66, 21);
		getContentPane().add(date_top);
		date_top.setColumns(10);

		date_left = new JTextField();
		date_left.setText("0");
		date_left.setHorizontalAlignment(SwingConstants.CENTER);
		date_left.setBounds(260, 67, 66, 21);
		getContentPane().add(date_left);
		date_left.setColumns(10);

		JLabel label_2 = new JLabel("\u552F\u4E00\u7F16\u53F7\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 12));
		label_2.setBounds(45, 123, 84, 15);
		getContentPane().add(label_2);

		number_top = new JTextField();
		number_top.setText("0");
		number_top.setHorizontalAlignment(SwingConstants.CENTER);
		number_top.setColumns(10);
		number_top.setBounds(139, 120, 66, 21);
		getContentPane().add(number_top);

		number_left = new JTextField();
		number_left.setText("0");
		number_left.setHorizontalAlignment(SwingConstants.CENTER);
		number_left.setColumns(10);
		number_left.setBounds(260, 120, 66, 21);
		getContentPane().add(number_left);

		JButton button = new JButton("\u63D0\u4EA4");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					String top1 = date_top.getText().toString().isEmpty() ? "0" : date_top.getText().toString();
					String left1 = date_left.getText().toString().isEmpty() ? "0" : date_left.getText().toString();
					String top2 = number_top.getText().toString().isEmpty() ? "0" : number_top.getText().toString();
					String left2 = number_left.getText().toString().isEmpty() ? "0" : number_left.getText().toString();

					SqliteDao sd = new SqliteDao();
					// 提交新的边距
					Adjustment adjustment = new Adjustment();
					adjustment.setName("date");
					adjustment.setLeft(Double.parseDouble(left1));
					adjustment.setTop(Double.parseDouble(top1));
					if (!sd.setPosition(adjustment)) {
						JOptionPane.showMessageDialog(null, "无法更新标签的位置数据！");
						return;
					}
					adjustment.setName("serialNumber");
					adjustment.setLeft(Double.parseDouble(left2));
					adjustment.setTop(Double.parseDouble(top2));
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
		button.setBounds(261, 175, 65, 23);
		getContentPane().add(button);

		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 重置
				date_top.setText("0");
				date_left.setText("0");
				number_top.setText("0");
				number_left.setText("0");
			}
		});
		button_1.setBounds(140, 175, 65, 23);
		getContentPane().add(button_1);

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
		}
	}
}
