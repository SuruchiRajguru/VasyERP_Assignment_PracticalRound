package com.practical.VasyERP.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.practical.VasyERP.entity.Customer;



public interface CustomerRepository extends JpaRepository<Customer,Integer>{

}
