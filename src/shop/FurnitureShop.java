package shop;

import service.DeliveryService;
import service.ProductService;
import service.PurchaseService;
import service.implementation.DeliveryServiceImpl;
import service.implementation.ProductServiceImpl;
import service.implementation.PurchaseServiceImpl;

import java.util.Scanner;

public class FurnitureShop implements Shop {

    // Использование сервисов как доступ к объектам (принцип Dependency-Inversion)
    private final DeliveryService deliveryService = new DeliveryServiceImpl();
    private final ProductService productService = new ProductServiceImpl();
    private final PurchaseService purchaseService = new PurchaseServiceImpl();
    private final Scanner scanner = new Scanner(System.in);


    @Override
    public void enterStore() {
        productService.setAvailableProducts();
        System.out.println("Добро пожаловать в магазин! Выберите интересующие вас разделы: ");
        while (true) {
            showMenu();
            int choice = 0;

            switch (choice) {
                case 1 -> showInfo();
                case 2 -> {
                    System.out.println("Выберите фильтр сортировки: 1-возрастание цены; 2-убывание цены; 3-возрастание рейтинга; 4-убывание рейтинга.");
                    int i = scanner.nextInt();
                    productService.showAllAvailableProducts(i);
                }
                case 3 -> {
                    productService.searchProducts();
                }
                case 4 -> purchaseService.purchasing(productService);
                case 5 -> purchaseService.showBuyingFurniture();
                case 6 -> {
                    if (deliveryService.arrangeDelivery(purchaseService) == 0) {
                        break;
                    }
                    deliveryService.createDeliveryOrder(purchaseService);
                    productService.deleteProductFromStock(purchaseService);
                }
                case 7 -> deliveryService.orderTracking();
                case 0 -> {
                    System.out.println("Хорошего дня!");
                    return;
                }
                default -> System.out.println("Функционал под таким номером отсутствует");
            }
        }
    }

    public void showMenu() {
        System.out.println("\n" + "Меню магазина: " + "\n"
                + "1. Узнать о нас" + "\n"
                + "2. Список доступных к покупке товаров" + "\n"
                + "3. Поиск товара по имени" + "\n"
                + "4. Купить интересующие вас товары" + "\n"
                + "5. Показать корзину" + "\n"
                + "6. Оформить доставку" + "\n"
                + "7. Показать товары в доставке" + "\n"
                + "0. Выйти из магазина" + "\n");
    }

    public void showInfo() {
        System.out.println("Мы - команда \"Facture\", занимающаяся производством мебели из " +
                "полноценного сруба дерева слеудющих видов:" +
                " ольха, береза, сосна, ель, дуб." + ".." + "\n");
    }

}

