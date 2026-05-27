package se.iths.paveena.emailservice.subscriber;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import se.iths.paveena.emailservice.dto.OrderResponse;
import se.iths.paveena.emailservice.dto.ProductInfoResponse;
import se.iths.paveena.springmessenger.messaging.EmailSender;
import se.iths.paveena.springmessenger.model.Email;

@Component
@RequiredArgsConstructor
public class EmailSubscriber {

    private final EmailSender emailSender;

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void subscribe(OrderResponse order) {

        System.out.println("Order mottagen: " + order.id());

        Email email = new Email();
        email.setRecipient(order.customerName());
        email.setSubject("Orderbekräftelse: ");
        email.setMessage(orderConfirm(order));

        emailSender.send(email);
    }

    private String orderConfirm(OrderResponse order) {

        StringBuilder orderBuilder = new StringBuilder();
        orderBuilder.append("Tack för din beställning! ");
        orderBuilder.append("Ordernummer: ").append(order.id()).append("\n");

        for (ProductInfoResponse item : order.items()) {
            orderBuilder.append(item.name());
            orderBuilder.append(item.quantity());
            orderBuilder.append(item.price());
        }

        orderBuilder.append("\nTotalt: ").append(order.totalPrice()).append(" kr");
        orderBuilder.append("\n\nHälsningar från Webbhandlaren!");
        return orderBuilder.toString();
    }
}
