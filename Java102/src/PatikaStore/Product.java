package PatikaStore;

public class Product {
    int id;
    double price;
    double discountRate;
    int stock;
    String name;
    Brand brand;

    public Product(int id, double price, double discountRate, int stock, String name, Brand brand) {
        this.id = id;
        this.price = price;
        this.discountRate = discountRate;
        this.stock = stock;
        this.name = name;
        this.brand = brand;
    }
}
