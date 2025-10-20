package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.parsel.PerishableParcel;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CorrectExpirationDateTest {

    @Test
    public void shouldReturnTrueForParcelIsExpired() {
        PerishableParcel parcel = new PerishableParcel("Мясо", 10, "Адрес",
                5, 3);
        assertTrue(parcel.isExpired(6));
    }

    @Test
    public void shoulReturnFalseForParcelIsNotExpired() {
        PerishableParcel parcel = new PerishableParcel("Мясо", 10, "Адрес",
                5, 3);
        assertTrue(parcel.isExpired(2));
    }
}
