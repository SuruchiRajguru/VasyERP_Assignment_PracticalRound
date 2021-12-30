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
import com.practical.VasyERP.service.ProductService;


@RestController
@RequestMapping("/vasyerp")
@CrossOrigin(origins="*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/listProduct")
	public List<Product> listProduct()
	{
		return productService.getAllProduct();	
	}
	
	@PostMapping("/saveProduct")
	public  void saveProduct(@RequestBody Product product)
	{
		productService.saveProduct(product);
	}
	
	@GetMapping("/getProductById/{id}")
	public ResponseEntity<Product> getProductID(@PathVariable Integer id)
	{
		try
		{
			Product product=productService.getProductById(id);
			return new ResponseEntity<Product>(product,HttpStatus.OK) ;
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND) ;
		}
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public void deleteProduct(@PathVariable Integer id)
	{
		productService.deleteProduct(id);
	}
	
}
