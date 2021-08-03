package ir.maktab.shop.repository.impl;

import ir.maktab.shop.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.shop.controller.CustomerController;
import ir.maktab.shop.domain.Customer;
import ir.maktab.shop.domain.Order;
import ir.maktab.shop.repository.OrderRepository;

import java.sql.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class OrderRepositoryImpl extends BaseRepositoryImpl<Order, Integer> implements OrderRepository {


    public OrderRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Order update(Order order) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("update orders set customer_id = ? where id = ?");
            preparedStatement.setInt(1, order.getCustomer().getId());
            preparedStatement.setInt(2, order.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return order;
    }

    @Override
    public Order save(Order order) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("insert into orders (orderdate, customer_id) values (?, ?)");
            preparedStatement.setInt(1, order.getCustomer().getId());
            preparedStatement.setDate(2, Date.valueOf(LocalDate.now()));
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return order;
    }

    @Override
    public Order findById(Integer id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("select * from orders where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt(1));
                order.setOrderDate(resultSet.getDate(2).toLocalDate());
                Customer customer = new CustomerRepositoryImpl(connection).findById(resultSet.getInt(3));
                order.setCustomer(customer);
                return order;
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public List<Order> findAllById(Collection<Integer> integers) {
        return null;
    }

    @Override
    public Boolean existsById(Integer integer) {
        return null;
    }

}
