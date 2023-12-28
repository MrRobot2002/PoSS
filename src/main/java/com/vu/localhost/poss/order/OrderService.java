package com.vu.localhost.poss.order;

import java.util.List;
import java.util.Optional;

import com.vu.localhost.poss.orderItem.OrderItem;
import com.vu.localhost.poss.orderItem.OrderItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private static Logger logger = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    public OrderService(OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    // Create a new order
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    // Retrieve a single order by ID
    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    // Retrieve all orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Update a order's information
    public Order updateOrder(Long orderId, CreateOrder orderDetails) {
        return orderRepository.findById(orderId).map(order -> {
            if (orderDetails.getCustomerId() != null) {
                order.setCustomerId(orderDetails.getCustomerId());
            }
            if (orderDetails.getEmployeeId() != null) {
                order.setEmployeeId(orderDetails.getEmployeeId());
            }
            if (orderDetails.getStatus() != null) {
                order.setStatus(orderDetails.getStatus());
            }
            if (orderDetails.getDiscountId() != null) {
                order.setDiscountId(orderDetails.getDiscountId());
            }
            if (orderDetails.getTips() != null) {
                order.setTips(orderDetails.getTips());
            }

            if (orderDetails.getTenantId() != null) {
                order.setTenantId(orderDetails.getTenantId());
            }

            return orderRepository.save(order);
        }).orElseThrow(() -> new IllegalArgumentException("order not found with id " + orderId));
    }

    // Delete a order by ID
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    public void addItemToOrder(Long orderId, OrderItem orderItem) {
        logger.info("Adding item to order" + orderItem);
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("order not found with id " + orderId));

        // Set the order of the item and add it to the order
        orderItem.setOrder(order);
        order.addItem(orderItem);

        // Save the updated order to the database
        orderRepository.save(order);
    }

    public void modifyItemQuantityInOrder(Long orderId, Long itemId, OrderItem body) {
        // Find the order by id
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("order not found with id " + orderId));

        // Find the order item in the order
        OrderItem orderItem = order.getItems().stream()
                .filter(item -> item.getId().equals(itemId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "order item not found with id " + itemId));

        // Update the quantity of the order item
        orderItem.setQuantity(body.getQuantity());

        // Save the order back to the database
        orderRepository.save(order);
    }

    public void removeItemFromOrder(Long orderID, Long itemID) {
        Order order = orderRepository.findById(orderID)
                .orElseThrow(() -> new IllegalArgumentException("order not found with id " + orderID));
        OrderItem orderItem = order.getItems().stream()
                .filter(item -> item.getId().equals(itemID))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "order item not found with id " + itemID));
        order.getItems().remove(orderItem);
        orderRepository.save(order);
    }
}
