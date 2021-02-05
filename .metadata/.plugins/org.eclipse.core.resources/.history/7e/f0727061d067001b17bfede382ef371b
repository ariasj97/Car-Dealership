package com.app.service.impl;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.service.EmployeeService;
import com.app.dao.EmployeeDAO;
import com.app.dao.impl.EmployeeDAOImpl;
import com.app.service.impl.EmployeeServiceImpl;

public class EmployeeServiceImpl implements EmployeeService {

	private static Logger log = Logger.getLogger(EmployeeServiceImpl.class);
	Scanner sc = new Scanner (System.in);
	
	private EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	

	@Override
	public int newCustomer(Customer customer) throws BusinessException {
		int valid=0;
		try {
			if(employeeDAO.newCustomer(customer) !=0) {
				valid = 1;
			}
		}catch (BusinessException e) {
			log.info(e.getMessage());
		}
		return valid;
	}
}
