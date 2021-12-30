package com.practical.VasyERP.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practical.VasyERP.entity.Product;
import com.practical.VasyERP.repository.ProductRepository;
import com.practical.VasyERP.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProduct() {
		List<Product> products=productRepository.findAll() ;
		return products;
	}

	@Override
	public Product saveProduct(Product product) {
		try
		{
			return productRepository.save(product);
		}
		catch(Exception e)
		{
			return null;
		}	
	}

	@Override
	public Product getProductById(Integer productId) {
		
		return productRepository.findById(productId).get();
	}

	@Override
	public boolean deleteProduct(Integer id) {
		productRepository.deleteById(id);
		return true;
	}

}
