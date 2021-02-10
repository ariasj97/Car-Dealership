package com.app.dao;

import com.app.exception.BusinessException;


public interface TransactionDAO {

	public int makePayment(int car_id,double payment_amount, int account_number) throws BusinessException;
}
