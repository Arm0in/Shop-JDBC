package ir.maktab.shop.controller;

import ir.maktab.shop.base.ConnectionInitializer;
import ir.maktab.shop.domain.Cart;
import ir.maktab.shop.domain.CartItem;
import ir.maktab.shop.domain.Customer;
import ir.maktab.shop.domain.Product;
import ir.maktab.shop.repository.CartItemRepository;
import ir.maktab.shop.repository.impl.CartItemRepositoryImpl;
import ir.maktab.shop.service.CartItemService;
import ir.maktab.shop.service.impl.CartItemServiceImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class CartItemController {
    private static Scanner scanner = new Scanner(System.in);
    private static CartItemService service = new CartItemServiceImpl(new CartItemRepositoryImpl(ConnectionInitializer.connect()));

    public static List<CartItem> getCartItems(Cart cart) {
        return service.getCartItems(cart);
    }

    public static void addToCart(Customer currentCustomer) {
        ProductController.viewAllProducts();
        System.out.println("Enter Product id that you want to purchase: ");
        int productId = scanner.nextInt();
        scanner.nextLine();
        Product product = ProductController.getProductById(productId);
        System.out.println("Enter amount to purchase: ");
        int amount = scanner.nextInt();
        scanner.nextLine();
        if ((CartController.cartQuantity(currentCustomer) + amount) > 5) {
            System.out.println("Each Cart can only have 5 items!");
        } else if (amount > product.getStock()) {
            System.out.println("There is only " + product.getStock() + " of this item in stock!");
        } else if (product.getStock() == 0) {
            System.out.println("Out of stock!");
        } else {
            CartItem cartItem = new CartItem();
            cartItem.setQuantity(amount);
            cartItem.setProduct(product);
            cartItem.setCart(CartController.getCustomerCart(currentCustomer));
            service.save(cartItem);
            System.out.println("Product Added to Cart successfully.");
        }
    }


    public static void removeFromCart(Customer currentCustomer) {
        ProductController.viewAllProducts();
        if (!getCartItems(CartController.getCustomerCart(currentCustomer)).isEmpty()){
            System.out.println("Choose item id you want to remove");
            int itemId = scanner.nextInt();
            scanner.nextLine();
            service.deleteById(itemId);
        }
    }




}
