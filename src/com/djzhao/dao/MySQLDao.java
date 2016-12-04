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
 * MySQl数据库操作。
 * 
 * @author djzhao
 * @Date 2016年12月3日 下午4:29:26
 */
public class MySQLDao {
	private QueryRunner queryRunner = MySqlUtils.getQueryRunner();
	private String sql;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * 插入excel信息到数据库。
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
			throw new RuntimeException("打印记录无法存储！");
		}
	}

	/**
	 * 获取唯一序列号。
	 * 
	 * @param num
	 *            当前标签数量
	 * @return 是否获成功（返回值在Constants.SELECTEDLINEINDEX）
	 */
	public boolean getSerialNumber(int num) {
		String today = sdf.format(new Date());
		sql = "select serialNumber from SerialNumber where printDate = ? and lineNameId = ?";
		try {
			Integer count = null;
			count = queryRunner.query(sql, new ScalarHandler<Integer>(), today, Constants.SELECTEDLINEINDEX);
			// 存在记录
			if (count != null) {
				sql = "update SerialNumber set serialNumber = serialNumber + ? where printDate = ? and lineNameId = ?";
				Constants.SERIALNUMBER = count + 1;
				return queryRunner.update(sql, num, today, Constants.SELECTEDLINEINDEX) > 0;
			} else {// 不存在记录
				sql = "insert into SerialNumber (printDate, lineNameId, serialNumber) values(?, ?, ?)";
				// 序列号从1开始
				Constants.SERIALNUMBER = 1;
				return queryRunner.update(sql, today, Constants.SELECTEDLINEINDEX, num) > 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("生产唯一序列号出错！");
		}
	}
}
