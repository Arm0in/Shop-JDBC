package ir.maktab.shop.controller;

import ir.maktab.shop.base.ConnectionInitializer;
import ir.maktab.shop.domain.Customer;
import ir.maktab.shop.repository.CustomerRepository;
import ir.maktab.shop.repository.impl.CustomerRepositoryImpl;
import ir.maktab.shop.service.CustomerService;
import ir.maktab.shop.service.impl.CustomerServiceImpl;
import ir.maktab.shop.util.Helper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class CustomerController {
    private static Scanner scanner = new Scanner(System.in);
    private static CustomerRepository repository = new CustomerRepositoryImpl(ConnectionInitializer.connect());
    private static CustomerService service = new CustomerServiceImpl(repository);

    public static Customer login() {
        System.out.println("Please enter your Username: ");
        String username = scanner.nextLine();
        System.out.println("Please enter your Password: ");
        String password = scanner.nextLine();
        Customer customer = service.login(username, password);
        if (customer == null)
            System.out.println("Incorrect Login credentials!");
        if (!customer.isStatus())
            System.out.println("Your account is not active!");
        return customer;
    }

    public static void register() {
        Customer customer = new Customer();
        System.out.println("Please enter username: ");
        customer.setUserName(scanner.nextLine());
        System.out.println("Please enter nationalcode: ");
        String nationalCode = scanner.nextLine();
        customer.setNationalCode(nationalCode);
        customer.setPassword(nationalCode);
        System.out.println("Please enter birthday yyyy-mm-dd: ");
        String str = scanner.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        customer.setBirthday(LocalDate.parse(str, dtf));
        service.save(customer);
        System.out.println("Registered successfully.");
    }

    public static void chargeAccount(Customer currentCustomer) {
        Customer customer = service.findById(currentCustomer.getId());
        System.out.println("Enter amount you want to charge: ");
        String addAmount = scanner.nextLine();
        customer.setBalance(customer.getBalance().add(new BigDecimal(addAmount)));
        service.update(customer);
        System.out.println("Your account charged successfully");
    }

    public static void changeUserStatus() {
        List<Customer> customers = service.findAll();
        for (int i = 0; i < customers.size(); i++) {
            System.out.println(customers.get(i));
        }
        System.out.println("Please enter User ID");
        int id = scanner.nextInt();
        scanner.nextLine();
        Customer customer = service.findById(id);
        if (customer.isStatus()) {
            boolean flag = Helper.check("Do you want to block this user?");
            if (flag)
                customer.setStatus(false);
            else
                System.out.println("Nothing has changed.");
        } else {
            boolean flag = Helper.check("Do you want to active this user?");
            if (flag)
                customer.setStatus(true);
            else
                System.out.println("Nothing has changed.");
        }
        service.update(customer);
    }

    public static void updateCustomer(Customer customer) {
        service.update(customer);
    }

}
