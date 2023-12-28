package io.swagger.Payment;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.swagger.common.PaymentStateEnum;
import io.swagger.common.PaymentTypeEnum;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public void deletePayment(String paymentId) {
        paymentRepository.deleteById(paymentId);
    }

    public Optional<Payment> getPaymentById(String paymentId) {
        return paymentRepository.findById(paymentId);
    }

    public List<Payment> getAllPayments(Long orderId, PaymentTypeEnum paymentType, PaymentStateEnum paymentState,
            Timestamp dateRangeStart, Timestamp dateRangeEnd, Integer page, Integer limit) {
        int pageNumber = (page != null) ? page - 1 : 0;
        int pageSize = (limit != null) ? limit : 10;
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Payment> paymentPage = paymentRepository
                .findPaymentsByCriteria(orderId, paymentType, paymentState, dateRangeStart, dateRangeEnd, pageable);
        return paymentPage.getContent();
    }
}
