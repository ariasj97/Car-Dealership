package com.app.model;

public class Offers {

	private int car_id;
	private int user_id;
	private double offer_made;
	private double asking_price;
	private int years;
	
	public Offers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Offers(int car_id, int user_id, double offer_made, double asking_price, int years) {
		super();
		this.car_id = car_id;
		this.user_id = user_id;
		this.offer_made = offer_made;
		this.asking_price = asking_price;
		this.years = years;
	}

	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public double getOffer_made() {
		return offer_made;
	}

	public void setOffer_made(double offer_made) {
		this.offer_made = offer_made;
	}

	public double getAsking_price() {
		return asking_price;
	}

	public void setAsking_price(double asking_price) {
		this.asking_price = asking_price;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(asking_price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + car_id;
		temp = Double.doubleToLongBits(offer_made);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + user_id;
		result = prime * result + years;
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
		Offers other = (Offers) obj;
		if (Double.doubleToLongBits(asking_price) != Double.doubleToLongBits(other.asking_price))
			return false;
		if (car_id != other.car_id)
			return false;
		if (Double.doubleToLongBits(offer_made) != Double.doubleToLongBits(other.offer_made))
			return false;
		if (user_id != other.user_id)
			return false;
		if (years != other.years)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Offers [car_id=" + car_id + ", user_id=" + user_id + ", offer_made=" + offer_made + ", asking_price="
				+ asking_price + ", years=" + years + "]";
	}
	
	
}
