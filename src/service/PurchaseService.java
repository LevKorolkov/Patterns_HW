package service;

import entity.Furniture;

import java.util.List;

public interface PurchaseService {
    // Каждый интерфейс отвечает за свою логику (принцип - Single responsibility)
    void toBuy(Furniture furniture);
    List<Furniture> getBuyingFurniture();
    void showBuyingFurniture();
    void purchasing(ProductService productService);

}
