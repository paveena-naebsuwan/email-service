package se.iths.paveena.emailservice.subscriber;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import se.iths.paveena.emailservice.dto.OrderResponse;
import se.iths.paveena.emailservice.service.OrderConfirmationService;

@Component
@RequiredArgsConstructor
public class EmailSubscriber {

    private final OrderConfirmationService orderConfirmationService;

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void subscribe(OrderResponse order) {

        System.out.println("Order mottagen: #" + order.id());

        orderConfirmationService.sendOrderConfirmation(order);
    }
}