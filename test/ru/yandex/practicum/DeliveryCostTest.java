package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.*;
import ru.yandex.practicum.delivery.parsel.StandardParcel;

import static org.junit.jupiter.api.Assertions.*;

public class DeliveryCostTest {

    @Test
    public void shouldReturn10ForStandartParcelAndWeight5() {
        StandardParcel standardParcel =
                new StandardParcel("Книга", 5, "Адрес", 8);
        assertEquals(10, standardParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldReturn30ForStandartParcelAndWeight15() {
        StandardParcel standardParcel =
                new StandardParcel("Чемодан", 15, "Адрес", 5);
        assertEquals(30, standardParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldReturn20ForFragileParcelAndWeight5() {
        StandardParcel standardParcel =
                new StandardParcel("Книга", 5, "Адрес", 8);
        assertEquals(20, standardParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldReturn120FragileParcelAndWeight15() {
        StandardParcel standardParcel =
                new StandardParcel("Чемодан", 15, "Адрес", 5);
        assertEquals(120, standardParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldReturn15ForPerishableParcelAndWeight5() {
        StandardParcel standardParcel =
                new StandardParcel("Книга", 5, "Адрес", 8);
        assertEquals(15, standardParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldReturn45PerishableParcelAndWeight15() {
        StandardParcel standardParcel =
                new StandardParcel("Чемодан", 15, "Адрес", 5);
        assertEquals(45, standardParcel.calculateDeliveryCost());
    }
}
