package shoppingApp.model;

public class Product {
    private int id;
    private String name;
    private double price;
    private int inStock;

    public Product(int id, String name, double price, int inStock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inStock = inStock;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append("{ ID produktu: ")
                .append(this.id)
                .append("   nazwa produktu: ")
                .append(this.name)
                .append("   cena: ")
                .append(this.price)
                .append("   ilosc w magazynie: ")
                .append(this.inStock)
                .append(" }");

        return stringBuilder.toString();
    }
}
