package io.swagger.Order;

<<<<<<< HEAD
import io.swagger.model.Item;
import io.swagger.orderItem.OrderItem;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

=======
import io.swagger.model.CreateOrder;
import io.swagger.Item.Item;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
>>>>>>> 02b85579cedf445c0ddc9e7d6c14716460bcd653
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
=======
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
>>>>>>> 02b85579cedf445c0ddc9e7d6c14716460bcd653

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-25T04:32:42.344389+02:00[Europe/Vilnius]")
@RestController
public class OrderApiController implements OrderApi {

    private final OrderService orderService;

    @org.springframework.beans.factory.annotation.Autowired
    public OrderApiController(OrderService orderService) {
        this.orderService = orderService;
    }

<<<<<<< HEAD
    @Override
    public ResponseEntity<Order> createOrder(@RequestBody CreateOrder createOrderDTO) {
        Order order = convertToEntity(createOrderDTO); // You need to convert DTO to Order entity
        Order createdOrder = orderService.createOrder(order);
        return ResponseEntity.ok(createdOrder);
=======
    public ResponseEntity<Void> addItemToOrder(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("orderID") Long orderID,
            @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody Item body) {
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
>>>>>>> 02b85579cedf445c0ddc9e7d6c14716460bcd653
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

<<<<<<< HEAD
    @Override
    public ResponseEntity<Order> getOrder(@PathVariable("orderID") Long orderID) {
        return orderService.getOrderById(orderID)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
=======
    public ResponseEntity<Void> deleteOrder(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("orderID") Long orderID) {
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
>>>>>>> 02b85579cedf445c0ddc9e7d6c14716460bcd653
    }

    @Override
    public ResponseEntity<Order> updateOrder(@PathVariable("orderID") Long id,
            @RequestBody CreateOrder order) {
        try {
            Order updatedOrder = orderService.updateOrder(id, order);
            return ResponseEntity.ok(updatedOrder);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

<<<<<<< HEAD
    @Transactional
    private Order convertToEntity(CreateOrder createOrderDTO) {
        Order order = new Order();
        order.setCustomerId(createOrderDTO.getCustomerId());
        order.setEmployeeId(createOrderDTO.getEmployeeId());
        order.setDiscountId(createOrderDTO.getDiscountId());
        order.setStatus(createOrderDTO.getStatus());
        order.setTips(createOrderDTO.getTips());
        order.setTenantId(createOrderDTO.getTenantId());
        return order;
    }

    @Override
    public ResponseEntity<Void> addItemToOrder(@PathVariable("orderID") Long orderID,
            @Valid @RequestBody OrderItem body) {
        try {
            orderService.addItemToOrder(orderID, body);
            return ResponseEntity.ok().build(); // return 200 OK if successful
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
=======
    public ResponseEntity<Void> modifyItemQuantityInOrder(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("orderID") Long orderID,
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema(allowableValues = {
                    "PRODUCT", "SERVICE" })) @PathVariable("category") String category,
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("itemID") Long itemID,
            @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody Item body) {
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> removeItemFromOrder(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("orderID") Long orderID,
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema(allowableValues = {
                    "PRODUCT", "SERVICE" })) @PathVariable("category") String category,
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("itemID") Long itemID) {
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateOrder(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("orderID") Long orderID,
            @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody Order body) {
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
>>>>>>> 02b85579cedf445c0ddc9e7d6c14716460bcd653
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
