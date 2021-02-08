package com.app.service;

import com.app.dao.AccountDAO;
import com.app.dao.impl.AccountDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Account;


public class AccountServiceImpl {

	private AccountDAO accountDAO = new AccountDAOImpl();
	
	public int newAccount(Account account) throws BusinessException {
		int valid=0;
		try {
			if(accountDAO.newAccount(account) !=0) {
				valid = 1;
			}
		}catch (BusinessException e) {
			System.out.println(e.getMessage());   
		}
		return valid;
	}
}
