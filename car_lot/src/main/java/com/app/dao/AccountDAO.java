package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.Account;


public interface AccountDAO {

	public int newAccount(Account account) throws BusinessException;
}
