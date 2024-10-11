package com.security.Security_Practice.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.Security_Practice.DAOs.Custome_DAO;
import com.security.Security_Practice.Models.Customer;

@Service
public class CustomerService {
	
	@Autowired
	private Custome_DAO dao;
	
	public List<Customer> findAll(Long Cid)
	{
		return dao.findAll().stream()
                .filter(customer -> customer.getCustId().equals(Cid)) // Ensure you access the correct method
                .collect(Collectors.toList());
	}

}
