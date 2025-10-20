package ru.yandex.practicum.delivery.parsel;

public enum ParcelType {
    STANDARD(2),
    PERISHABLE(3),
    FRAGILE(4);

    private final int cost;

    ParcelType(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}
