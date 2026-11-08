package se.iths.paveena.emailservice.dto;

import java.math.BigDecimal;

/**
 * Innehåller information om en produkt i en beställning.
 *
 * Klassen används för att skicka produktinformation
 * till Email-service så att produkterna kan visas
 * i kundens orderbekräftelse.
 *
 * @param id produktens unika ID
 * @param name produktens namn
 * @param price priset för en produkt
 * @param quantity antal produkter som kunden har beställt
 */
public record ProductInfoResponse(
        Long id,
        String name,
        BigDecimal price,
        int quantity
) {
}
