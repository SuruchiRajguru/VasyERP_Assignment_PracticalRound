package com.practical.VasyERP.service;

import java.util.List;

import com.practical.VasyERP.entity.Customer;

public interface CustomerService {

	List<Customer> getAllCustomer();
	
	Customer saveCustomer(Customer Customer);
		
	Customer getCustomerById(Integer CustomerId);
	
	boolean deleteCustomer(Integer id);
	
}
