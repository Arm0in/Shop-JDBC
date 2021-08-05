package ir.maktab.shop.view;

import ir.maktab.shop.controller.CartController;
import ir.maktab.shop.controller.CartItemController;
import ir.maktab.shop.domain.Customer;

public class ShopMenu extends Menu {
    public ShopMenu() {
        super(new String[]{
                "Add to Cart",
                "Remove from Cart",
                "View Cart",
                "Cart Sum",
                "Checkout"
        });
    }

    public void run(Customer currentCustomer) {
        while (true) {
            showMenu();
            String chosenItem = scanner.nextLine();
            switch (chosenItem) {
                case "1":
                    CartItemController.addToCart(currentCustomer);
                    break;
                case "2":
                    CartItemController.removeFromCart(currentCustomer);
                    break;
                case "3":
                    CartController.viewCart(currentCustomer);
                    break;
                case "4":
                    System.out.println("Total Sum = " + CartController.cartTotalCost(currentCustomer));
                    break;
                case "5":
                    CartController.checkout(currentCustomer);
                    break;
                default:
                    System.out.println("Wrong!");
            }
        }
    }
}
