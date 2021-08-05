package ir.maktab.shop.controller;

import ir.maktab.shop.base.ConnectionInitializer;
import ir.maktab.shop.domain.Admin;
import ir.maktab.shop.repository.AdminRepository;
import ir.maktab.shop.repository.impl.AdminRepositoryImpl;
import ir.maktab.shop.service.AdminService;
import ir.maktab.shop.service.impl.AdminServiceImpl;

import java.util.Scanner;

public class AdminController {

    private static Scanner scanner = new Scanner(System.in);
    private static AdminService service = new AdminServiceImpl(new AdminRepositoryImpl(ConnectionInitializer.connect()));

    public static Admin login() {
        System.out.println("Please enter your Username: ");
        String username = scanner.nextLine();
        System.out.println("Please enter your Password: ");
        String password = scanner.nextLine();
        Admin admin = service.login(username, password);
        if (admin == null) {
            System.out.println("Incorrect Login credentials!");
            return null;
        } else if (!admin.isStatus()) {
            System.out.println("Your account is not active!");
            return null;
        }
        return admin;
    }
}
