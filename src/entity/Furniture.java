package entity;

public class Furniture implements Comparable<Furniture>{
    private Integer rate;
    private final String name;
    private final int cost;

    public Furniture(String name, int cost, int rate) {
        this.rate = rate;
        this.name = name;
        this.cost = cost;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Название модели: " + name + "; Стоимость: " + cost + "; Рейтинг: " + rate;
    }

    @Override
    public int compareTo(Furniture o) {
        return this.rate.compareTo(o.getRate());
    }
}
