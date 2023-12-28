package com.vu.localhost.poss.payment.controller;

import com.vu.localhost.poss.order.model.Order;
import com.vu.localhost.poss.order.repositoty.OrderRepository;
import com.vu.localhost.poss.payment.model.Payment;
import com.vu.localhost.poss.payment.model.PaymentRequestDTO;
import com.vu.localhost.poss.payment.service.PaymentService;
import com.vu.localhost.poss.tenant.model.Tenant;
import com.vu.localhost.poss.tenant.repository.TenantRepository;
import com.vu.localhost.poss.common.PaymentStateEnum;
import com.vu.localhost.poss.common.PaymentTypeEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class PaymentApiController implements PaymentApi {

    private static final Logger log = LoggerFactory.getLogger(PaymentApiController.class);

    private final PaymentService paymentService;
    @Autowired
    private TenantRepository tenantRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    public PaymentApiController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public ResponseEntity<Payment> createPayment(PaymentRequestDTO paymentRequestDTO) {
        Payment payment = convertToEntity(paymentRequestDTO);
        Payment createdPayment = paymentService.createPayment(payment);
        return ResponseEntity.ok(createdPayment);
    }

    @Override
    public ResponseEntity<Void> deletePayment(@PathVariable("paymentId") String paymentId) {
        try {
            paymentService.deletePayment(paymentId);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            System.err.println("Error occurred while trying to delete product: " + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Payment> getPaymentDetails(@PathVariable("paymentId") String paymentId) {
        return paymentService.getPaymentById(paymentId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<List<Payment>> listPayments(Long orderId, Integer paymentType, Integer paymentState,
            LocalDateTime dateRangeStart, LocalDateTime dateRangeEnd, Integer page, Integer limit) {
        try {
            PaymentTypeEnum paymentTypeEnum = null;
            PaymentStateEnum paymentStateEnum = null;
            if (paymentType != null) {
                paymentTypeEnum = PaymentTypeEnum.fromInt(paymentType);
            }
            if (paymentState != null) {
                paymentStateEnum = PaymentStateEnum.fromInt(paymentState);
            }
            List<Payment> payments = paymentService.getAllPayments(orderId, paymentTypeEnum, paymentStateEnum,
                    dateRangeStart,
                    dateRangeEnd, page, limit);
            if (payments.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(payments, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    private Payment convertToEntity(PaymentRequestDTO paymentRequestDTO) {
        Payment payment = new Payment();
        payment.setPaymentId(UUID.randomUUID().toString());
        if (paymentRequestDTO.getOrderId() != null) {
            Order order = orderRepository.findById(paymentRequestDTO.getOrderId())
                    .orElseThrow(() -> new EntityNotFoundException("order not found"));
            payment.setOrderId(order);
        }
        payment.setPrice(paymentRequestDTO.getPrice());
        payment.setPaymentType(paymentRequestDTO.getPaymentType());
        payment.setPaymentState(paymentRequestDTO.getPaymentState());
        payment.setCurrentDate();
        if (paymentRequestDTO.getTenant() != null) {
            Optional<Tenant> tenantOptional = tenantRepository.findById(paymentRequestDTO.getTenant());
            if (tenantOptional.isPresent()) {
                Tenant tenant = tenantOptional.get();
                Long tenantId = tenant.getId();
                payment.setTenant(tenantId);
            } else {
                throw new EntityNotFoundException("tenant not found");
            }
        }
        return payment;
    }
}
