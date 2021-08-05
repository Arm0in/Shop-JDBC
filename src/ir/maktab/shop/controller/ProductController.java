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
    private static ProductService service = new ProductServiceImpl(new ProductRepositoryImpl(ConnectionInitializer.connect()));

    public static void viewAllProducts() {
        List<Product> products = service.findAll();
        for (Product product :
                products) {
            System.out.println(product);
        }
    }

    public static Product getProductById(Integer id) {
        return service.findById(id);
    }

    public static void updateProduct(Product product) {
        service.update(product);
    }



}
