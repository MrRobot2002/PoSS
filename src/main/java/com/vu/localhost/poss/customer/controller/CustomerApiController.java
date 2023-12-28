package com.vu.localhost.poss.customer.controller;

import com.vu.localhost.poss.customer.model.CustomerRequestDTO;
import com.vu.localhost.poss.customer.model.Customer;
import com.vu.localhost.poss.customer.service.CustomerService;
import com.vu.localhost.poss.loyalty.model.Loyalty;
import com.vu.localhost.poss.loyalty.repository.LoyaltyRepository;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@RestController
public class CustomerApiController implements CustomerApi {

    private static final org.jboss.logging.Logger log = LoggerFactory.logger(CustomerApiController.class);

    private final CustomerService customerService;
    @Autowired
    private LoyaltyRepository loyaltyRepository;

    @Autowired
    public CustomerApiController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Implement the getCustomer method from the CustomerApi interface
    @Override
    public ResponseEntity<Customer> getCustomer(@PathVariable("customerId") Long id) {
        return customerService.getCustomerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Implement the updateUser method from the CustomerApi interface
    @Override
    public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId") Long id,
            @RequestBody CustomerRequestDTO customer) {
        try {
            Customer updatedCustomer = customerService.updateCustomer(id, customer);
            return ResponseEntity.ok(updatedCustomer);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Implement the createCustomer method from the CustomerApi interface
    @Override
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerRequestDTO createCustomerDTO) {
        Customer customer = convertToEntity(createCustomerDTO); // You need to convert DTO to customer entity
        Customer createdCustomer = customerService.createCustomer(customer);
        return ResponseEntity.ok(createdCustomer);
    }

    @Override
    public ResponseEntity<Void> deleteCustomer(Long customerId) {
        try {
            customerService.deleteCustomer(customerId);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            System.err.println("Error occurred while trying to delete customer: " + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Helper method to convert CreateCustomer DTO to customer entity

    @Transactional
    private Customer convertToEntity(CustomerRequestDTO createCustomerDTO) {
        Customer customer = new Customer();
        customer.setName(createCustomerDTO.getName());
        customer.setEmail(createCustomerDTO.getEmail());
        customer.setPhone(createCustomerDTO.getPhone());
        /// System.out.println("tenant: " + tenantRepository.);

        // Handling tenant relationship
        if (createCustomerDTO.getLoyalty().isPresent()) {
            Loyalty loyalty = null;
            if (createCustomerDTO.getLoyalty() != null) {
                loyalty = loyaltyRepository.findById(createCustomerDTO.getLoyalty().get())
                        .orElseThrow(() -> new EntityNotFoundException("loyalty not found"));
            }
            customer.setLoyalty(loyalty);
        }
        customer.setTenantId(createCustomerDTO.getTenantId());

        return customer;
    }

    @Override
    public ResponseEntity<List<Customer>> listCustomers() {
        try {
            List<Customer> customers = customerService.getAllCustomers();
            if (customers.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(customers);
        } catch (Exception e) {
            log.error("Error occurred while trying to list customers: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
