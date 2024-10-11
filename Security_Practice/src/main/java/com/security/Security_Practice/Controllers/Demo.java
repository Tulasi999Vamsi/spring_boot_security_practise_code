package com.security.Security_Practice.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo 
{
	@GetMapping("/home")
	public String home()
	{
		return "Welcome to home page";
	}
	
	@GetMapping("/balance")
	public String   balance()
	{
		return "your balance is 4000rs";
	}
	
	@GetMapping("/contact")
	public String contactUs()
	{
		return "We will call you soon...";
	}
}