package com.security.Security_Practice.Controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.security.Security_Practice.Models.Customer;
import com.security.Security_Practice.Services.CustomerService;
import com.security.Security_Practice.Services.UsernameCidService;

@RestController
public class UsernameCidController {

    @Autowired
    private UsernameCidService usernameCidService;
    
    @Autowired
    private CustomerService customServ;

    @GetMapping("/getCustId")
    public List<Customer> getCustId() {
    	 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	 String username = authentication.getName(); 
        Long custId = usernameCidService.getCustIdByUsername(username);
        if (custId != null) {
            return customServ.findAll(custId);
        } else {
            throw new RuntimeException("Username not found: " + username);
        }
    }
}
