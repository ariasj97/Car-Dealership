package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.Employee;

public interface EmployeeDAO {

	public Employee employeeLogin(int user_id, int account_number)throws BusinessException;
	public int newCustomer(Customer customer)throws BusinessException;
}