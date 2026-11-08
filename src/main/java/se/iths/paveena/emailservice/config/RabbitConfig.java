package se.iths.paveena.emailservice.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Konfiguration för RabbitMQ i Email-service.
 *
 * Klassen skapar en kö för meddelanden och bestämmer
 * hur meddelanden ska omvandlas mellan JSON och Java-objekt.
 */

@Configuration
public class RabbitConfig {

    @Value("${rabbitmq.queue.name}")
    private String queueName;

    /**
     * Skapar en beständig RabbitMQ-kö.
     *
     * Kön får sitt namn från inställningarna i application.properties.
     *
     * @return en RabbitMQ-kö som finns kvar efter omstart av RabbitMQ
     */

    @Bean
    public Queue queue() {
        return new Queue(queueName, true);
    }

    /**
     * Skapar en meddelandekonverterare med Jackson.
     *
     * Den används för att omvandla JSON-meddelanden till Java-objekt
     * och Java-objekt till JSON.
     *
     * @return en meddelandekonverterare
     */

    @Bean
    public MessageConverter messageConverter() {
        return new JacksonJsonMessageConverter();
    }
}
