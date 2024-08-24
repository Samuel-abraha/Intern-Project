package com.example.BillingSystem.Entitys;

import com.example.BillingSystem.Service.BillingService;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Invoice {

    @Id
    @GeneratedValue
    private Long invoiceId;

    private LocalDate invoiceDate;
    private BigDecimal totalAmount = BigDecimal.ZERO;
    private LocalDate billingPeriod;

    @ManyToOne
    @JoinColumn(
            name = "customer_id",
            nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(
            name = "service_id",
            nullable = false
    )
    private BillingService billingService;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
    private List<InvoiceItem> invoiceItem;

    public Invoice() {
    }

    public Invoice(Long invoiceId, LocalDate invoiceDate, BigDecimal totalAmount, LocalDate billingPeriod, Customer customer, BillingService billingService, List<InvoiceItem> invoiceItem) {
        this.invoiceId = invoiceId;
        this.invoiceDate = invoiceDate;
        this.totalAmount = totalAmount;
        this.billingPeriod = billingPeriod;
        this.customer = customer;
        this.billingService = billingService;
        this.invoiceItem = invoiceItem;
    }


    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDate getBillingPeriod() {
        return billingPeriod;
    }

    public void setBillingPeriod(LocalDate billingPeriod) {
        this.billingPeriod = billingPeriod;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BillingService getBillingService() {
        return billingService;
    }

    public void setBillingService(BillingService billingService) {
        this.billingService = billingService;
    }

    public List<InvoiceItem> getInvoiceItem() {
        return invoiceItem;
    }

    public void setInvoiceItem(List<InvoiceItem> invoiceItem) {
        this.invoiceItem = invoiceItem;
    }
}
