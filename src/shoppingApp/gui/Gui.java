package shoppingApp.gui;

import shoppingApp.model.Product;

import java.util.List;

public class Gui {
    private static final Gui instance = new Gui();

    private Gui() {
    }

    public void showMenu() {
        System.out.println("1 - Lista produktów");
        System.out.println("2 - Kup produkt");
        System.out.println("3 - Wyjdź");
    }

    public void listProducts(List<Product> products) {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public static Gui getInstance() {
        return instance;
    }
}
