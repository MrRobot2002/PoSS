package com.vu.localhost.poss.customer;

import com.vu.localhost.poss.loyalty.Loyalty;
import com.vu.localhost.poss.loyalty.LoyaltyRepository;
import com.vu.localhost.poss.tenant.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-25T04:32:42.344389+02:00[Europe/Vilnius]")
@RestController
public class CustomerApiController implements CustomerApi {

    private final CustomerService customerService;
    @Autowired
    private TenantRepository tenantRepository; // Inject the tenant repository
    @Autowired
    private LoyaltyRepository loyaltyRepository;

    @Autowired
    public CustomerApiController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Implement the getCustomer method from the CustomerApi interface
    @Override
    public ResponseEntity<Customer> getCustomer(@PathVariable("customerId") Long id) {
        System.out.println("getcustomerbyid " + id);
        return customerService.getCustomerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Implement the updateUser method from the CustomerApi interface
    @Override
    public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId") Long id,
            @RequestBody CreateCustomer customer) {
        try {
            Customer updatedCustomer = customerService.updateCustomer(id, customer);
            return ResponseEntity.ok(updatedCustomer);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Implement the createCustomer method from the CustomerApi interface
    @Override
    public ResponseEntity<Customer> createCustomer(@RequestBody CreateCustomer createCustomerDTO) {
        Customer customer = convertToEntity(createCustomerDTO); // You need to convert DTO to customer entity
        Customer createdCustomer = customerService.createCustomer(customer);
        return ResponseEntity.ok(createdCustomer);
    }

    @Override
    public ResponseEntity<Void> deleteCustomer(Long customerId) {
        try {
            // Call the service to delete the customer by ID
            customerService.deleteCustomer(customerId);

            // Return an appropriate response
            // HttpStatus.NO_CONTENT indicates that the action was successful but there's no
            // content to return.
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            // If the customer doesn't exist, you might want to return a 404 Not Found.
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            // For other exceptions, you might return a 500 Internal Server Error
            // Log the exception for debugging purposes
            // (Make sure to import the necessary Logger at the beginning of your class)
            System.err.println("Error occurred while trying to delete customer: " + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Helper method to convert CreateCustomer DTO to customer entity

    @Transactional
    private Customer convertToEntity(CreateCustomer createCustomerDTO) {
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
}
