package com.app.model;

import java.sql.Date;

public class Transaction {

	private int car_id;
	private double payment_amount;
	private Date date;
	private int account_number;
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Transaction(int car_id, double payment_amount, Date date, int account_number) {
		super();
		this.car_id = car_id;
		this.payment_amount = payment_amount;
		this.date = date;
		this.account_number = account_number;
	}
	
	public int getAccount_number() {
		return account_number;
	}



	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}



	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public double getPayment_amount() {
		return payment_amount;
	}

	public void setPayment_amount(double payment_amount) {
		this.payment_amount = payment_amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + account_number;
		result = prime * result + car_id;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		long temp;
		temp = Double.doubleToLongBits(payment_amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (account_number != other.account_number)
			return false;
		if (car_id != other.car_id)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (Double.doubleToLongBits(payment_amount) != Double.doubleToLongBits(other.payment_amount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [car_id=" + car_id + ", payment_amount=" + payment_amount + ", date=" + date
				+ ", account_number=" + account_number + "]";
	}
	
	
	
}
