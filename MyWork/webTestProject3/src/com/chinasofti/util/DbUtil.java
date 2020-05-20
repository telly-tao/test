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
	 * 加载驱动，创建连接对象
	 * @return
	 */
	public Connection getConnection() {
		try {
			// 加载驱动类
			Class.forName(DRIVER);
			// 创建连接对象
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			logger.info("Connection to sql Succesd！");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getStackTrace());
		}
		return con;
	}
	
	/**
	 * 查询请求
	 * @param sql
	 * @return 数据集
	 */
	public ResultSet query(String sql) {
		// 连接数据库时，需提供数据库的地址、用户名、密码
		ResultSet rs = null;
		try {
			// 创建连接对象
			con = getConnection();
			// 创建适配器
			stm = con.createStatement();
			// 创建并获取数据集executeQuery执行不做修改的操作，返回数据集，executeUpdate执行对数据有改动的语句，返回受影响的条数。
			rs = stm.executeQuery(sql);
			

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getStackTrace());
		} 
		return rs;
	}
	/**
	 * 预编译查询请求
	 * @param sql
	 * @return 数据集
	 */
	public ResultSet preparedQuery(PreparedStatement preparedStatement) {
		// 连接数据库时，需提供数据库的地址、用户名、密码
		ResultSet rs = null;
		try {
			this.pstm = preparedStatement;
			// 创建并获取数据集executeQuery执行不做修改的操作，返回数据集，executeUpdate执行对数据有改动的语句，返回受影响的条数。
			rs = pstm.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getStackTrace());
		} 
		return rs;
	}
	/**
	 * 关闭查询请求
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
	 * 关闭查询请求
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
	 * 预编译请求更新数据
	 * @param sql
	 * @return
	 */
	public int prepareUpdate(PreparedStatement  prepareStatement) {
		int result=0;
		try {
			this.pstm=prepareStatement;
			//创建并获取数据集executeQuery执行不做修改的操作，返回数据集，executeUpdate执行对数据有改动的语句，返回受影响的条数。
			result=pstm.executeUpdate();
			//提交事务
			con.commit();

		}catch (Exception e) {
			try {
				//回滚事务
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
	 * 请求更新数据库
	 * @param sql
	 * @return
	 */
	public int update(String sql) {
		int result=0;
		try {
			//创建连接对象
			con =getConnection();
			//设置非自动提交
			con.setAutoCommit(false);
			//创建适配器
			stm=con.createStatement();
			//创建并获取数据集executeQuery执行不做修改的操作，返回数据集，executeUpdate执行对数据有改动的语句，返回受影响的条数。
			result=stm.executeUpdate(sql);
			//提交事务
			con.commit();

		}catch (Exception e) {
			try {
				//回滚事务
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
	 * 关闭适配器
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
	 * 关闭预编译适配器
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
	 * 关闭连接
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
