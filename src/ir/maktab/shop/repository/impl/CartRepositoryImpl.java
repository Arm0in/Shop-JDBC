package ir.maktab.shop.repository.impl;

import ir.maktab.shop.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.shop.domain.Customer;
import ir.maktab.shop.domain.Cart;
import ir.maktab.shop.repository.CartRepository;

import java.sql.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class CartRepositoryImpl extends BaseRepositoryImpl<Cart, Integer> implements CartRepository {


    public CartRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Cart update(Cart cart) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("update orders set customer_id = ? where id = ?");
            preparedStatement.setInt(1, cart.getCustomer().getId());
            preparedStatement.setInt(2, cart.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cart;
    }

    @Override
    public Cart save(Cart cart) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("insert into orders (orderdate, customer_id) values (?, ?)");
            preparedStatement.setInt(1, cart.getCustomer().getId());
            preparedStatement.setDate(2, Date.valueOf(LocalDate.now()));
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cart;
    }

    @Override
    public Cart findById(Integer id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("select * from orders where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Cart cart = new Cart();
                cart.setId(resultSet.getInt(1));
                cart.setCreateDate(resultSet.getDate(2).toLocalDate());
                Customer customer = new CustomerRepositoryImpl(connection).findById(resultSet.getInt(3));
                cart.setCustomer(customer);
                return cart;
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Cart> findAll() {
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("delete from orders where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Cart> findAllById(Collection<Integer> integers) {
        return null;
    }

    @Override
    public Boolean existsById(Integer integer) {
        return null;
    }

}
