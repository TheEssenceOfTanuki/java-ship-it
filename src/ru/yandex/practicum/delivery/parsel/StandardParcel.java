package ru.yandex.practicum.delivery.parsel;

public class StandardParcel extends Parcel {

    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public int calculateDeliveryCost() {
        return ParcelType.STANDARD.getCost() * super.weight;
    }

    @Override
    public String toString() {
        return "StandardParcel{"
                + super.toString()  // используем родительский toString
                + '}';
    }
}
