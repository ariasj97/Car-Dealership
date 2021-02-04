package com.app.model;

public class Employee {

	private int employee_id;
	private int account_number;
	
	public Employee() {
		
	}
	
	public Employee(int employee_id,int account_number) {
		super();
		this.account_number = account_number;
		this.employee_id = employee_id;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public int getAccount_number() {
		return account_number;
	}

	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", account_number=" + account_number + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + account_number;
		result = prime * result + employee_id;
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
		Employee other = (Employee) obj;
		if (account_number != other.account_number)
			return false;
		if (employee_id != other.employee_id)
			return false;
		return true;
	}
	
}
