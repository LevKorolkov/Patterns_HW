package service.implementation;

import entity.Furniture;
import service.ProductService;
import service.PurchaseService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PurchaseServiceImpl implements PurchaseService {
    private final List<Furniture> buyingFurniture  = new ArrayList<>();
    public List<Furniture> getBuyingFurniture() {
        return buyingFurniture;
    }

    @Override
    public void showBuyingFurniture() {
        if (buyingFurniture.isEmpty()) {
            System.out.println("Корзина пуста!");
        }
        buyingFurniture.forEach(System.out::println);
    }

    @Override
    public void purchasing(ProductService productService) {
        System.out.println("Введите номер товара");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        Furniture furniture = productService.findProductById(id);
        System.out.println("Выбранный товар: " + furniture + "\n");
        System.out.println("Вы уверены, что хотите купить данный товар?" + "\n" + "1. Да" + "\n" + "2. Нет" + "\n");
        int agreement = scanner.nextInt();
        switch (agreement) {
            case 1:
                toBuy(furniture);
                System.out.println("Товар добавлен в заказ!");
                break;
            case 2:
                break;
        }
    }

    @Override
    public String toString() {
        return "Список выбранных для покупки товаров: " +
                buyingFurniture;
    }

    @Override
    public void toBuy(Furniture furniture) {
        buyingFurniture.add(furniture);
    }


}
