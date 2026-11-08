package se.iths.paveena.emailservice.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Innehåller information om en beställning.
 *
 * Klassen används för att skicka information om en beställning
 * från Order-service till Email-service.
 *
 * @param id beställningens unika ID
 * @param customerName kundens namn eller kontaktinformation
 * @param orderDate datum och tid när beställningen skapades
 * @param items lista med produkterna i beställningen
 * @param totalPrice beställningens totala pris
 */
public record OrderResponse(
        Long id,
        String customerName,
        LocalDateTime orderDate,
        List<ProductInfoResponse> items,
        BigDecimal totalPrice
) {
}