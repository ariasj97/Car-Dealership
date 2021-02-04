package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.dao.EmployeeDAO;
import com.app.dao.dbutil.PostgresqlConnection;
import com.app.dao.impl.EmployeeDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO{
	
		private static Logger log = Logger.getLogger(EmployeeDAOImpl.class);
		
		@Override
		public int newCustomer(Customer customer)throws BusinessException {
			int c= 0;
			try(Connection connection = PostgresqlConnection.getConnection()){
				String sql ="insert into public.customer(user_id,name,street_address,dob,credit_score) values(?,?,?,?,?)  ";
				PreparedStatement preparedStatement =connection.prepareStatement(sql);
				preparedStatement.setInt(1,customer.getCustomer_id());
				preparedStatement.setString(2, customer.getName());
				preparedStatement.setString(3, customer.getStreet_address());
				preparedStatement.setDate(4, new java.sql.Date(customer.getDob().getTime()));
				preparedStatement.setInt(5, customer.getCredit_score());
				
				c= preparedStatement.executeUpdate();
				
				
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println(e);
				throw new BusinessException("internal error occured contact sysadmin");
			}
			return c;
		}

		
		
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
			}catch(ClassNotFoundException | SQLException e) {
				log.info(e);
				throw new BusinessException("internal error occured contact sysadmin");
			}
				
			return employee;
		}

}