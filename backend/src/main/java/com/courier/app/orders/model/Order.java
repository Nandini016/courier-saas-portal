package com.courier.app.orders.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerEmail;
    private String senderName;
    private String receiverName;
    private String pickupAddress;
    private String deliveryAddress;
    private LocalDateTime createdAt;
    private String deliveryProofPath;
    private String pickupPhone;
    private double packageLengthCm;
    private double packageWidthCm;
    private double packageHeightCm;
    private double packageWeightKg;
    private String deliveryPhone;
    private String pickupDate;
    private String pickupTimeWindow;
    private String specialInstructions;
    private boolean isFragile;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "#0.0")
    private double declaredValue;
    private String assignedPartnerEmail;
    @Enumerated(EnumType.STRING)
    private PackageType packageType;
    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;
    @Enumerated(EnumType.STRING)
    private DeliveryType deliveryType;
    @Enumerated(EnumType.STRING)
    private InvoiceStatus invoiceStatus;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.status = OrderStatus.CREATED;
    }
}