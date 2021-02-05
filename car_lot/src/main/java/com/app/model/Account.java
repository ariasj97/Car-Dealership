package com.app.model;

public class Account {

	private int user_id;
	private int account_num;
	private int remaining_months;
	private double monthly_rate;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int user_id, int account_num, int remaining_months, double monthly_rate) {
		super();
		this.user_id = user_id;
		this.account_num = account_num;
		this.remaining_months = remaining_months;
		this.monthly_rate = monthly_rate;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getAccount_num() {
		return account_num;
	}

	public void setAccount_num(int account_num) {
		this.account_num = account_num;
	}

	public int getRemaining_months() {
		return remaining_months;
	}

	public void setRemaining_months(int remaining_months) {
		this.remaining_months = remaining_months;
	}

	public double getMonthly_rate() {
		return monthly_rate;
	}

	public void setMonthly_rate(double monthly_rate) {
		this.monthly_rate = monthly_rate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + account_num;
		long temp;
		temp = Double.doubleToLongBits(monthly_rate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + remaining_months;
		result = prime * result + user_id;
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
		Account other = (Account) obj;
		if (account_num != other.account_num)
			return false;
		if (Double.doubleToLongBits(monthly_rate) != Double.doubleToLongBits(other.monthly_rate))
			return false;
		if (remaining_months != other.remaining_months)
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [user_id=" + user_id + ", account_num=" + account_num + ", remaining_months=" + remaining_months
				+ ", monthly_rate=" + monthly_rate + "]";
	}
	
	
}
