package se.iths.paveena.emailservice.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record OrderResponse(
        Long id,
        String customerName,
        LocalDateTime orderDate,
        List<ProductInfoResponse> items,
        BigDecimal totalPrice
) {
}