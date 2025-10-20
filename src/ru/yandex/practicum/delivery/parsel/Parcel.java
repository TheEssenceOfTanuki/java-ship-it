package ru.yandex.practicum.delivery.parsel;

public abstract  class Parcel {

    protected String description;
    protected int weight;
    protected String deliveryAddress;
    protected int sendDay;

public Parcel(String description, int weight, String deliveryAddress, int sendDay) {
    this.description = description;
    this.weight = weight;
    this.deliveryAddress = deliveryAddress;
    this.sendDay = sendDay;
}
    public String getDescription() {
        return description;
    }

    public int getWeight() {
        return weight;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public int getSendDay() {
        return sendDay;
    }

    public void packageItem() {
    System.out.println("Посылка <<" + description + ">> упакована.");
    }

    public void deliver() {
    System.out.println("Посылка <<" + description + ">> доставлена по адресу     " + deliveryAddress);
    }

    public abstract int calculateDeliveryCost();

    @Override
    public String toString() {
        return "Package{" // имя класса
                + "description='" + description + "', " // поле1='значение1'
                + "weight='" + weight + "', " // поле2='значение2'
                + "deliveryAddress=" + deliveryAddress + "', "
                + "sendDay=" + sendDay;// поле3=значение3
    }
}
