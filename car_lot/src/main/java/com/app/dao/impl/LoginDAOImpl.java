package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.app.dao.EmployeeDAO;
import com.app.dao.LoginDAO;
import com.app.dao.dbutil.PostgresqlConnection;
import com.app.dao.impl.LoginDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Login;

public class LoginDAOImpl implements LoginDAO {
	
	private static final Logger log = LogManager.getFormatterLogger(EmployeeDAO.class);

		@Override
		public Login credentialVerification(String username, String password) throws BusinessException {
			Login login = null;
			try(Connection connection = PostgresqlConnection.getConnection()){
				String sql = "select user_id, username,password from public.login where username=? and password=?";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, username);
				preparedStatement.setString(2,password);
				ResultSet resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					login = new Login();
					login.setUser_id(resultSet.getInt("user_id"));
					login.setUsername(username);
					login.setPassword(password);
				}else {
					throw new BusinessException("No combination of inputted username and password found");
				}
			}catch(SQLException e) {
				log.info(e);
				throw new BusinessException("internal error occured contact sysadmin");
			}
			
			return login;
		}

		@Override
		public int newCredentials(Login login) throws BusinessException {
			int l= 0;
			try(Connection connection = PostgresqlConnection.getConnection()){
				String sql ="insert into public.login(username,password) values(?,?) ";
				PreparedStatement preparedStatement =connection.prepareStatement(sql);
				preparedStatement.setString(1, login.getUsername());
				preparedStatement.setString(2, login.getPassword());
				
				
				l= preparedStatement.executeUpdate();
				
				
			} catch ( SQLException e) {
				System.out.println(e);
				throw new BusinessException("internal error occured contact sysadmin");
			}
			return l;
		}
}
