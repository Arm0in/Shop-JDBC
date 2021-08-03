package ir.maktab.shop.view;

import ir.maktab.shop.controller.CustomerController;
import ir.maktab.shop.domain.Customer;
import ir.maktab.shop.util.Helper;

public class MainMenu extends Menu {
    public MainMenu() {
        super(new String[]{
                "Login",
                "Register",
                "Admin Login",
                "Exit"
        });
    }

    public void run() {
        while (true) {
            showMenu();
            String chosenItem = scanner.nextLine();
            switch (chosenItem) {
                case "1":
                    Customer currentCustomer = CustomerController.login();
                    if (currentCustomer != null)
                        new CustomerMenu().run(currentCustomer);
                    break;
                case "2":
                    CustomerController.register();
                    break;
                case "3":
//                    Admin currentAdmin = AdminController.login();
//                    if (currentAdmin != null)
//                        new AdminMenu().run(currentAdmin);
                    break;
                case "4":
                    if (Helper.check("Are you sure you want to exit?"))
                        System.exit(0);
                default:
                    System.out.println("Wrong!");
                    break;
            }
        }
    }
}
