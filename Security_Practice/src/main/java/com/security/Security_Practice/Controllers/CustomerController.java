package com.security.Security_Practice.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.security.Security_Practice.Models.Customer;
import com.security.Security_Practice.Services.CustomerService;

@RestController
public class CustomerController 
{
	@Autowired
	private CustomerService service;
	
	@GetMapping("/getCustomer/{cid}")
	public List<Customer> findAll(@PathVariable Long cid)
	{
		return service.findAll(cid);
		
	}

}
