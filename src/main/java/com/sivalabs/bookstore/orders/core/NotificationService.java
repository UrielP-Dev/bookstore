package com.sivalabs.bookstore.orders.core;

import com.sivalabs.bookstore.orders.events.OrderCancelledEvent;
import com.sivalabs.bookstore.orders.events.OrderCreatedEvent;
import com.sivalabs.bookstore.orders.events.OrderDeliveredEvent;
import com.sivalabs.bookstore.orders.events.OrderErrorEvent;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final EmailService emailService;

    NotificationService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void sendConfirmationNotification(OrderCreatedEvent event) {
        String content =
                """
                        Hi %s,
                        This email is to notify you that your order : %s is received and will be processed soon.

                        Thanks,
                        BookStore Team
                        """
                        .formatted(event.customer().name(), event.orderNumber());
        emailService.sendEmail(event.customer().email(), "Order Confirmation", content);
    }

    public void sendDeliveredNotification(OrderDeliveredEvent event) {
        String content =
                """
                        Hi %s,
                        This email is to notify you that your order : %s is delivered.

                        Thanks,
                        BookStore Team
                        """
                        .formatted(event.customer().name(), event.orderNumber());
        emailService.sendEmail(event.customer().email(), "Order Delivery Confirmation", content);
    }

    public void sendCancelledNotification(OrderCancelledEvent event) {
        String content =
                """
                        Hi %s,
                        This email is to notify you that your order : %s is cancelled.

                        Thanks,
                        BookStore Team
                        """
                        .formatted(event.customer().name(), event.orderNumber());
        emailService.sendEmail(event.customer().email(), "Order Cancellation Confirmation", content);
    }

    public void sendErrorNotification(OrderErrorEvent event) {
        String content =
                """
                        Hi %s,
                        This email is to notify you that your order : %s is failed to process.

                        Thanks,
                        BookStore Team
                        """
                        .formatted(event.customer().name(), event.orderNumber());
        emailService.sendEmail(event.customer().email(), "Order Error Notification", content);
    }
}
