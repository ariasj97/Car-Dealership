package com.app.service.impl;

import org.apache.log4j.Logger;

import com.app.dao.LoginDAO;
import com.app.dao.impl.LoginDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Login;
import com.app.service.LoginService;
import com.app.service.impl.LoginServiceImpl;

public class LoginServiceImpl implements LoginService {

	private static Logger log = Logger.getLogger(LoginServiceImpl.class);
	private LoginDAO loginDAO = new LoginDAOImpl();
	
	@Override
	public Login credentialVerification(String username, String password) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
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