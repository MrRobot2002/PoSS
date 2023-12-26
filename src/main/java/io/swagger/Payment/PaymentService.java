package io.swagger.Payment;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PaymentService {

    private final PaymentRepository paymentRepository;
    private OrderRepository orderRepository;


    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment getPaymentById(String paymentId) throws Exception {
        Optional<Payment> payment = paymentRepository.findById(paymentId);
        if (!payment.isPresent()) {
            throw new Exception("Payment not found for id: " + paymentId);
        }
        return payment.get();
    }

    public Payment saveOrUpdatePayment(Payment payment) {
        // Additional business logic can be added here

        // Ensure the associated order exists
        Order order = orderRepository.findById(payment.getOrder().getId())
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id " + payment.getOrder().getId()));

        payment.setOrder(order);
        return paymentRepository.save(payment);
    }
}
}
