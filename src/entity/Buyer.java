package entity;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private String name;
    private String city;
    private List<Furniture> deliveryFurniture = new ArrayList<>();

    public Buyer(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public Buyer() {}

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public List<Furniture> getDeliveryFurniture() {
        return deliveryFurniture;
    }

    public void setDeliveryFurniture(List<Furniture> deliveryFurniture) {
        this.deliveryFurniture = deliveryFurniture;
    }
}
