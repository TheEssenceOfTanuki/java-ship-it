package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.parsel.StandardParcel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckingIfTheBoxIsFullTest {
    @Test
    public void shouldAddParcelToBoxWhenIsNotFull() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(60);
        StandardParcel standardParcel =
                new StandardParcel("Чемодан", 15, "Адрес", 15);
        box.addParcel(standardParcel);
        assertEquals(1, box.getAllParcels().size());
    }

    @Test
    public void shouldNotAddParcelToBoxWhenBoxIsFull() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(10);
        StandardParcel standardParcel =
                new StandardParcel("Чемодан", 15, "Адрес", 15);
        box.addParcel(standardParcel);
        assertEquals(0, box.getAllParcels().size());
    }

    @Test
    public void shouldAddParcelWhenWeightEqualsMaxWeight() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(20);
        StandardParcel parcel =
                new StandardParcel("Сумка", 20, "Адрес", 15);
        box.addParcel(parcel);
        assertEquals(1, box.getAllParcels().size());
    }
}
