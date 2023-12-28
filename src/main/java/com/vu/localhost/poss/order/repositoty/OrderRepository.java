package com.vu.localhost.poss.order.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vu.localhost.poss.order.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}