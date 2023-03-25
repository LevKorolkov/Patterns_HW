package service;

import entity.ShopDelivery;

public interface DeliveryService {
    // Каждый интерфейс отвечает за свою логику (принцип - Single responsibility)
    // Деление интерфейсов
    void createDeliveryOrder(PurchaseService purchaseService);

    int calculateDeliveryCost(ShopDelivery shopDelivery);

    int arrangeDelivery(PurchaseService purchaseService);

    void orderTracking();

    int calculateDeliveryTime();
}
