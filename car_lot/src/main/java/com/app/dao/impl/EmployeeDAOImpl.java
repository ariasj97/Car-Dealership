package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.app.dao.EmployeeDAO;
import com.app.dao.dbutil.PostgresqlConnection;
import com.app.dao.impl.EmployeeDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Employee;


public class EmployeeDAOImpl implements EmployeeDAO{
	
	private static final Logger log = LogManager.getFormatterLogger(EmployeeDAO.class);
		
		
		@Override
		public Employee employeeLogin(int user_id, int account_number)throws BusinessException{
			Employee employee = null;
			try(Connection connection = PostgresqlConnection.getConnection()){
				String sql = "select user_id, account_number from public.employee where user_id=? and account_number=?";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, user_id);
				preparedStatement.setInt(2,account_number);
				ResultSet resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					employee = new Employee();
					employee.setEmployee_id(user_id);
					employee.setAccount_number(account_number);
					
				}else {
					throw new BusinessException("No combination of inputted user id and account number found");
					
				}
			}catch( SQLException e) {
				log.info(e);
				throw new BusinessException("internal error occured contact sysadmin");
			}
				
			return employee;
		}

}
