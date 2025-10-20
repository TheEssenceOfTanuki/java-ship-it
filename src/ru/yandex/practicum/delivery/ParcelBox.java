package ru.yandex.practicum.delivery;

import ru.yandex.practicum.delivery.parsel.Parcel;

import java.util.ArrayList;

public class ParcelBox<T extends Parcel> {

    private final int maxWeight;
    private final ArrayList<T> parcels = new ArrayList<>();
    private int currentWeight = 0;

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void addParcel(T parcel) {
        if (parcel.getWeight() + currentWeight <= maxWeight) {
            parcels.add(parcel);
            currentWeight += parcel.getWeight();
            System.out.println("Посылка добавлена. Текущий вес: " + currentWeight + "/" + maxWeight);
        } else {
            System.out.println("Превышен максимальный вес коробки, посылка не добавлена");
        }
    }

    public ArrayList<T> getAllParcels() {
        return parcels;
    }

    public void printAllContent() {
        if (parcels.isEmpty()) {
            System.out.println("В данной коробке нет посылок");
            return;
        }
        for (T parsel : parcels) {
            System.out.println(parsel);
        }
    }
}
