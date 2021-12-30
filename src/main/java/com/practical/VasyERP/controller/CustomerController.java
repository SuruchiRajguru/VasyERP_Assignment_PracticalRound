package com.practical.VasyERP.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practical.VasyERP.entity.Customer;
import com.practical.VasyERP.entity.Product;
import com.practical.VasyERP.entity.Sales;
import com.practical.VasyERP.service.CustomerService;
import com.practical.VasyERP.service.ProductService;
import com.practical.VasyERP.service.SalesService;

@RestController
@RequestMapping("/vasyerp")
@CrossOrigin(origins="*")

public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/listCustomer")
	public List<Customer> listCustomer()
	{
		return customerService.getAllCustomer();	
	}
	
	@PostMapping("/saveCustomer")
	public  void saveCustomer(@RequestBody Customer customer)
	{
		customerService.saveCustomer(customer);
	}
	
	@GetMapping("/getCustomerById/{id}")
	public ResponseEntity<Customer> getCustomerID(@PathVariable Integer id)
	{
		try
		{
			Customer customer=customerService.getCustomerById(id);
			return new ResponseEntity<Customer>(customer,HttpStatus.OK) ;
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND) ;
		}
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public void deleteCustomer(@PathVariable Integer id)
	{
		customerService.deleteCustomer(id);
	}

}
