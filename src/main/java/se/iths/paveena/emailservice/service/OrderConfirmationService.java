package se.iths.paveena.emailservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se.iths.kattis.mailservicegrupp5.model.Email;
import se.iths.kattis.mailservicegrupp5.service.EmailService;
import se.iths.paveena.emailservice.dto.OrderResponse;

@Service
@RequiredArgsConstructor
public class OrderConfirmationService {

    private final EmailService emailService;

    public void sendOrderConfirmation(OrderResponse order) {

        Email email = new Email(order.customerName(),
                "Orderbekräftelse: #" + order.id(),
                orderConfirm(order)
        );

        emailService.send(email);
    }

    private String orderConfirm(OrderResponse order) {

        StringBuilder sb = new StringBuilder();

        sb.append("Tack för din beställning!\n");
        sb.append("Ordernummer: #").append(order.id()).append("\n");
        sb.append("Orderdatum: ").append(order.orderDate()).append("\n\n");
        sb.append("Produkter:\n");

        order.items().forEach(item ->
                sb.append("- ")
                        .append(item.name()).append(" x")
                        .append(item.quantity()).append("\n")
        );

        sb.append("\nTotal: ").append(order.totalPrice()).append(" kr");

        return sb.toString();
    }
}