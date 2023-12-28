package io.swagger.Payment;

import io.swagger.Order.Order;
import io.swagger.Order.OrderRepository;
import io.swagger.Tenant.Tenant;
import io.swagger.Tenant.TenantRepository;
import io.swagger.common.PaymentStateEnum;
import io.swagger.common.PaymentTypeEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
            String dateRangeStart, String dateRangeEnd, Integer page, Integer limit) {
        try {
            PaymentTypeEnum paymentTypeEnum = null;
            PaymentStateEnum paymentStateEnum = null;
            if (paymentType != null) {
                paymentTypeEnum = PaymentTypeEnum.fromInt(paymentType);
            }
            if (paymentState != null) {
                paymentStateEnum = PaymentStateEnum.fromInt(paymentState);
            }
            Timestamp dateRangeStartTimestamp = null;
            if (dateRangeStart != null) {
                LocalDateTime localDateTimeStart = LocalDateTime.parse(dateRangeStart, DateTimeFormatter.ISO_DATE_TIME);
                dateRangeStartTimestamp = Timestamp.valueOf(localDateTimeStart);
            }
            Timestamp dateRangeEndTimestamp = null;
            if (dateRangeEnd != null) {
                LocalDateTime localDateTimeEnd = LocalDateTime.parse(dateRangeEnd, DateTimeFormatter.ISO_DATE_TIME);
                dateRangeEndTimestamp = Timestamp.valueOf(localDateTimeEnd);
            }
            List<Payment> payments = paymentService.getAllPayments(orderId, paymentTypeEnum, paymentStateEnum,
                    dateRangeStartTimestamp,
                    dateRangeEndTimestamp, page, limit);
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
                    .orElseThrow(() -> new EntityNotFoundException("Tenant not found"));
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
                throw new EntityNotFoundException("Tenant not found");
            }
        }
        return payment;
    }
}
