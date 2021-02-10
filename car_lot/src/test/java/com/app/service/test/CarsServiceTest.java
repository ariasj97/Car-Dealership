package com.app.service.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.app.service.CarsServiceImpl;
import com.app.dao.impl.CarsDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Cars;

public class CarsServiceTest {

//	@InjectMocks
//	private static CarsServiceImpl carsService;
//	
//	@Mock
//	private CarsDAOImpl carsDAOImpl;
//	
//	@BeforeClass
//	public static void setup() {
//		carsService = new CarsServiceImpl();
//	}
//	
//	@Before
//	public void beforeSetup() {
//		MockitoAnnotations.openMocks(this);
//	}
//	
//	@Test
//	public void testViewAllCars() {
//		ArrayList<Cars> cars = new ArrayList<>(Arrays.asList(new Cars(123, "Mazda", "3", 2010, 10000.00, true),
//					new Cars(124, "Ford", "Mustang", 2020, 25000.00, true),
//					new Cars(125, "Toyota", "Camry", 2014, 17000.00, true)));
//		
//		try {
//			Mockito.when(carsDAOImpl.viewAllCars()).thenReturn(cars);
//			List<Cars> cars2 = carsService.viewAllCars();
//			
//			for(Cars c :cars2) {
//				Assert.assertNotEquals()
//			}
//		} catch (BusinessException e) {
//			e.printStackTrace();
//		}
	
	private static CarsServiceImpl app;
	
	@Before
	public static void setUp() {
		app = new CarsServiceImpl();
	}
	
	@Test
	public void testNewCar()throws BusinessException {
		Cars car = new Cars(123, "Mazda", "3", 2010, 10000.00, true);
		assertEquals(car,app.newCar( new Cars(123, "Mazda", "3", 2010, 10000.00, true)));
	}
	
	
	
	
	
}
