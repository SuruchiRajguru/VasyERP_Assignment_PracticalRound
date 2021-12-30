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

import com.practical.VasyERP.entity.Product;
import com.practical.VasyERP.entity.Sales;
import com.practical.VasyERP.service.ProductService;
import com.practical.VasyERP.service.SalesService;

@RestController
@RequestMapping("/vasyerp")
@CrossOrigin(origins="*")

public class SalesController {
	@Autowired
	private SalesService salesService;
	
	@GetMapping("/listSales")
	public List<Sales> listSales()
	{
		return salesService.getAllSales();	
	}
	
	@PostMapping("/saveSales")
	public  void saveSales(@RequestBody Sales sales)
	{
		salesService.saveSales(sales);
	}
	
	@GetMapping("/getSalesById/{id}")
	public ResponseEntity<Sales> getSalesID(@PathVariable Integer id)
	{
		try
		{
			Sales sales=salesService.getSalesById(id);
			return new ResponseEntity<Sales>(sales,HttpStatus.OK) ;
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<Sales>(HttpStatus.NOT_FOUND) ;
		}
	}
	
	@DeleteMapping("/deleteSales/{id}")
	public void deleteSales(@PathVariable Integer id)
	{
		salesService.deleteSales(id);
	}



}
