package service;

import entity.Furniture;

import java.util.List;

public interface ProductService {
    // Каждый интерфейс отвечает за свою логику (принцип - Single responsibility)
    void setAvailableProducts();
    List<Furniture> getAllAvailableProducts();
    void showAllAvailableProducts(int i);
    String findProductByName(String name);
    Furniture findProductById(int id);
    void deleteProductFromStock(PurchaseService purchaseService);
    void searchProducts();

}
