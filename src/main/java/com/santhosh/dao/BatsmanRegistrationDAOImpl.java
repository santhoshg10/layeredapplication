package com.santhosh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.santhosh.bo.BatsmanBO;

public class BatsmanRegistrationDAOImpl implements BatsmanRegistrationDAO
{
	private static final String BATSMAN_DETAILS_INSERT="insert into BATSMAN_DETAILS values(?,?,?,?,?,?)";
	private DataSource datasource;
	public BatsmanRegistrationDAOImpl(DataSource datasource)
	{
		this.datasource=datasource;
	}
	@Override
	public int insertBatsman(BatsmanBO bo) throws Exception 
	{
		int count=0;
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		connection=datasource.getConnection();
		preparedStatement=connection.prepareStatement(BATSMAN_DETAILS_INSERT);
		preparedStatement.setInt(1, bo.getBatsmanId());
		preparedStatement.setString(2, bo.getName());
		preparedStatement.setInt(3, bo.getAge());
		preparedStatement.setInt(4, bo.getRunsScored());
		preparedStatement.setInt(5, bo.getNoOfInnings());
		preparedStatement.setInt(6, bo.getNotOuts());
		count=preparedStatement.executeUpdate();	
		return count;
	}

}
