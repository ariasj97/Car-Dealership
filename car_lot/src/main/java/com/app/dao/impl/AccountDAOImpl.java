package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.app.dao.AccountDAO;
import com.app.dao.dbutil.PostgresqlConnection;
import com.app.exception.BusinessException;
import com.app.model.Account;

public class AccountDAOImpl implements AccountDAO{

	@Override
	public int newAccount(Account account) throws BusinessException {
		int l= 0;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql ="insert into public.account(user_id) values(?) ";
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setInt(1, account.getUser_id());
		
			
			
			l= preparedStatement.executeUpdate();
			
			
		} catch ( SQLException e) {
			System.out.println(e);
			throw new BusinessException("internal error occured contact sysadmin");
		}
		return l;
	}

}
