package com.djzhao.dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.djzhao.db.MySqlUtils;
import com.djzhao.model.PrintInfo;
import com.djzhao.utils.Constants;

/**
 * MySQl���ݿ������
 * 
 * @author djzhao
 * @Date 2016��12��3�� ����4:29:26
 */
public class MySQLDao {
	private QueryRunner queryRunner = MySqlUtils.getQueryRunner();
	private String sql;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * ����excel��Ϣ�����ݿ⡣
	 * 
	 * @param e
	 * @return
	 */
	public boolean insertPrintInfo(PrintInfo e) {
		sql = "insert into hasprintedrecords (lineName, classes, productDate, salesNo, salesRow, serialNumber) values(?, ?, ?, ?, ?, ?)";
		try {
			return queryRunner.update(sql, e.getLineName(), e.getClasses(), e.getProductDate(), e.getSalesNo(),
					e.getSalesRow(), e.getSerialNumber()) > 0;
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new RuntimeException("��ӡ��¼�޷��洢��");
		}
	}

	/**
	 * ��ȡΨһ���кš�
	 * 
	 * @param num
	 *            ��ǰ��ǩ����
	 * @return �Ƿ��ɹ�������ֵ��Constants.SELECTEDLINEINDEX��
	 */
	public boolean getSerialNumber(int num) {
		String today = sdf.format(new Date());
		sql = "select serialNumber from SerialNumber where printDate = ? and lineNameId = ?";
		try {
			Integer count = null;
			count = queryRunner.query(sql, new ScalarHandler<Integer>(), today, Constants.SELECTEDLINEINDEX);
			// ���ڼ�¼
			if (count != null) {
				sql = "update SerialNumber set serialNumber = serialNumber + ? where printDate = ? and lineNameId = ?";
				Constants.SERIALNUMBER = count + 1;
				return queryRunner.update(sql, num, today, Constants.SELECTEDLINEINDEX) > 0;
			} else {// �����ڼ�¼
				sql = "insert into SerialNumber (printDate, lineNameId, serialNumber) values(?, ?, ?)";
				// ���кŴ�1��ʼ
				Constants.SERIALNUMBER = 1;
				return queryRunner.update(sql, today, Constants.SELECTEDLINEINDEX, num) > 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("����Ψһ���кų���");
		}
	}
}
