package com.chinasofti.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface IDbUtil {
	public Connection getConnection();
	
	public ResultSet query(String sql);
	
	public void closeQurey();
	
	public ResultSet preparedQuery(PreparedStatement preparedStatement);
	
	public void closePreparedQurey();
	
	public int prepareUpdate(PreparedStatement  prepareStatement);
	
	public int update(String sql);

}
