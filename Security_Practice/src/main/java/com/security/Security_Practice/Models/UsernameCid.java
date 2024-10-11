
package com.security.Security_Practice.Models;

import jakarta.persistence.*;
	
@Entity
@Table(name = "username_cid")
public class UsernameCid {

    @Id
    @Column(name = "username")
    private String username; // Username as the primary key

    @Column(name = "custId", nullable = false)
    private Long custId; // Foreign key referencing customers table

    // Bidirectional relationship with Customer
    @OneToOne
    @JoinColumn(name = "custId", referencedColumnName = "cust_id", insertable = false, updatable = false)
    private Customer customer; // Reference to Customer

    // Constructors
    public UsernameCid() {}

    public UsernameCid(String username, Long custId) {
        this.username = username;
        this.custId = custId;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
