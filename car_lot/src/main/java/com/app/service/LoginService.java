package com.app.service;

import com.app.exception.BusinessException;
import com.app.model.Login;

public interface LoginService {
	public Login credentialVerification(String username,String password) throws BusinessException;
	public int newCredentials(Login login)throws BusinessException;
}
