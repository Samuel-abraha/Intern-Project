package com.example.BillingSystem.Service;

import com.example.BillingSystem.Entitys.Customer;
import com.example.BillingSystem.Entitys.Invoice;
import com.example.BillingSystem.Entitys.InvoiceItem;
import com.example.BillingSystem.Repository.CustomerRepository;
import com.example.BillingSystem.Dto.InvoiceItemResponseDto;
import com.example.BillingSystem.Dto.InvoiceResponseDto;
import com.example.BillingSystem.Mapper.InvoiceItemMapper;
import com.example.BillingSystem.Mapper.InvoiceMapper;
import com.example.BillingSystem.Repository.InvoiceItemRepository;
import com.example.BillingSystem.Repository.InvoiceRepository;
import com.example.BillingSystem.Entitys.Usage;
import com.example.BillingSystem.Repository.UsageRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class InvoiceService {

    private final UsageRepository usageRepository;
    private final InvoiceRepository invoiceRepository;
    private final InvoiceItemRepository invoiceItemRepository;
    private final CustomerRepository customerRepository;
    private final InvoiceMapper invoiceMapper;
    private final InvoiceItemMapper invoiceItemMapper;

    public InvoiceService(UsageRepository usageRepository, InvoiceRepository invoiceRepository, InvoiceItemRepository invoiceItemRepository, CustomerRepository customerRepository, InvoiceMapper invoiceMapper, InvoiceItemMapper invoiceItemMapper) {
        this.usageRepository = usageRepository;
        this.invoiceRepository = invoiceRepository;
        this.invoiceItemRepository = invoiceItemRepository;
        this.customerRepository = customerRepository;
        this.invoiceMapper = invoiceMapper;
        this.invoiceItemMapper = invoiceItemMapper;
    }


//    @Scheduled(cron = "0 0 0 1 * ?") // Every 1st of the month at midnight
    @Scheduled(cron = "0 * * * * ?") // Every minute
    public void generateMonthlyInvoices() {
        List<Customer> customers = customerRepository.findAll();

        for (Customer customer : customers) {
            generateInvoiceForCustomer(customer);
        }
    }

    private void generateInvoiceForCustomer(Customer customer) {
        List<Usage> usageRecords = usageRepository.findAllByCustomer(customer);

        Invoice invoice = new Invoice();
        invoice.setCustomer(customer);
        invoice.setInvoiceDate(LocalDate.now());
        invoice.setBillingPeriod(LocalDate.now().minusMonths(1)); // Assuming billing period is the previous month

        BigDecimal totalAmount = BigDecimal.ZERO;
        Set<InvoiceItem> invoiceItems = new HashSet<>();

        for (Usage usage : usageRecords) {
            InvoiceItem usageChargeItem = createUsageChargeItem(usage);
            usageChargeItem.setInvoice(invoice);
            invoiceItems.add(usageChargeItem);
            totalAmount = totalAmount.add(usageChargeItem.getTotalPrice());
            // setting billing service for invoice
            invoice.setBillingService(usageChargeItem.getBillingService());
        }

        invoice.setInvoiceItem(List.copyOf(invoiceItems));
        invoice.setTotalAmount(totalAmount);


        invoiceRepository.save(invoice);

    }

    private InvoiceItem createUsageChargeItem(Usage usage) {
        InvoiceItem usageChargeItem = new InvoiceItem();
        usageChargeItem.setDescription("Usage Charge");
        usageChargeItem.setUsageAmount(usage.getUsageAmount());
        usageChargeItem.setUnitPrice(usage.getBillingService().getUnitPrice()); // get the unit price from billing service
        usageChargeItem.setUsage(usage);
        usageChargeItem.setBillingService(usage.getBillingService());
        usageChargeItem.setInvoice(null);
        usageChargeItem.setCustomer(usage.getCustomer());// This will be set when invoice is created


// calculate the total price here
        BigDecimal totalPrice = usageChargeItem.getUsageAmount().multiply(usageChargeItem.getUnitPrice());
        usageChargeItem.setTotalPrice(totalPrice);

        return usageChargeItem;
    }

    // for fetching invoice by customer phone number
    public InvoiceResponseDto findInvoiceByCustomerPhonenumber(String phoneNumber){

        return invoiceRepository.findByCustomer_Phonenumber(phoneNumber)
                .map(invoiceMapper::toInvoiceResponseDto)
                .orElse(null);
        //              .orElseThrow(() -> new RuntimeException("Customer not found with phonenumber: " + phonenumber));
    }

    // for fetching invoice item(detail) by customer phone number
    public InvoiceItemResponseDto findInvoiceItemByCustomerPhonenumber(String phoneNumber){

        return invoiceItemRepository.findByCustomer_Phonenumber(phoneNumber)
                .map(invoiceItemMapper::toInvoiceItemResponseDto)
                .orElse(null);
        //              .orElseThrow(() -> new RuntimeException("Customer not found with phonenumber: " + phonenumber));
    }

    public List<InvoiceResponseDto> findAllInvoices(){
        return invoiceRepository.findAll()
                .stream()
                .map(invoiceMapper::toInvoiceResponseDto)
                .collect(Collectors.toList());

    }
}