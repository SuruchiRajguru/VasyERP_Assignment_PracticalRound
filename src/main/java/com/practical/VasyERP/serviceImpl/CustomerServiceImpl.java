package com.practical.VasyERP.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practical.VasyERP.entity.Customer;
import com.practical.VasyERP.entity.Product;
import com.practical.VasyERP.repository.CustomerRepository;
import com.practical.VasyERP.repository.ProductRepository;
import com.practical.VasyERP.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> customer=customerRepository.findAll() ;
		return customer;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		try
		{
			return customerRepository.save(customer);
		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public Customer getCustomerById(Integer customerId)
	{
		return customerRepository.findById(customerId).get();
	}

	@Override
	public boolean deleteCustomer(Integer id) {
		customerRepository.deleteById(id);
		return true;

	}
	

}
