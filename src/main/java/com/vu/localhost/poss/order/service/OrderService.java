package com.vu.localhost.poss.order.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vu.localhost.poss.order.model.Order;
import com.vu.localhost.poss.order.model.OrderRequestDTO;
import com.vu.localhost.poss.order.repositoty.OrderRepository;
import com.vu.localhost.poss.orderItem.OrderItem;
import com.vu.localhost.poss.product.model.Product;
import com.vu.localhost.poss.product.repository.ProductRepository;
import com.vu.localhost.poss.service.model.Service;
import com.vu.localhost.poss.service.repository.ServiceRepository;
import com.vu.localhost.poss.tax.model.Tax;
import com.vu.localhost.poss.tax.repository.TaxRepository;

@org.springframework.stereotype.Service
public class OrderService {

    private static Logger logger = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private TaxRepository taxRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order) {
        logger.info("Creating order" + order);
        return orderRepository.save(order);
    }

    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order updateOrder(Long orderId, OrderRequestDTO orderDetails) {
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
            if (orderDetails.getTaxId() != null) {
                order.setTaxId(orderDetails.getTaxId());
            }
            if (orderDetails.getTips() != null) {
                order.setTips(orderDetails.getTips());
            }
            if (orderDetails.getTenantId() != null) {
                order.setTenantId(orderDetails.getTenantId());
            }

            return orderRepository.save(order);
        }).orElseThrow(() -> new IllegalArgumentException("Order not found with id " + orderId));
    }

    // Delete a order by ID
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    public void addItemToOrder(Long orderId, OrderItem orderItem) {
        logger.info("Adding item to order" + orderItem);
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found with id " + orderId));

        orderItem.setOrder(order);
        order.addItem(orderItem);
        orderRepository.save(order);
    }

    public void modifyItemQuantityInOrder(Long orderId, Long itemId, OrderItem body) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found with id " + orderId));

        OrderItem orderItem = order.getItems().stream()
                .filter(item -> item.getId().equals(itemId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "Order item not found with id " + itemId));

        orderItem.setQuantity(body.getQuantity());

        orderRepository.save(order);
    }

    public void removeItemFromOrder(Long orderID, Long itemID) {
        Order order = orderRepository.findById(orderID)
                .orElseThrow(() -> new IllegalArgumentException("Order not found with id " + orderID));
        OrderItem orderItem = order.getItems().stream()
                .filter(item -> item.getId().equals(itemID))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "Order item not found with id " + itemID));
        order.getItems().remove(orderItem);
        orderRepository.save(order);
    }

    public BigDecimal calculateTotalPriceNoTax(Order order) {
        BigDecimal totalPrice = BigDecimal.ZERO;

        for (OrderItem item : order.getItems()) {
            BigDecimal price = getPriceFromItem(item); // You need to implement this method
            BigDecimal quantity = BigDecimal.valueOf(item.getQuantity());
            totalPrice = totalPrice.add(price.multiply(quantity));
        }

        return totalPrice;
    }

    public BigDecimal calculateTotalPriceNoDiscount(Order order) {
        BigDecimal totalPrice = calculateTotalPriceNoTax(order);

        if (order.getTaxId() != null) {
            Tax tax = taxRepository.findById(order.getTaxId())
                    .orElseThrow(() -> new EntityNotFoundException("Tax not found"));
            BigDecimal taxRate = tax.getRate();
            BigDecimal taxAmount = totalPrice.multiply(taxRate);
            totalPrice = totalPrice.add(taxAmount);
        }
        return totalPrice;
    }

    private BigDecimal getPriceFromItem(OrderItem item) {
        if (item.getProductId() != null) {
            Product product = productRepository.findById(item.getProductId())
                    .orElseThrow(() -> new EntityNotFoundException("Product not found"));
            return product.getPrice().getAmount();
        } else if (item.getServiceId() != null) {
            Service service = serviceRepository.findById(item.getServiceId())
                    .orElseThrow(() -> new EntityNotFoundException("Service not found"));
            return service.getPrice().getAmount();
        } else {
            throw new IllegalArgumentException("OrderItem must have either a product or a service");
        }
    }
}
