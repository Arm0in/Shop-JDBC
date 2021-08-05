package ir.maktab.shop.view;

import ir.maktab.shop.controller.CartController;
import ir.maktab.shop.controller.CustomerController;
import ir.maktab.shop.controller.ProductController;
import ir.maktab.shop.domain.Customer;
import ir.maktab.shop.util.Helper;

public class CustomerMenu extends Menu {

    public CustomerMenu() {
        super(new String[]{
                "View All Products",
                "Charge account",
                "Shop",
                "Logout"
        });
    }

    public void run(Customer currentCustomer) {
        while (true) {
            showMenu();
            String chosenItem = scanner.nextLine();
            switch (chosenItem) {
                case "1":
                    new ProductMenu().run(currentCustomer);
                    break;
                case "2":
                    CustomerController.chargeAccount(currentCustomer);
                    break;
                case "3":
                    CartController.createCart(currentCustomer);
                    new ShopMenu().run(currentCustomer);
                    break;
                case "4":
                    if (Helper.check("Are you sure you want to Logout?"))
                        new MainMenu().run();
                    break;
                default:
                    System.out.println("Wrong!");
            }
        }
    }
}
