package com.security.Security_Practice.Security_Configurations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.security.Security_Practice.Services.CustomUserDetailsService;


@Configuration
@EnableWebSecurity
public class SecurityConfig
{


    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception
	{
		  http
          .csrf(csrf -> csrf
              .disable()) // Disable CSRF for simplicity; consider enabling in production
          .authorizeHttpRequests(authz -> authz
              .requestMatchers("/getCustomer/**").permitAll()
              .requestMatchers("/getCustId/**").authenticated()
              .requestMatchers("/contact").hasRole("USER")
              .anyRequest().authenticated() // Secure all other requests
          )
          .formLogin(form -> form
 
              .permitAll() 
          )
          
          .logout(logout -> logout
              .permitAll() 
          )
          .userDetailsService(customUserDetailsService); // Use custom UserDetailsService

	  
		return http.build();
	}
	
//	    @Bean
//	    public UserDetailsService userDetailsService() {
//	        // Create an in-memory user
//	        UserDetails user1 = User.withUsername("sai")
//	                .password(passwordEncoder().encode("sai111")) // Encode password
//	                .roles("USER")
//	                .build();
//
//	        UserDetails user2=User.withUsername("vamsi")
//	        		.password(passwordEncoder().encode("125"))
//	        		.roles("ADMIN")
//	        		.build();
//	        return new InMemoryUserDetailsManager(user1,user2);
//	    }
	

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder(); // Use BCrypt for password encoding
	    }
}
