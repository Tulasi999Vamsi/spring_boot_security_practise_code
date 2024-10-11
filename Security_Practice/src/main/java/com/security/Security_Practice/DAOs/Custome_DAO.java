package com.security.Security_Practice.DAOs;



import org.springframework.data.jpa.repository.JpaRepository;

import com.security.Security_Practice.Models.Customer;

public interface Custome_DAO extends JpaRepository<Customer,Long>
{

}
