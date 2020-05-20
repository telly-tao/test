package com.chinasofti.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class DbUtil implements IDbUtil {
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/db_test?useUnicode=true&characterEncoding=UTF8";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static Logger logger=Logger.getLogger(DbUtil.class);
	private Connection con = null;
	private Statement stm = null;
	private PreparedStatement pstm=null;
	/**
	 * �����������������Ӷ���
	 * @return
	 */
	public Connection getConnection() {
		try {
			// ����������
			Class.forName(DRIVER);
			// �������Ӷ���
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			logger.info("Connection to sql Succesd��");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getStackTrace());
		}
		return con;
	}
	
	/**
	 * ��ѯ����
	 * @param sql
	 * @return ���ݼ�
	 */
	public ResultSet query(String sql) {
		// �������ݿ�ʱ�����ṩ���ݿ�ĵ�ַ���û���������
		ResultSet rs = null;
		try {
			// �������Ӷ���
			con = getConnection();
			// ����������
			stm = con.createStatement();
			// ��������ȡ���ݼ�executeQueryִ�в����޸ĵĲ������������ݼ���executeUpdateִ�ж������иĶ�����䣬������Ӱ���������
			rs = stm.executeQuery(sql);
			

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getStackTrace());
		} 
		return rs;
	}
	/**
	 * Ԥ�����ѯ����
	 * @param sql
	 * @return ���ݼ�
	 */
	public ResultSet preparedQuery(PreparedStatement preparedStatement) {
		// �������ݿ�ʱ�����ṩ���ݿ�ĵ�ַ���û���������
		ResultSet rs = null;
		try {
			this.pstm = preparedStatement;
			// ��������ȡ���ݼ�executeQueryִ�в����޸ĵĲ������������ݼ���executeUpdateִ�ж������иĶ�����䣬������Ӱ���������
			rs = pstm.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getStackTrace());
		} 
		return rs;
	}
	/**
	 * �رղ�ѯ����
	 */
	public void closeQurey() {
		try {
			stm.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getStackTrace());
		}
	}
	/**
	 * �رղ�ѯ����
	 */
	public void closePreparedQurey() {
		try {
			pstm.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getStackTrace());
		}
	}
	/**
	 * Ԥ���������������
	 * @param sql
	 * @return
	 */
	public int prepareUpdate(PreparedStatement  prepareStatement) {
		int result=0;
		try {
			this.pstm=prepareStatement;
			//��������ȡ���ݼ�executeQueryִ�в����޸ĵĲ������������ݼ���executeUpdateִ�ж������иĶ�����䣬������Ӱ���������
			result=pstm.executeUpdate();
			//�ύ����
			con.commit();

		}catch (Exception e) {
			try {
				//�ع�����
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				logger.error(e1.getStackTrace());
			}
			e.printStackTrace();
			logger.error(e.getStackTrace());

		}
		finally {
			closeStatement(pstm);
			closeConnection(con);
		}
		return result;
	}
	/**
	 * ����������ݿ�
	 * @param sql
	 * @return
	 */
	public int update(String sql) {
		int result=0;
		try {
			//�������Ӷ���
			con =getConnection();
			//���÷��Զ��ύ
			con.setAutoCommit(false);
			//����������
			stm=con.createStatement();
			//��������ȡ���ݼ�executeQueryִ�в����޸ĵĲ������������ݼ���executeUpdateִ�ж������иĶ�����䣬������Ӱ���������
			result=stm.executeUpdate(sql);
			//�ύ����
			con.commit();

		}catch (Exception e) {
			try {
				//�ع�����
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				logger.error(e1.getStackTrace());
			}
			e.printStackTrace();
			logger.error(e.getStackTrace());

		}
		finally {
			closeStatement(stm);
			closeConnection(con);
		}
		return result;
	}
	/**
	 * �ر�������
	 * @param s
	 */
	private void closeStatement(Statement smt) {
		try {
			smt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getStackTrace());
		}
	}
	/**
	 * �ر�Ԥ����������
	 * @param s
	 */
	private void closeStatement(PreparedStatement smt) {
		try {
			smt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getStackTrace());
		}
	}
	/**
	 * �ر�����
	 * @param c
	 */
	private void closeConnection(Connection c) {
		try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getStackTrace());
		}
	}
}
