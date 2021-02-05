package com.app.main;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.app.dao.EmployeeDAO;
import com.app.exception.BusinessException;
import com.app.model.Cars;
import com.app.service.CarsServiceImpl;
import com.app.service.EmployeeServiceImpl;


public class LotMain {

	private static final Logger log = LogManager.getFormatterLogger(EmployeeDAO.class);

	public static void main(String[] args) {

		MainFunctions logInMenu = new MainFunctions();

		int choice = logInMenu.logInMenu();
		int employeeChoice = 0;
		int customerChoice = 0;

		MainFunctions logInAsEmployee = new MainFunctions();
		MainFunctions logInAsCustomer = new MainFunctions();
		
		CarsServiceImpl carsService = new CarsServiceImpl();
		Scanner sc = new Scanner(System.in);

		if (choice == 1) {

			while (logInAsEmployee.LogInEmployee() == false) {
				logInAsEmployee.LogInEmployee();
			}

			EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

			do {
				System.out.println("Employee Menu");
				System.out.println("--------------------------------------------");
				System.out.println("1)Add Cars");
				System.out.println("2)View All Cars");
				System.out.println("3)Remove Cars");
				System.out.println("4)View Payments");
				System.out.println("5)Exit");
				try {
					employeeChoice = Integer.parseInt(sc.nextLine());
				} catch (NumberFormatException e) {
				}

				switch (employeeChoice) {
				case 1:
					System.out.println("Enter the new cars details:");
					System.out.println("Car ID: ");
					int car_id = Integer.parseInt(sc.nextLine());
					
					System.out.println("Make: ");
					String make = sc.nextLine();
					
					System.out.println("Model: ");
					String model = sc.nextLine();
					
					System.out.println("Year: ");
					int year = Integer.parseInt(sc.nextLine());
					
					System.out.println("Cost: $");
					double cost = Double.parseDouble(sc.nextLine());
					
					System.out.println("Availability: ");
					boolean availability = sc.nextBoolean();
					
					try {
						Cars cars = new Cars(car_id,make, model,year,cost,availability);
						int valid = carsService.newCar(cars);
						if (valid!=0) {
							System.out.println("New Car added to the lot!");
							System.out.println("");
							break;
						}
					}catch(BusinessException e) {
						System.out.println(e.getMessage());
					}
					
					break;
				case 2:
					System.out.println("Retrieving information on all cars in the lot");
					System.out.println("");
					
					try {
						List<Cars> allCarsList = carsService.viewAllCars();
						if(allCarsList!=null && allCarsList.size()>0) {
							System.out.println("There are "+ allCarsList.size()+" cutomers in this database. Printing thier information now.");
							for(Cars c:allCarsList) {
								System.out.println(c);
							}
							System.out.println("");
						}
					}catch(BusinessException e) {
						System.out.println(e.getMessage());
					}

					break;
				case 3:
					System.out.println("Enter the new cars details:");
					System.out.println("Car ID: ");
					car_id = Integer.parseInt(sc.nextLine());
					
					try {
						int valid = carsService.removeCar(car_id);
						if (valid!=0) {
							System.out.println("Removed car with car ID = " +car_id);
							System.out.println("");
							break;
						}
					}catch(BusinessException e) {
						System.out.println(e.getMessage());
					}
					
					break;
				case 4:
					System.out.println("Option 4 Under Cunstruction");
					break;
				case 5:
					System.out.println("Exiting....Thank you for using jason's  app.");
					break;
				default:
					System.out.println("Invalid menu option. Input a valid menu choice.");
					System.out.println("");
				}

			} while (employeeChoice != 5);

		} else if (choice == 2) {

			while (logInAsCustomer.LogInAsCustomer() == false) {
				logInAsCustomer.LogInAsCustomer();
			}
			do {
				System.out.println("Customer Menu");
				System.out.println("--------------------------------------------");
				System.out.println("1)View Available Cars");
				System.out.println("2)Make An Offer");
				System.out.println("3)View details by customer name");
				System.out.println("4)View transactions by account number");
				System.out.println("5)Exit");
				try {
					customerChoice = Integer.parseInt(sc.nextLine());
				} catch (NumberFormatException e) {}
	
				switch (customerChoice) {
				case 1:
					System.out.println("Option 1 Under Cunstruction");
					break;
				case 2:
					System.out.println("Option 2 Under Cunstruction");
					break;
				case 3:
					System.out.println("Option 3 Under Cunstruction");
					break;
				case 4:
					System.out.println("Option 4 Under Cunstruction");
					break;
				case 5:
					System.out.println("Exiting....Thank you for using jason's  app.");
					break;
				default:
					System.out.println("Invalid menu option. Input a valid menu choice.");
					System.out.println("");
				}

		} while (customerChoice != 5);

	}else if(choice == 3) 
		System.out.println("Exititng app... Thanks  for using Jason's Dealership App!");
		
	}
}
