package com.example.BillingSystem.Entitys;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Customer {


    @Id
    @GeneratedValue
    private Long id;

    private String fullname;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phonenumber;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name ="user_id",
            nullable = false
    )
    private User user;

    @OneToMany(
            mappedBy = "customer" ,
            cascade = CascadeType.ALL
    )
    private List<Invoice> invoices;

    @OneToMany(
            mappedBy = "customer" ,
            cascade = CascadeType.ALL
    )
    private List<InvoiceItem> invoiceItems;


    public Customer() {
    }



    public Customer(Long id, String fullname, String email, String phonenumber, String address, LocalDateTime created_at, LocalDateTime updated_at, User user,List<Invoice> invoices) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.user = user;
        this.invoices = invoices;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    @PrePersist
    protected void onCreate() {
        created_at = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updated_at = LocalDateTime.now();
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }
}
