package com.security.Security_Practice.Services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.Security_Practice.DAOs.UsernameCidRepository;


@Service
public class UsernameCidService {

    @Autowired
    private UsernameCidRepository usernameCidRepository;

    public Long getCustIdByUsername(String username) {
        return usernameCidRepository.findCustIdByUsername(username);
    }
}
