package com.example.BillingSystem.Entitys;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name ="Balance")
public class Balance {


    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private BigDecimal current_balance;

//    private LocalDateTime created_at;
//    private LocalDateTime updated_at;

    public Balance() {

    }

    public Balance(Long id, Customer customer, BigDecimal current_balance, LocalDateTime created_at, LocalDateTime updated_at) {
        this.id = id;
        this.customer = customer;
        this.current_balance = current_balance;
//        this.created_at = created_at;
//        this.updated_at = updated_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getCurrent_balance() {
        return current_balance;
    }

    public void setCurrent_balance(BigDecimal current_balance) {
        this.current_balance = current_balance;
    }


}
