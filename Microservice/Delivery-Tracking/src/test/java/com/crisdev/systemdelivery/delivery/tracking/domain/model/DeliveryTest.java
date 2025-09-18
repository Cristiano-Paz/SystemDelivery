package com.crisdev.systemdelivery.delivery.tracking.domain.model;

import com.crisdev.systemdelivery.delivery.tracking.domain.exception.DomainException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryTest {

    @Test
    public void shouldChangeToPlaced() {
        Delivery delivery = Delivery.draft();

        delivery.editPreparationDetails(createdValidPreparationDetails());

        delivery.place();

        assertEquals(DeliveryStatus.WAITING_FOR_COURIER, delivery.getStatus());
        assertNotNull(delivery.getPlaceAt());
    }

    @Test
    public void shouldNotPlace() {
        Delivery delivery = Delivery.draft();
        assertThrows(DomainException.class, () -> {
            delivery.place();
        });

        assertEquals(DeliveryStatus.DRAFT, delivery.getStatus());
        assertNull(delivery.getPlaceAt());
    }

    private Delivery.PreparationDetails createdValidPreparationDetails() {
        ContactPoint sender = ContactPoint.builder()
                .zipCode("00000-000")
                .street("Rua Espanha")
                .number("110")
                .complement("Sala 506")
                .name("James King")
                .phone("(50) 91111-2222")
                .build();

        ContactPoint recipient = ContactPoint.builder()
                .zipCode("11221-654")
                .street("Rua Canada")
                .number("250")
                .complement("Sala 600")
                .name("Jhon String")
                .phone("(21) 92222-1111")
                .build();

        return Delivery.PreparationDetails.builder()
                .sender(sender)
                .recipient(recipient)
                .distanceFee(new BigDecimal("15.00"))
                .courierPayout(new BigDecimal("5.00"))
                .expectedDeliveryTime(Duration.ofHours(5))
                .build();
    }

}