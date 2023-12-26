package io.swagger.Order;

import org.springframework.beans.factory.annotation.Autowired;

public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
}
