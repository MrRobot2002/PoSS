package com.vu.localhost.poss.payment;

import java.sql.Timestamp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vu.localhost.poss.common.PaymentStateEnum;
import com.vu.localhost.poss.common.PaymentTypeEnum;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {
        @Query("SELECT p FROM Payment p WHERE " +
                        "(:orderId IS NULL OR p.orderId.orderId = :orderId) AND " +
                        "(:paymentType IS NULL OR p.type = :paymentType) AND " +
                        "(:paymentState IS NULL OR p.state = :paymentState) AND " +
                        "(:dateRangeStart IS NULL OR p.date >= :dateRangeStart) AND " +
                        "(:dateRangeEnd IS NULL OR p.date <= :dateRangeEnd)")
        Page<Payment> findPaymentsByCriteria(@Param("orderId") Long orderId,
                        @Param("paymentType") PaymentTypeEnum paymentType,
                        @Param("paymentState") PaymentStateEnum paymentState,
                        @Param("dateRangeStart") Timestamp dateRangeStart,
                        @Param("dateRangeEnd") Timestamp dateRangeEnd, Pageable pageable);
}