package com.example.BillingSystem.Entitys;

import com.example.BillingSystem.Service.BillingService;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Usage {

    @Id
    @GeneratedValue
    private Long usageId;

    private BigDecimal usageAmount;
    private LocalDate billingPeriod;    //the month for the billing
    private LocalDate usageDate;    //the date where the usage is measured

    @ManyToOne(cascade = CascadeType.ALL) //add cascade ont this if needed or customer side
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_id", nullable = false)
    private BillingService billingService;

    @OneToMany(mappedBy = "usage")  //one usage has many invoiceitem(like in invoice item electric charge , tax)
    private Set<InvoiceItem> invoiceItem;

    public Usage() {
    }


    public Usage(Long usageId, BigDecimal usageAmount, LocalDate billingPeriod, LocalDate usageDate, Customer customer, BillingService billingService, Set<InvoiceItem> invoiceItem) {
        this.usageId = usageId;
        this.usageAmount = usageAmount;
        this.billingPeriod = billingPeriod;
        this.usageDate = usageDate;
        this.customer = customer;
        this.billingService = billingService;
        this.invoiceItem = invoiceItem;
    }

    public Usage(BigDecimal usageAmount, LocalDate billingPeriod, LocalDate usageDate, Customer customer, BillingService billingService) {
        this.usageAmount = usageAmount;
        this.billingPeriod = billingPeriod;
        this.usageDate = usageDate;
        this.customer = customer;
        this.billingService = billingService;
    }

    public Long getUsageId() {
        return usageId;
    }

    public void setUsageId(Long usageId) {
        this.usageId = usageId;
    }

    public BigDecimal getUsageAmount() {
        return usageAmount;
    }

    public void setUsageAmount(BigDecimal usageAmount) {
        this.usageAmount = usageAmount;
    }

    public LocalDate getBillingPeriod() {
        return billingPeriod;
    }

    public void setBillingPeriod(LocalDate billingPeriod) {
        this.billingPeriod = billingPeriod;
    }

    public LocalDate getUsageDate() {
        return usageDate;
    }

    public void setUsageDate(LocalDate usageDate) {
        this.usageDate = usageDate;
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

    public Set<InvoiceItem> getInvoiceItem() {
        return invoiceItem;
    }

    public void setInvoiceItem(Set<InvoiceItem> invoiceItem) {
        this.invoiceItem = invoiceItem;
    }
}
