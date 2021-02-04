package com.app.main;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.service.EmployeeService;
import com.app.service.impl.EmployeeServiceImpl;

public class LotMain {

	private static Logger log = Logger.getLogger(LotMain.class);

	public static void main(String[] args) {

		MainFunctions logInMenu = new MainFunctions();

		int choice = logInMenu.logInMenu();
		int employeeChoice= 0;

		MainFunctions logInAsEmployee = new MainFunctions();
		MainFunctions logInAsCustomer = new MainFunctions();
		Scanner sc = new Scanner(System.in);

		if (choice == 1) {

			while (logInAsEmployee.LogInEmployee() == false) {
				logInAsEmployee.LogInEmployee();
			}
			
			EmployeeService employeeService = new EmployeeServiceImpl();
			
			do {
				log.info("Employee Menu");
				log.info("--------------------------------------------");
				log.info("1)New Customer Menu");
				log.info("2)View all customer details");
				log.info("3)View details by customer name");
				log.info("4)View transactions by account number");
				log.info("5)Exit");
				try {
					employeeChoice = Integer.parseInt(sc.nextLine());
				}catch(NumberFormatException e) {}
				
				switch(employeeChoice) {
				case 1:
					log.info("Option 1 Under Cunstruction");
					break;
				case 2:
					log.info("Option 2 Under Cunstruction");
					break;
				case 3:
					log.info("Option 3 Under Cunstruction");
					break;
				case 4:
					log.info("Option 4 Under Cunstruction");
					break;
				case 5:
					log.info("Exiting....Thank you for using jason's  app.");
					break;
				default:
					log.info("Invalid menu option. Input a valid menu choice.");
					log.info("");
				}
				
			}while(employeeChoice !=5);
			
		} else if (choice == 2) {
			

			while (logInAsCustomer.LogInAsCustomer() == false)
				logInAsCustomer.LogInAsCustomer();
		}
		
	}

}
