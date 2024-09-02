package com.example.BillingSystem.Entitys;

import jakarta.persistence.*;

@Entity
@Table(name ="User_account")
public class User {


    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @OneToOne(
            mappedBy = "user"
    )
    private Customer customer;

    public User() {
    }

    public User(Long id, String username, String password, Customer customer) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
