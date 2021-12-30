package com.practical.VasyERP.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practical.VasyERP.entity.Customer;
import com.practical.VasyERP.entity.Sales;
import com.practical.VasyERP.repository.SalesRepository;
import com.practical.VasyERP.service.SalesService;
@Service
public class SalesServiceImpl implements SalesService{
	
	@Autowired
	private SalesRepository salesRepository;

	@Override
	public List<Sales> getAllSales() {
		List<Sales> sales=salesRepository.findAll() ;
		return sales;

	}

	@Override
	public Sales saveSales(Sales sales) {
		try
		{
			return salesRepository.save(sales);
		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public Sales getSalesById(Integer salesId)
	{
		return salesRepository.findById(salesId).get();
	}

	@Override
	public boolean deleteSales(Integer id) 
	{
		salesRepository.deleteById(id);
		return true;

	}

}
