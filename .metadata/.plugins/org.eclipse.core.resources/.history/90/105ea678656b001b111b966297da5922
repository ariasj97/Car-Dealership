package com.app.service;

import com.app.dao.TransactionDAO;
import com.app.dao.impl.TransactionDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Transaction;

public class TransactionServiceImpl {

	private TransactionDAO transactionDAO = new TransactionDAOImpl();
	
	int makePayment(Transaction transaction) throws BusinessException{
		int valid = 0;
		try {
			if(transactionDAO.makePayment(transaction) != 0) {
				valid = 1;
			}
		}catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		return valid;
	}
}
