package se.iths.paveena.emailservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Huvudklassen för Email-service.
 *
 * Klassen startar Spring Boot-applikationen och gör det möjligt
 * för Spring att hitta komponenter i projektets olika paket.
 */
@SpringBootApplication(scanBasePackages = "se.iths.paveena")
public class EmailServiceApplication {

    /**
     * Startar Email-service.
     *
     * @param args argument som skickas med när applikationen startas
     */
    public static void main(String[] args) {
        SpringApplication.run(EmailServiceApplication.class, args);
    }

}
