package ir.maktab.shop.controller;

import ir.maktab.shop.base.ConnectionInitializer;
import ir.maktab.shop.repository.CartItemRepository;
import ir.maktab.shop.repository.impl.CartItemRepositoryImpl;
import ir.maktab.shop.service.CartItemService;
import ir.maktab.shop.service.impl.CartItemServiceImpl;

import java.util.Scanner;

public class CartItemController {
    private static Scanner scanner = new Scanner(System.in);
    private static CartItemRepository repository = new CartItemRepositoryImpl(ConnectionInitializer.connect());
    private static CartItemService service = new CartItemServiceImpl(repository);


}
