package com.example.BillingSystem.Entitys;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

//mapper vonvert the json file into java objects
@Entity
@Table(name = "payments")
public class Payment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Paymentid;

//    @Column(nullable = false)
//    private String paymentMethod;

    public String getTransaction_ID() {
        return Transaction_ID;
    }

    public void setTransaction_ID(String transaction_ID) {
        Transaction_ID = transaction_ID;
    }

    @Column(nullable = false)
    private String Transaction_ID;

    @Column(nullable = false)
    private BigDecimal amount;

//    @ManyToOne
//    @JoinColumn(name = "invoice_id", nullable = false)
//    private Invoice invoice;

    @Column(nullable = false)
    private LocalDateTime paymentDate;

    public Payment() {

    }
//    Invoice invoice,
    public Payment(BigDecimal amount, LocalDateTime paymentDate, String paymentMethod, String transactionId) {
//        this.invoice = invoice;
        this.amount = amount;
        this.paymentDate = paymentDate;
//        this.paymentMethod = paymentMethod;
    }

    public Long getPaymentid() {
        return Paymentid;
    }

    public void setPaymentid(Long paymentid) {
        Paymentid = paymentid;
    }




    // Getters and Setters
    public Long getId() {
        return Paymentid;
    }

    public void setId(Long id) {
        this.Paymentid = id;
    }

//    public Invoice getInvoice() {
//        return invoice;
//    }
//
//    public void setInvoice(Invoice invoice) {
//        this.invoice = invoice;
//    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) { //100
        this.amount = amount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }
//
//    public String getPaymentMethod() {
//        return paymentMethod;
//    }
//
//    public void setPaymentMethod(String paymentMethod) {
//        this.paymentMethod = paymentMethod;
//    }
//
}
