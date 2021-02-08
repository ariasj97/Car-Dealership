package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Cars;

public interface CarsDAO {

	public int newCar(Cars car) throws BusinessException;
	public List<Cars> viewAllCars() throws BusinessException;
	public int removeCar(int car_id) throws BusinessException;
	public List<Cars> viewAvailableCars() throws BusinessException;
}
