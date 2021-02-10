package com.app.service;

import com.app.dao.TransactionDAO;
import com.app.dao.impl.TransactionDAOImpl;
import com.app.exception.BusinessException;


public class TransactionServiceImpl {

	private TransactionDAO transactionDAO = new TransactionDAOImpl();
	
	public int makePayment(int car_id,double payment_amount, int account_number) throws BusinessException{
		int valid = 0;
		try {
			if(transactionDAO.makePayment( car_id, payment_amount,  account_number) != 0) {
				valid = 1;
			}
		}catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		return valid;
	}
}
