package ir.maktab.shop.controller;

import ir.maktab.shop.base.ConnectionInitializer;
import ir.maktab.shop.domain.Cart;
import ir.maktab.shop.domain.CartItem;
import ir.maktab.shop.domain.Customer;
import ir.maktab.shop.domain.Product;
import ir.maktab.shop.repository.CartRepository;
import ir.maktab.shop.repository.impl.CartItemRepositoryImpl;
import ir.maktab.shop.repository.impl.CartRepositoryImpl;
import ir.maktab.shop.repository.impl.ProductRepositoryImpl;
import ir.maktab.shop.service.CartService;
import ir.maktab.shop.service.impl.CartItemServiceImpl;
import ir.maktab.shop.service.impl.CartServiceImpl;
import ir.maktab.shop.util.Helper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class CartController {
    private static Scanner scanner = new Scanner(System.in);
    private static CartService service = new CartServiceImpl(new CartRepositoryImpl(ConnectionInitializer.connect()));

    public static void createCart(Customer currentCustomer) {
        service.createCart(currentCustomer);
    }

    public static Cart getCustomerCart(Customer currentCustomer) {
        return service.getCustomerCart(currentCustomer);
    }

    public static int cartQuantity(Customer currentCustomer) {
        List<CartItem> cartItems = CartItemController.getCartItems(getCustomerCart(currentCustomer));
        int cartQuantity = 0;
        for (int i = 0; i < cartItems.size(); i++) {
            cartQuantity += cartItems.get(i).getQuantity();
        }
        return cartQuantity;
    }

    public static BigDecimal cartTotalCost(Customer currentCustomer) {
        List<CartItem> cartItems = CartItemController.getCartItems(getCustomerCart(currentCustomer));
        BigDecimal totalCost = new BigDecimal(0);
        for (int i = 0; i < cartItems.size(); i++) {
            totalCost = totalCost.add(cartItems.get(i).getProduct().getPrice().multiply(BigDecimal.valueOf(cartItems.get(i).getQuantity())));
        }
        return totalCost;
    }

    public static void viewCart(Customer currentCustomer) {
        List<CartItem> cartItems = CartItemController.getCartItems(getCustomerCart(currentCustomer));
        if (cartQuantity(currentCustomer) == 0)
            System.out.println("Your Cart is empty.");
        for (int i = 0; i < cartItems.size(); i++) {
            System.out.printf("id: %d. %s \n", i + 1, cartItems.get(i));
        }
    }

    public static void checkout(Customer currentCustomer) {
        List<CartItem> cartItems = CartItemController.getCartItems(getCustomerCart(currentCustomer));
        if (Helper.check("are sure you want to checkout?")) {
            if (cartTotalCost(currentCustomer).compareTo(currentCustomer.getBalance()) == 1) {
                System.out.println("Your account balance is low, charge first");
            } else {
                for (int i = 0; i < cartItems.size(); i++) {
                    cartItems.get(i).getProduct().setStock(cartItems.get(i).getProduct().getStock() - cartItems.get(i).getQuantity());
                    ProductController.updateProduct(cartItems.get(i).getProduct());
                }
                currentCustomer.setBalance(currentCustomer.getBalance().subtract(cartTotalCost(currentCustomer)));
                CustomerController.updateCustomer(currentCustomer);
                System.out.println("Purchase successfully.");
            }
        }
    }


}
