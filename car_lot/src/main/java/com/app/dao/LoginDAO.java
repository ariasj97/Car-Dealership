package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.Login;

public interface LoginDAO {
	
		public Login credentialVerification(String username,String password) throws BusinessException;
		public int newCredentials(Login login)throws BusinessException;
	}

