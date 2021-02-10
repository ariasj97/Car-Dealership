package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.Transaction;

public interface TransactionDAO {

	public int makePayment(Transaction transaction) throws BusinessException;
}
