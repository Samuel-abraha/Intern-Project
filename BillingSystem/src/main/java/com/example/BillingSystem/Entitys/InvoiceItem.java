package com.example.BillingSystem.Entitys;

import com.example.BillingSystem.Service.BillingService;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class InvoiceItem {
    @Id
    @GeneratedValue
    private Long invoiceItemId;

    private String Description;


    @Column(nullable = false)
    private BigDecimal usageAmount;

    @Column(nullable = false)
    private BigDecimal unitPrice;

    @Column(nullable = false)
    private BigDecimal totalPrice;

    @ManyToOne
    @JoinColumn(
            name = "invoice_id",
            nullable = false)
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(
            name = "service_id",
            nullable = false
    )
    private BillingService billingService;

    @ManyToOne
    @JoinColumn(name = "usage_id", nullable = false)
    private Usage usage;

    @ManyToOne
    @JoinColumn(
            name = "customer_id",
            nullable = false)
    private Customer customer;


    public InvoiceItem() {
    }

    public InvoiceItem(Long invoiceItemId, String description, BigDecimal usageAmount, BigDecimal unitPrice, BigDecimal totalPrice, Invoice invoice, BillingService billingService, Usage usage, Customer customer) {
        this.invoiceItemId = invoiceItemId;
        Description = description;
        this.usageAmount = usageAmount;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.invoice = invoice;
        this.billingService = billingService;
        this.usage = usage;
        this.customer = customer;
    }

    public Long getInvoiceItemId() {
        return invoiceItemId;
    }

    public void setInvoiceItemId(Long invoiceItemId) {
        this.invoiceItemId = invoiceItemId;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public BigDecimal getUsageAmount() {
        return usageAmount;
    }

    public void setUsageAmount(BigDecimal usageAmount) {
        this.usageAmount = usageAmount;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    public BillingService getBillingService() {
        return billingService;
    }

    public void setBillingService(BillingService billingService) {
        this.billingService = billingService;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
