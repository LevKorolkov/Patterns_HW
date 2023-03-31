# Patterns_HW

1. Принцип открытости/закрытости: класс ShopDelivery (https://github.com/LevKorolkov/Patterns_HW/blob/main/src/entity/ShopDelivery.java)
2. Принцип единственной ответственности: пакет service -> интерфейсы DeliveryService, ProductService, PurchaseService (https://github.com/LevKorolkov/Patterns_HW/tree/main/src/service);
3. Принцип деления интерфейсов: пакет service -> интерфейсы DeliveryService, ProductService, PurchaseService (https://github.com/LevKorolkov/Patterns_HW/tree/main/src/service);
4. Принцип Dependency-Inversion: пакет shop -> класс FurnitureShop (https://github.com/LevKorolkov/Patterns_HW/blob/main/src/shop/FurnitureShop.java)

DRY - отсутствие повторения кода соблюдено везде
MAGICS - все переменные вынесены в отдельные поля (например, в пакете entity -> класс ShopDelivery).
