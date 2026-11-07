# Email Service

## Om tjänsten

Email Service ansvarar för att skicka e-postmeddelanden. Tjänsten kommunicerar med Order Service via RabbitMQ. När Order Service skickar ett meddelande till RabbitMQ tar Email Service emot meddelandet, behandlar informationen och skickar ett e-postmeddelande till mottagaren via SMTP.
## Teknik

- Spring Boot
- Spring AMQP
- RabbitMQ
- Maven
- Spring Messenger

## Köra lokalt

### Krav

- Java 21
- Maven
- Tillgång till RabbitMQ
- Ett SMTP-konto

### Miljövariabler

| Miljövariabel | Beskrivning |
|---|---|
| MAIL_USERNAME | E-postadress som används för att skicka e-post |
| MAIL_APP_PASSWORD | Applösenord för e-postkontot |
| RABBITMQ_HOST | RabbitMQ-serverns adress |
| RABBITMQ_PORT | RabbitMQ-serverns port |
| RABBITMQ_USERNAME | Användarnamn för RabbitMQ |
| RABBITMQ_PASSWORD | Lösenord för RabbitMQ |
| RABBITMQ_VHOST | Anger vilken virtuell miljö som används i RabbitMQ. |
| RABBITMQ_QUEUE_NAME | Namnet på kön där Email Service tar emot meddelanden.|

### Starta tjänsten

Gå till projektmappen:

```bash
cd email-service
```

Installera projektets beroenden:

```bash
mvn clean install
```

Starta applikationen:

```bash
mvn spring-boot:run
```

Tjänsten körs lokalt på port `8084`.


## Övrigt

- **RabbitMQ:** Används för att ta emot meddelanden från andra mikrotjänster.
- **SMTP:** Används för att skicka e-post till mottagare.
- **MessageService:** Hanterar inkommande meddelanden.
- **EmailSender:** Ansvarar för att skicka e-postmeddelanden.

## Länkar till övriga repositories

- Auth Service: https://github.com/J0ssan-iths/Auth-serverProject
- Product Service: https://github.com/JohannaVii/product-service
- Order Service: https://github.com/Kattis82/order-service
- Gateway: https://github.com/Kattis82/jwt-gateway
- Frontend: https://github.com/JohannaVii/Frontend

## Driftsatt miljö (Render)
- Auth Service: https://auth-serverproject-1-0-0.onrender.com
- Product Service: https://product-service-1-0-0-16ub.onrender.com
- Gateway: https://gateway-tyjw.onrender.com
- Order Service: https://order-service-1-0-0.onrender.com
- Email Service: https://email-service-1-0-1.onrender.com
- Frontend: https://webshoppen-kjpj.onrender.com
