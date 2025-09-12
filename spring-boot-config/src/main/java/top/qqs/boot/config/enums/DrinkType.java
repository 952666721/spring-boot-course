package top.qqs.boot.config.enums;

public enum DrinkType {
    COFFEE("咖啡", 5.0f),
    TEA("奶茶", 3.0f),
    JUICE("果汁", 2.0f);

    private final String description;
    private final float price;

    DrinkType(String description, float price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }
}
