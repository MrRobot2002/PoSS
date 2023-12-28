package com.vu.localhost.poss.order;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.vu.localhost.poss.customer.Customer;
import com.vu.localhost.poss.customer.CustomerRepository;
import com.vu.localhost.poss.discount.Discount;
import com.vu.localhost.poss.discount.DiscountRepository;
import com.vu.localhost.poss.employee.model.Employee;
import com.vu.localhost.poss.employee.repository.EmployeeRepository;
import com.vu.localhost.poss.orderItem.OrderItem;
import com.vu.localhost.poss.tax.Tax;
import com.vu.localhost.poss.tax.TaxRepository;
import com.vu.localhost.poss.tenant.Tenant;
import com.vu.localhost.poss.tenant.TenantRepository;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-25T04:32:42.344389+02:00[Europe/Vilnius]")
@RestController
public class OrderApiController implements OrderApi {

    private final OrderService orderService;
    @Autowired
    private TenantRepository tenantRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DiscountRepository discountRepository;
    @Autowired
    private TaxRepository taxRepository;

    @org.springframework.beans.factory.annotation.Autowired
    public OrderApiController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequestDTO createOrderDTO) {
        Order order = convertToEntity(createOrderDTO); // You need to convert DTO to Order entity
        Order createdOrder = orderService.createOrder(order);
        return ResponseEntity.ok(createdOrder);
    }

    @Override
    public ResponseEntity<Void> deleteOrder(Long orderId) {
        try {
            orderService.deleteOrder(orderId);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            System.err.println("Error occurred while trying to delete order: " + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<OrderResponseDTO> getOrder(@PathVariable("orderID") Long orderID) {
        Order order = orderService.getOrderById(orderID)
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));
        OrderResponseDTO orderResponseDTO = convertToDTO(order);
        return ResponseEntity.ok(orderResponseDTO);
    }

    private OrderResponseDTO convertToDTO(Order order) {
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();

        orderResponseDTO.setOrderId(order.getOrderId());
        orderResponseDTO.setCustomerId(order.getCustomerId());
        orderResponseDTO.setEmployeeId(order.getEmployeeId());
        orderResponseDTO.setDiscountId(order.getDiscountId());
        orderResponseDTO.setTaxId(order.getTaxId());
        orderResponseDTO.setTips(order.getTips());
        orderResponseDTO.setTenantId(order.getTenantId());
        orderResponseDTO.setStatus(order.getStatus());
        orderResponseDTO.setTotalPriceNoTax(orderService.calculateTotalPriceNoTax(order));
        orderResponseDTO.setTotalPriceNoDiscount(orderService.calculateTotalPriceNoDiscount(order));

        return orderResponseDTO;
    }

    @Override
    public ResponseEntity<Order> updateOrder(@PathVariable("orderID") Long id,
            @RequestBody OrderRequestDTO order) {
        try {
            Order updatedOrder = orderService.updateOrder(id, order);
            return ResponseEntity.ok(updatedOrder);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    private Order convertToEntity(OrderRequestDTO orderRequestDTO) {
        Order order = new Order();

        order.setStatus(orderRequestDTO.getStatus());
        order.setTips(orderRequestDTO.getTips());

        if (orderRequestDTO.getTenantId() != null) {
            Tenant tenant = getEntityById(tenantRepository, orderRequestDTO.getTenantId());
            order.setTenantId(tenant.getId());
        }

        if (orderRequestDTO.getCustomerId() != null) {
            Customer customer = getEntityById(customerRepository, orderRequestDTO.getCustomerId());
            order.setCustomerId(customer.getCustomerId());
        }

        if (orderRequestDTO.getEmployeeId() != null) {
            Employee employee = getEntityById(employeeRepository, orderRequestDTO.getEmployeeId());
            order.setEmployeeId(employee.getEmployeeId());
        }

        if (orderRequestDTO.getDiscountId() != null) {
            Discount discount = getEntityById(discountRepository, orderRequestDTO.getDiscountId());
            order.setDiscountId(discount.getDiscountId());
        }

        if (orderRequestDTO.getTaxId() != null) {
            Tax tax = getEntityById(taxRepository, orderRequestDTO.getTaxId());
            order.setTaxId(tax.getTaxId());
        }
        return order;
    }

    private <T> T getEntityById(JpaRepository<T, Long> repository, Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));
    }

    @Override
    public ResponseEntity<Void> addItemToOrder(@PathVariable("orderID") Long orderID,
            @Valid @RequestBody OrderItem body) {
        try {
            orderService.addItemToOrder(orderID, body);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build(); // return 404 Not Found if the order is not found
        } catch (Exception e) {
            System.err.println(e);
            return ResponseEntity.badRequest().build(); // return 400 Bad Request for any other errors

        }
    }

    @Override
    public ResponseEntity<Void> modifyItemQuantityInOrder(@PathVariable("orderID") Long orderID,
            @PathVariable("itemID") Long itemID,
            @RequestBody OrderItem body) {

        try {
            orderService.modifyItemQuantityInOrder(orderID, itemID, body);
            return ResponseEntity.ok().build(); // return 200 OK if successful
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build(); // return 404 Not Found if the order is not found
        } catch (Exception e) {
            System.err.println(e);
            return ResponseEntity.badRequest().build(); // return 400 Bad Request for any other errors

        }
    }

    @Override
    public ResponseEntity<Void> removeItemFromOrder(@PathVariable("orderID") Long orderID,
            @PathVariable("itemID") Long itemID) {

        try {
            orderService.removeItemFromOrder(orderID, itemID);
            return ResponseEntity.ok().build(); // return 200 OK if successful
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build(); // return 404 Not Found if the order is not found
        } catch (Exception e) {
            System.err.println(e);
            return ResponseEntity.badRequest().build(); // return 400 Bad Request for any other errors

        }
    }
}
