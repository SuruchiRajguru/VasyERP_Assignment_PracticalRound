package com.practical.VasyERP.service;

import java.util.List;

import com.practical.VasyERP.entity.Sales;

public interface SalesService {
	List<Sales> getAllSales();
	
	Sales saveSales(Sales sales);
		
	Sales getSalesById(Integer salesId);
	
	boolean deleteSales(Integer id);
	

}
