package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.app.dao.TransactionDAO;
import com.app.dao.dbutil.PostgresqlConnection;
import com.app.exception.BusinessException;


public class TransactionDAOImpl implements TransactionDAO {

	@Override
	public int makePayment(int car_id,double payment_amount, int account_number) throws BusinessException {
		int c = 0;
		int c2 = 0;
		
		try(Connection connection = PostgresqlConnection.getConnection()){
			connection.setAutoCommit(false);
			String sql ="insert into public.transaction(car_id,payment_amount,date,account_number) values(?,?,current_date,?)";
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setInt(1, car_id);
			preparedStatement.setDouble(2, payment_amount);
			preparedStatement.setInt(3, account_number);
		
			c= preparedStatement.executeUpdate();
			if(c!=0) {
				String sql2 ="update public.account set remaining_months=remaining_months-1 where account_number=?";
				PreparedStatement preparedStatement2 =connection.prepareStatement(sql2);
				preparedStatement2.setInt(1, account_number);
				c2= preparedStatement2.executeUpdate();
				
				connection.commit();
				connection.setAutoCommit(true);
			}
		}catch ( SQLException e) {
			System.out.println(e);
			throw new BusinessException("internal error occured contact sysadmin");	
		}	
		return c2;
	}
		
}
