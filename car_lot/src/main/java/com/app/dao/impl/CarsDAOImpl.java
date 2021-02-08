package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.CarsDAO;
import com.app.exception.BusinessException;
import com.app.model.Cars;
import com.app.dao.dbutil.PostgresqlConnection;

public class CarsDAOImpl implements CarsDAO {

	@Override
	public int newCar(Cars car) throws BusinessException {
		int c = 0;
		
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql ="insert into public.cars(make,model,year,cost,availability) values(?,?,?,?,?)  ";
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setString(1, car.getMake());
			preparedStatement.setString(2, car.getModel());
			preparedStatement.setInt(3,car.getYear() );
			preparedStatement.setDouble(4, car.getCost());
			preparedStatement.setBoolean(5, car.getAvailability());
			
			c= preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("Entered invalid information please try again with valid car infromation");
			throw new BusinessException("internal error occured contact sysadmin");
		}
		
		
		return c;
	}

	@Override
	public List<Cars> viewAllCars() throws BusinessException {
		List<Cars> carList = new ArrayList<>();
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql= "select * from public.cars";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet= preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Cars car = new Cars();
				car.setCar_id(resultSet.getInt("car_id"));
				car.setMake(resultSet.getString("make"));
				car.setModel(resultSet.getString("model"));
				car.setYear(resultSet.getInt("year") );
				car.setCost(resultSet.getDouble("cost"));
				car.setAvailability(resultSet.getBoolean("availability"));
				carList.add(car);
			}
			
			if(carList.size()==0) {
				throw new BusinessException("No cars in the database so far ");
			}
		}catch (SQLException e) {
			System.out.println(e);
			throw new BusinessException("internal error occured contact sysadmin");
		}
		
		return carList;
	}

	@Override
	public int removeCar(int car_id) throws BusinessException {
int c = 0;
		
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql ="delete from public.cars where car_id = ?";
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setInt(1,car_id);
			c= preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println(e);
			throw new BusinessException("internal error occured contact sysadmin");
		}
		
		
		return c;
	}

	@Override
	public List<Cars> viewAvailableCars() throws BusinessException {
		List<Cars> carList = new ArrayList<>();
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql= "select * from public.cars where availability = true";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet= preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Cars car = new Cars();
				car.setCar_id(resultSet.getInt("car_id"));
				car.setMake(resultSet.getString("make"));
				car.setModel(resultSet.getString("model"));
				car.setYear(resultSet.getInt("year") );
				car.setCost(resultSet.getDouble("cost"));
				car.setAvailability(resultSet.getBoolean("availability"));
				carList.add(car);
			}
			
			if(carList.size()==0) {
				throw new BusinessException("No cars in the database so far ");
			}
		}catch (SQLException e) {
			System.out.println(e);
			throw new BusinessException("internal error occured contact sysadmin");
		}
		
		return carList;
	}

}
