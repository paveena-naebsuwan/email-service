package se.iths.paveena.emailservice.dto;

public record EmailNotificationDto(
        String customerEmail,
        String customerName,
        String customerOrderNumber
) {
}
