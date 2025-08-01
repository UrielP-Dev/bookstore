package com.sivalabs.bookstore.orders.core;

import com.sivalabs.bookstore.common.model.Address;
import com.sivalabs.bookstore.common.model.Customer;
import com.sivalabs.bookstore.orders.core.models.OrderStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "orders")
class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id_generator")
    @SequenceGenerator(name = "order_id_generator", sequenceName = "order_id_seq")
    private Long id;

    @Column(name = "order_number", nullable = false, unique = true)
    private String orderNumber;

    @Column(nullable = false, name = "user_id")
    private Long userId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order")
    private Set<OrderItem> items;

    @Embedded
    @AttributeOverrides(
            value = {
                @AttributeOverride(name = "name", column = @Column(name = "customer_name")),
                @AttributeOverride(name = "email", column = @Column(name = "customer_email")),
                @AttributeOverride(name = "phone", column = @Column(name = "customer_phone"))
            })
    private Customer customer;

    @Embedded
    @AttributeOverrides(
            value = {
                @AttributeOverride(name = "addressLine1", column = @Column(name = "delivery_address_line1")),
                @AttributeOverride(name = "addressLine2", column = @Column(name = "delivery_address_line2")),
                @AttributeOverride(name = "city", column = @Column(name = "delivery_address_city")),
                @AttributeOverride(name = "state", column = @Column(name = "delivery_address_state")),
                @AttributeOverride(name = "zipCode", column = @Column(name = "delivery_address_zip_code")),
                @AttributeOverride(name = "country", column = @Column(name = "delivery_address_country")),
            })
    private Address deliveryAddress;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private String comments;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Long getId() {
        return this.id;
    }

    public String getOrderNumber() {
        return this.orderNumber;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Set<OrderItem> getItems() {
        return this.items;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public Address getDeliveryAddress() {
        return this.deliveryAddress;
    }

    public OrderStatus getStatus() {
        return this.status;
    }

    public String getComments() {
        return this.comments;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setItems(Set<OrderItem> items) {
        this.items = items;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
