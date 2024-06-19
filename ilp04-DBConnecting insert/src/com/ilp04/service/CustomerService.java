package com.ilp04.service;

import java.util.ArrayList;

import com.ilp04.entity.Customer;

public interface CustomerService {
	public ArrayList<Customer> getAllCustomers();
	public int insertIntoCustomer(Customer customer);
	public int updateCustomer(int customercode, String fieldName, Object newValue);
}