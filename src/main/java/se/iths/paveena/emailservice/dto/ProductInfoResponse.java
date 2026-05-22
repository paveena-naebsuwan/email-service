package se.iths.paveena.emailservice.dto;

import java.math.BigDecimal;

public record ProductInfoResponse(
        Long id,
        String name,
        BigDecimal price,
        int quantity
) {
}
