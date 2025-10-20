package ru.yandex.practicum.delivery.parsel;

public class PerishableParcel extends Parcel {

    private final int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    public boolean isExpired(int currentDay) {
       return !((super.sendDay + timeToLive) >= currentDay);
    }

    @Override
    public int calculateDeliveryCost() {
        return ParcelType.PERISHABLE.getCost() * super.weight;
    }

    @Override
    public String toString() {
        return "PerishableParcel{"
                + super.toString() + ", "  // используем родительский toString
                + "timeToLive=" + timeToLive
                + '}';
    }
}
