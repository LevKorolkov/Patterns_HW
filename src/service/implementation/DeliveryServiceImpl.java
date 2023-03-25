package service.implementation;

import city.City;
import entity.Buyer;
import entity.Furniture;
import entity.ShopDelivery;
import service.DeliveryService;
import service.PurchaseService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DeliveryServiceImpl implements DeliveryService {
    private Buyer buyer = new Buyer();

    @Override
    public void createDeliveryOrder(PurchaseService purchaseService) {
        ShopDelivery shopDelivery = new ShopDelivery();

        List<Furniture> purchasedFurniture = purchaseService.getBuyingFurniture();

        int deliveryCost = calculateDeliveryCost(shopDelivery);
        int deliveryTime = calculateDeliveryTime();
        String[] fio = buyer.getName().split(" ");
        String firstname = fio[1];
        String surname = fio[2];

        System.out.println(firstname + " " + surname + ", Ваш список купленных товаров для доставки:");
        purchasedFurniture.forEach(System.out::println);
        System.out.println("\nСтоимость доставки: " + deliveryCost + " рублей. Время ожидания: " + deliveryTime + " суток." + "\nОжидайте доставку!");

        buyer.setDeliveryFurniture(purchasedFurniture);
    }

    @Override
    public int calculateDeliveryCost(ShopDelivery shopDelivery) {
        int distance = 0;
        int gasolineCost = shopDelivery.getFuelCost();

        if (buyer.getCity().equals("Санкт-Петербург")) {
            distance = 710;
        } else if (buyer.getCity().equals("Петрозаводск")) {
            distance = 1020;
        } else if (buyer.getCity().equals("Краснодар")) {
            distance = 1200;
        } else if (buyer.getCity().equals("Сочи")) {
            distance = 1370;
        } else if (buyer.getCity().equals("Москва")) {
            return 150;
        }

        int serviceCost = shopDelivery.getServiceCost();
        int oilCompPer100Kilometers = shopDelivery.getCarGasolineConsumptionPer100Kilometers();

        int deliveryCost = (distance / 100) * oilCompPer100Kilometers * gasolineCost + serviceCost;

        return deliveryCost;
    }

    public int arrangeDelivery(PurchaseService purchaseService) {
        if (purchaseService.getBuyingFurniture().isEmpty()) {
            System.out.println("Товары для доставки не выбраны");
            return 0;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Пожалуйста, введите свои контактные данные для доставки");

        System.out.print("ФИО: ");
        String name = scanner.nextLine();

        System.out.println("Введите название населенного пункта (выберите из списка): ");
        City city = new City();
        System.out.println(Arrays.toString(city.getCities()));
        String chosenCity = scanner.nextLine();

        boolean checkCity = Arrays.asList(city.getCities()).contains(chosenCity);
        if (checkCity) {
            System.out.println("В такой город мы еще не доставляем.");
            return 0;
        } else {
            buyer = new Buyer(name, chosenCity);
        }
        return 1;
    }

    @Override
    public void orderTracking() {
        if (buyer.getDeliveryFurniture().isEmpty()) {
            System.out.println("У вас нет товаров в доставке");
            return;
        }
        System.out.println("Ваши товары в доставке:");
        buyer.getDeliveryFurniture().forEach(System.out::println);
    }

    @Override
    public int calculateDeliveryTime() {
        if (buyer.getCity().equals("Санкт-Петербург")) {
            return 3;
        } else if (buyer.getCity().equals("Москва")) {
            return 1;
        } else if (buyer.getCity().equals("Сочи")) {
            return 5;
        } else if (buyer.getCity().equals("Краснодар")) {
            return 6;
        } else if (buyer.getCity().equals("Петрозаводск")) {
            return 4;
        } else {
            return 0;
        }
    }
}
