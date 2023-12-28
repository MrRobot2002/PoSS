package com.vu.localhost.poss.customer.service;

import com.vu.localhost.poss.customer.model.CustomerRequestDTO;
import com.vu.localhost.poss.customer.model.Customer;
import com.vu.localhost.poss.customer.repository.CustomerRepository;
import com.vu.localhost.poss.loyalty.Loyalty;
import com.vu.localhost.poss.loyalty.LoyaltyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    @Autowired
    private LoyaltyRepository loyaltyRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> getCustomerById(Long customerId) {
        return customerRepository.findById(customerId);
    }

    // Retrieve all customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Update a customer's information
    public Customer updateCustomer(Long customerId, CustomerRequestDTO customerDetails) {
        return customerRepository.findById(customerId).map(customer -> {
            if (customerDetails.getName() != null) {
                customer.setName(customerDetails.getName());
            }
            if (customerDetails.getEmail() != null) {
                customer.setEmail(customerDetails.getEmail());
            }
            if (customerDetails.getPhone() != null) {
                customer.setPhone(customerDetails.getPhone());
            }
            // Handling tenant relationship
            if (customerDetails.getLoyalty() != null) {
                if (customerDetails.getLoyalty().toString() != "Optional.empty") {
                    Loyalty loyalty = loyaltyRepository.findById(customerDetails.getLoyalty().get())
                            .orElseThrow(() -> new EntityNotFoundException("loyalty not found"));
                    customer.setLoyalty(loyalty);
                } else {
                    customer.setLoyalty(null);
                }
            }

            if (customerDetails.getTenantId() != null) {
                customer.setTenantId(customerDetails.getTenantId());
            }

            return customerRepository.save(customer);
        }).orElseThrow(() -> new IllegalArgumentException("customer not found with id " + customerId));
    }

    // Delete a customer by ID
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}
