package ir.maktab.shop.view;

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
//                    CartController.addToCart();
                    break;
                case "2":
//                    CartController.removeFromCart();
                    break;
                case "3":
//                    CartController.viewCart();
                    break;
                case "4":
//                    System.out.println("Total Sum = " + CartController.cartTotalCost());
                    break;
                case "5":
//                    CartController.checkout(currentCustomer);
                    break;
                default:
                    System.out.println("Wrong!");
            }
        }
    }
}
