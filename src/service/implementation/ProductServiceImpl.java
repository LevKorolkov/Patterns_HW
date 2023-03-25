package service.implementation;

import entity.Furniture;
import service.ProductService;
import service.PurchaseService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductServiceImpl implements ProductService {
    private final List<Furniture> productsList = new ArrayList<>();

    @Override
    public void setAvailableProducts() {
        productsList.add(new Furniture("Стол из дуба", 13000, 4));
        productsList.add(new Furniture("Стул из сосны", 5000, 5));
        productsList.add(new Furniture("Доска из бука", 2000, 5));
        productsList.add(new Furniture("Сушилка для белья из бука", 5000, 3));
        productsList.add(new Furniture("Пуф из сосны", 2000, 4));
        productsList.add(new Furniture("Домик для котов из ольхи", 3000, 2));
        productsList.add(new Furniture("Подставка для телевизора из ели", 2000, 5));
        productsList.add(new Furniture("Комод из дуба", 12500, 3));
    }

    @Override
    public List<Furniture> getAllAvailableProducts() {
        return productsList;
    }

    public void showAllAvailableProducts(int i) {
        switch (i) {
            case 1 ->
                    productsList.stream().sorted(Comparator.comparingInt(Furniture::getCost)).forEach(System.out::println);
            case 2 ->
                    productsList.stream().sorted(Comparator.comparingInt(Furniture::getCost).reversed()).forEach(System.out::println);
            case 3 ->
                    productsList.stream().sorted(Comparator.comparing(Furniture::getRate)).forEach(System.out::println);
            case 4 ->
                    productsList.stream().sorted(Comparator.comparing(Furniture::getRate).reversed()).forEach(System.out::println);
        }
    }

    public void searchProducts() {
        System.out.println("Пожалуйста, введите имя товара:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        boolean find = false;
        for (Furniture furniture : productsList) {
            if (furniture.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(furniture);
                find = true;
            }
        }
        if (!find) {
            System.out.println("Товар с таким наименованием не найден");
        }
    }

    @Override
    public String findProductByName(String name) {
        for (Furniture product : productsList) {
            if (product.getName().equals(name)) {
                return product.toString();
            }
        }
        return "Товар с таким названием не найден";
    }

    public Furniture findProductById(int id) {
        return productsList.get(id - 1);
    }

    @Override
    public void deleteProductFromStock(PurchaseService purchaseService) {
        List<Furniture> purchasedFurniture = purchaseService.getBuyingFurniture();
        for (Furniture f : purchasedFurniture) {
            productsList.remove(f);
        }
    }
}
