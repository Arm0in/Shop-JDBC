package ir.maktab.shop.view;

import ir.maktab.shop.controller.AttributeController;
import ir.maktab.shop.controller.CartController;
import ir.maktab.shop.controller.CustomerController;
import ir.maktab.shop.controller.ProductController;
import ir.maktab.shop.domain.Customer;
import ir.maktab.shop.util.Helper;

public class ProductMenu extends Menu {

    public ProductMenu() {
        super(new String[]{
                "0. Back"
        });
    }

    public void run(Customer currentCustomer) {
        while (true) {
            showMenu();
            ProductController.viewAllProducts();
            System.out.println("Choose product id for attributes: ");
            String chosenItem = scanner.nextLine();
            switch (chosenItem) {
                case "0":
                    if (Helper.check("Are you sure you want to Back?"))
                        new CustomerMenu().run(currentCustomer);
                    break;
                default:
                    Integer productId = Integer.parseInt(chosenItem);
                    AttributeController.viewProductAttributes(productId);
            }
        }
    }
}
