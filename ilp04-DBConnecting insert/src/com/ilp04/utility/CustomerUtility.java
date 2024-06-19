package com.ilp04.utility;

import java.util.ArrayList;

import java.util.Scanner;

import com.ilp04.entity.Customer;
import com.ilp04.service.CustomerService;
import com.ilp04.service.CustomerServiceImp;

public class CustomerUtility {

	public static void main(String[] args) {
		int choice;
		char goToMenu;
        do {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select option to continue..");
		System.out.println("1.Get customer details   2.Insert data   3.Update data");
		choice = scanner.nextInt();
		switch(choice) {
		case 1:
			System.out.println("");
			getAllCustomers();
			break;
		case 2:
			System.out.println("");
			insertIntoCustomer();
			break;
		case 3:
			System.out.println("");
			updateCustomer();
			break;
		default:
            System.out.println("Invalid choice");
		}
		System.out.println("Go to main menu (y/n)");
        goToMenu = scanner.next().charAt(0);
        scanner.nextLine();
    } while (goToMenu == 'Y' || goToMenu == 'y');
		
}

	private static void updateCustomer() {
		CustomerService customerService = new CustomerServiceImp();
		System.out.println("Enter the Customer Code to update any fields");
		Scanner scanner = new Scanner(System.in);
		int customerCode=scanner.nextInt();
		System.out.println("Enter the field to update");
		System.out.println("1.Customer first name 2.Customer last name 3.Address 4.Phone number 5.Aadhaar");
		int field=scanner.nextInt();
		switch(field) {
			case 1:
				System.out.println("Enter customer first name:");
				scanner.nextLine();
				String customerFirstName=scanner.nextLine();
				customerService.updateCustomer(customerCode,"customer_firstname",customerFirstName);
				break;
			case 2:
				System.out.println("Enter customer last name:");
				scanner.nextLine();
				String customerLastName=scanner.nextLine();
				customerService.updateCustomer(customerCode,"customer_lastname",customerLastName);
				break;
			case 3:
				System.out.println("Enter address:");
				scanner.nextLine();
				String address=scanner.nextLine();
				customerService.updateCustomer(customerCode,"address",address);
				break;
			case 4:
				System.out.println("Enter phone number:");
				long phonenumber=scanner.nextLong();
				customerService.updateCustomer(customerCode,"phonenumber",phonenumber);
				break;
			case 5:
				System.out.println("Enter Aadhaar number:");
				long aadhaarno=scanner.nextLong();
				customerService.updateCustomer(customerCode,"aadhaarno",aadhaarno);
				break;
			default:
	            System.out.println("Invalid choice");
		}
	}

	private static void insertIntoCustomer() {
		CustomerService customerService = new CustomerServiceImp();
		System.out.println("Enter the customer first name");
		Scanner scanner = new Scanner(System.in);
		String customerFirstName=scanner.nextLine();
		System.out.println("Enter the customer last name");
		String customerLastName=scanner.nextLine();
		System.out.println("Enter the customer address");
		String address=scanner.nextLine();
		System.out.println("Enter the customer phone number");
		long phoneNumber=scanner.nextLong();
		System.out.println("Enter the Aadhaar");
		long aadhaar=scanner.nextLong();
		Customer customer = new Customer(customerFirstName,customerLastName,address,phoneNumber,aadhaar);
		customerService.insertIntoCustomer(customer);
		
		
		
	}

	private static void getAllCustomers() {
		CustomerService customerService = new CustomerServiceImp();
		ArrayList<Customer> customerList = customerService.getAllCustomers();
		//print details of customerList
		System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%n", "Customer Code", "First Name", "Last Name", "Address", "Phone Number", "Aadhaar No");
        for (Customer customer : customerList) {
            System.out.printf("%-15d%-15s%-15s%-15s%-15d%-15d%n",
                    customer.getCustomercode(),
                    customer.getCustomer_firstname(),
                    customer.getCustomer_lastname(),
                    customer.getAddress(),
                    customer.getPhonenumber(),
                    customer.getAadhaarno());
        }
	}
}
