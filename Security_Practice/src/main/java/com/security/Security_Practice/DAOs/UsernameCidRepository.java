package com.security.Security_Practice.DAOs;
import com.security.Security_Practice.Models.UsernameCid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsernameCidRepository extends JpaRepository<UsernameCid, String> {
    // Custom query methods can be defined here if needed
	
	 @Query("SELECT uc.custId FROM UsernameCid uc WHERE uc.username = :username")
	 Long findCustIdByUsername(String username);
}

