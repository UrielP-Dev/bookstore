package com.sivalabs.bookstore.orders.core.models;

import com.sivalabs.bookstore.common.model.Address;
import com.sivalabs.bookstore.common.model.Customer;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Set;

public record CreateOrderCmd(
        Long userId,
        @NotEmpty(message = "Items cannot be empty") @Valid Set<OrderItemDto> items,
        @Valid Customer customer,
        @Valid Address deliveryAddress)
        implements Serializable {}
