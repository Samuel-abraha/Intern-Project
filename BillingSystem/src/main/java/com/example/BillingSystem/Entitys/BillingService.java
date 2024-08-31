package com.example.BillingSystem.Entitys;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
public class BillingService {
    @Id
    @GeneratedValue
    private Long serviceId;

    @Column(unique = true, nullable = false)
    private String serviceName;

//    @Column(nullable = false)
    private BigDecimal unitPrice;

    @Column(nullable = false)
    private String unitOfMeasure;

    @OneToMany(mappedBy = "billingService")
    private List<Usage> usages;

    @OneToMany(mappedBy = "billingService")
    private Set<Invoice> invoice;

    @OneToMany(mappedBy = "billingService")
    private Set<InvoiceItem> invoiceItem;  // collection that holds all the InvoiceItem entities related to particular Service

    public BillingService() {
    }



    public BillingService(Long serviceId, String serviceName,BigDecimal unitPrice, String unitOfMeasure, List<Usage> usages, Set<InvoiceItem> invoiceItem) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.unitPrice=unitPrice;
        this.unitOfMeasure = unitOfMeasure;
        this.usages = usages;
        this.invoiceItem = invoiceItem;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public List<Usage> getUsages() {
        return usages;
    }

    public void setUsages(List<Usage> usages) {
        this.usages = usages;
    }

    public Set<InvoiceItem> getInvoiceItem() {
        return invoiceItem;
    }

    public void setInvoiceItem(Set<InvoiceItem> invoiceItem) {
        this.invoiceItem = invoiceItem;
    }
}
