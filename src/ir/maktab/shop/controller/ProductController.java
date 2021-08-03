package ir.maktab.shop.controller;

import ir.maktab.shop.base.ConnectionInitializer;
import ir.maktab.shop.domain.Product;
import ir.maktab.shop.repository.ProductRepository;
import ir.maktab.shop.repository.impl.ProductRepositoryImpl;
import ir.maktab.shop.service.ProductService;
import ir.maktab.shop.service.impl.ProductServiceImpl;

import java.util.List;
import java.util.Scanner;

public class ProductController {
    private static Scanner scanner = new Scanner(System.in);
    private static ProductRepository repository = new ProductRepositoryImpl(ConnectionInitializer.connect());
    private static ProductService service = new ProductServiceImpl(repository);

    public static void viewAllProducts() {
        List<Product> products = service.findAll();
        for (Product product :
                products) {
            System.out.println(product);
        }
    }

}
