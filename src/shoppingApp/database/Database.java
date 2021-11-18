package shoppingApp.database;

import org.apache.commons.codec.digest.DigestUtils;
import shoppingApp.model.Product;
import shoppingApp.model.User;

import java.awt.color.ProfileDataException;
import java.util.List;
import java.util.ArrayList;

public class Database {
    private List<Product> products = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    private static final Database instance = new Database();

    private Database() {
        products.add(new Product(1,"Mokra karma dla kota", 6.50, 6));
        products.add(new Product(2,"Mokra karma dla psa", 6.50, 7));
        products.add(new Product(3,"Zabawkowa mysz", 11.99, 10));
        products.add(new Product(4,"Kosc do gryzienia", 7.80, 8));
        products.add(new Product(5,"Kuweta", 50.00, 1));
        products.add(new Product(6,"Smycz", 19.99, 4));

        users.add(new User("Ala", DigestUtils.md5Hex("ala1")));
        users.add(new User("Beata", DigestUtils.md5Hex("beata2")));
        users.add(new User("Celina", DigestUtils.md5Hex("celina3")));
    }

    public static Database getInstance() {
        return instance;
    }

    public List<Product> getProducts() {
        return products;
    }

    public boolean authenticate(String login, String password) {
        for (User user : this.users) {
            if (user.getLogin().equals(login) &&
                    user.getPassword().equals(DigestUtils.md5Hex(password))) {
                return true;
            }
        }
        return false;
    }

    public boolean buyProduct(int id) {
        for (Product product : this.products) {
            if (product.getId()==id && product.getInStock()>0){
                product.setInStock(product.getInStock()-1);
                return true;
            }
        }
        return false;
    }

}
