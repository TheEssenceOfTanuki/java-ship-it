package ru.yandex.practicum.delivery;

import ru.yandex.practicum.delivery.parsel.FragileParcel;
import ru.yandex.practicum.delivery.parsel.Parcel;
import ru.yandex.practicum.delivery.parsel.PerishableParcel;
import ru.yandex.practicum.delivery.parsel.StandardParcel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Parcel> allParcels = new ArrayList<>();
    private static final List<Trackable> trackableParcels = new ArrayList<>();

    private static final ParcelBox<StandardParcel> standardBox = new ParcelBox<>(100);
    private static final ParcelBox<FragileParcel> fragileBox = new ParcelBox<>(100);
    private static final ParcelBox<PerishableParcel> perishableBox = new ParcelBox<>(100);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addParcel();
                    break;
                case "2":
                    sendParcels();
                    break;
                case "3":
                    calculateCosts();
                    break;
                case "4":
                    reportStatus();
                    break;
                case "5":
                    showContentOfTheBox();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Изменить местоположение посылок.");
        System.out.println("5 — Показать содержимое коробки.");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        String type;
        Parcel parcel = null;

        while (true) {
            System.out.println("Укажите тип посылки: 1 — стандартная, 2 — хрупкая, 3 — скоропортящаяся");
            type = scanner.nextLine();

            if (type.equals("1") || type.equals("2") || type.equals("3")) {
                break;
            } else {
                System.out.println("Неверный тип посылки. Доступные варианты: 1, 2, 3. Попробуйте снова.");
            }
        }

        System.out.print("Введите описание: ");
        String description = scanner.nextLine();

        System.out.print("Введите вес: ");
        int weight;
        while (true) {
            weight = Integer.parseInt(scanner.nextLine());
            if (weight > 0) {
                break;
            } else {
                System.out.print("Вес не может быть отрицательным или нулевым. Введите корректный вес: ");
            }
        }
        System.out.print("Введите адрес доставки: ");
        String deliveryAdress = scanner.nextLine();

        System.out.print("Введите дату отправки: ");
        int sendDay = Integer.parseInt(scanner.nextLine());

        switch (type) {
            case "1":
                parcel = new StandardParcel(description, weight, deliveryAdress, sendDay);
                standardBox.addParcel((StandardParcel) parcel);
                break;
            case "2":
                parcel = new FragileParcel(description, weight, deliveryAdress, sendDay);
                fragileBox.addParcel((FragileParcel) parcel);
                trackableParcels.add((Trackable) parcel);
                break;
            case "3":
                System.out.println("Введите срок хранения(дни): ");
                int timeToLive = Integer.parseInt(scanner.nextLine());
                parcel = new PerishableParcel(description, weight, deliveryAdress, sendDay, timeToLive);
                perishableBox.addParcel((PerishableParcel) parcel);
                break;
        }

        allParcels.add(parcel);
        System.out.println("Посылка <<" + description + ">> добавлена!");
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
    }

    private static void sendParcels() {
        if (allParcels.isEmpty()) {
            System.out.println("Посылки отсутствуют.");
            return;
        }
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }// Пройти по allParcels, вызвать packageItem() и deliver()
    }

    private static void calculateCosts() {
        int sum = 0;
        for (Parcel parcel : allParcels) {
            sum += parcel.calculateDeliveryCost();
        }
        System.out.println("Общая стоимость доставки: " + sum);
    }// Посчитать общую стоимость всех доставок и вывести на экран

    private static void reportStatus() {
        if(trackableParcels.isEmpty()) {
            System.out.println("Посылки отсутствуют.");
            return;
        }
        System.out.println("Введите новое местоположение.");
        String location = scanner.nextLine();
        for (Trackable parcel : trackableParcels) {
            parcel.reportStatus(location);
        }
    }

    private static void showContentOfTheBox() {
        System.out.println("Укажите тип коробки: 1 — стандартная, 2 — хрупкая, 3 — скоропортящаяся");
        String type = scanner.nextLine();

        switch (type) {
            case "1":
                standardBox.printAllContent();
                break;
            case "2":
                fragileBox.printAllContent();
                break;
            case "3":
                perishableBox.printAllContent();
                break;
            default:
                System.out.println("Неверный тип коробки. Доступные варианты: 1, 2, 3. Попробуйте снова.");
        }
    }

}

