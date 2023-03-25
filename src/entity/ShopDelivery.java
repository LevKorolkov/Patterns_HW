package entity;

public class ShopDelivery {

    // Принцип открытости-закрытости
    private final String name = "CDEK";
    private final int carGasolineConsumptionPer100Kilometers = 10;
    private final int serviceCost = 500;
    private final int fuelCost = Refueling.fuelCost();

    public int getFuelCost() {
        return fuelCost;
    }

    public ShopDelivery() {
    }

    public String getName() {
        return name;
    }

    public int getCarGasolineConsumptionPer100Kilometers() {
        return carGasolineConsumptionPer100Kilometers;
    }

    public int getServiceCost() {
        return serviceCost;
    }

}

class Refueling {
    private static int fuelCost = 55;
    public static int fuelCost() {
        return fuelCost;
    }
}
