package ir.maktab.shop.service.impl;

import ir.maktab.shop.base.service.impl.BaseServiceImpl;
import ir.maktab.shop.domain.Order;
import ir.maktab.shop.repository.OrderRepository;
import ir.maktab.shop.service.OrderService;

public class OrderServiceImpl extends BaseServiceImpl<Order, Integer, OrderRepository> implements OrderService {
    public OrderServiceImpl(OrderRepository repository) {
        super(repository);
    }
}
