package io.swagger.Customer;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomersApiController implements CustomersApi {

    private static final org.jboss.logging.Logger log = LoggerFactory.logger(CustomersApiController.class);

    private final CustomerService customerService; // Add the CustomerService dependency

    @Autowired
    public CustomersApiController(CustomerService customerService) {
        this.customerService = customerService; // Initialize CustomerService
    }

    @Override
    public ResponseEntity<List<Customer>> listCustomers() {
        try {
            // Use the CustomerService to get all customers
            List<Customer> customers = customerService.getAllCustomers();
            // Check if the customer list is empty
            if (customers.isEmpty()) {
                // Return no content if there are no customers
                return ResponseEntity.noContent().build();
            }

            // Return the list of customers with an OK status
            return ResponseEntity.ok(customers);
        } catch (Exception e) {
            // Log and return an Internal Server Error if something goes wrong
            log.error("Error occurred while trying to list customers: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
