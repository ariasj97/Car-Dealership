package com.app.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.app.dao.EmployeeDAO;
import com.app.dao.LoginDAO;
import com.app.dao.impl.LoginDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Login;
import com.app.service.LoginServiceImpl;

public class LoginServiceImpl  {

	private static final Logger log = LogManager.getFormatterLogger(EmployeeDAO.class);
	private LoginDAO loginDAO = new LoginDAOImpl();
	
	
	public Login credentialVerification(String username, String password) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int newCredentials(Login login) throws BusinessException {
		int valid=0;
		try {
			if(loginDAO.newCredentials(login) !=0) {
				valid = 1;
			}
		}catch (BusinessException e) {
			log.info(e.getMessage());
		}
		return valid;
	}

}