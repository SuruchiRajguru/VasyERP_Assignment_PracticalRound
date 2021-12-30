package com.practical.VasyERP.service;

import java.util.List;

import com.practical.VasyERP.entity.Product;



public interface ProductService {
	
	List<Product> getAllProduct();
		
	Product saveProduct(Product product);
		
	Product getProductById(Integer productId);
	
	boolean deleteProduct(Integer id);
	

}
