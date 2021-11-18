package shoppingApp;

import shoppingApp.database.Database;
import shoppingApp.gui.Gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) {

        boolean success = false;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            for (int i = 0; i < 3; i++) {
                System.out.println("Podaj login:");
                String login = br.readLine();
                System.out.println("Podaj haslo:");
                String pass = br.readLine();

                success = Database.getInstance().authenticate(login, pass);
                if (success) {
                    success = true;
                    break;
                } else {
                    System.out.println("Bledny login i/lub haslo.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (success) {
            Gui.getInstance().showMenu();

            try {
                BufferedReader br =
                        new BufferedReader(new InputStreamReader(System.in));
                switch (br.readLine()) {
                    case "1":
                        Gui.getInstance().listProducts(Database.getInstance().getProducts());
                        break;
                    case "2":
                        System.out.println("Podaj ID produktu:");
                        try {
                            if (Database.getInstance().buyProduct(Integer.parseInt(br.readLine()))) {
                                System.out.println("Produkt kupiony.");
                            } else {
                                System.out.println("Brak produktu o takim ID lub brak produktu w magazynie.");
                            }
                        } catch (NumberFormatException ex){
                                //ex.printStackTrace();
                                System.out.println("Bledny format - ID powinno byc liczba naturalna.");
                        }
                        break;
                    case "3":
                        return;
                    default:
                        System.out.println("Nieprawidłowy wybór - nie ma takiej opcji w menu.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
