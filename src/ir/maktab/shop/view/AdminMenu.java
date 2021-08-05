package ir.maktab.shop.view;

import ir.maktab.shop.controller.CustomerController;
import ir.maktab.shop.domain.Admin;
import ir.maktab.shop.util.Helper;

public class AdminMenu extends Menu {
    public AdminMenu() {
        super(new String[]{
                "Change User Status",
                "Logout"
        });
    }

    public void run(Admin currentAdmin) {
        while (true) {
            showMenu();
            String chosenItem = scanner.nextLine();
            switch (chosenItem) {
                case "1":
                    CustomerController.changeUserStatus();
                    break;
                case "2":
                    if (Helper.check("Are you sure you want to Logout?"))
                        new MainMenu().run();
                    break;
                default:
                    System.out.println("Wrong!");
            }
        }
    }
}
