package ru.yandex.practicum.delivery.parsel;

import ru.yandex.practicum.delivery.Trackable;

public class FragileParcel extends Parcel implements Trackable {

    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка <<" + description + ">> обернута в защитную пленку.");
        super.packageItem();
    }

    @Override
    public int calculateDeliveryCost() {
        return ParcelType.FRAGILE.getCost() * super.weight;
    }

    @Override
    public String toString() {
        return "FragileParcel{"
                + super.toString()  // используем родительский toString
                + '}';
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка <<" + description + ">> изменила местоположение на " + newLocation);
    }
}
