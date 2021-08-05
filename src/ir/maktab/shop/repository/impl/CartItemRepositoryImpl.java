package ir.maktab.shop.repository.impl;

import ir.maktab.shop.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.shop.domain.CartItem;
import ir.maktab.shop.domain.Customer;
import ir.maktab.shop.domain.Product;
import ir.maktab.shop.repository.CartItemRepository;

import java.sql.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class CartItemRepositoryImpl extends BaseRepositoryImpl<CartItem, Integer> implements CartItemRepository {


    public CartItemRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public CartItem update(CartItem cartItem) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("update cart_items set quantity = ?, product_id = ?, order_id = ? where id = ?");
            preparedStatement.setInt(1, cartItem.getQuantity());
            preparedStatement.setInt(2, cartItem.getProduct().getId());
            preparedStatement.setInt(3, cartItem.getOrderId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cartItem;
    }

    @Override
    public CartItem save(CartItem cartItem) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("insert into cartItems (quantity, product_id, order_id) values (?, ?, ?)");
            preparedStatement.setInt(1, cartItem.getQuantity());
            preparedStatement.setInt(2, cartItem.getProduct().getId());
            preparedStatement.setInt(3, cartItem.getOrderId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cartItem;
    }

    @Override
    public CartItem findById(Integer id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("select * from cartItems where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                CartItem cartItem = new CartItem();
                cartItem.setId(resultSet.getInt(1));
                cartItem.setQuantity(resultSet.getInt(2));
                Product product = new ProductRepositoryImpl(connection).findById(resultSet.getInt(3));
                cartItem.setProduct(product);
                cartItem.setOrderId(resultSet.getInt(4));
                return cartItem;
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<CartItem> findAll() {
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("delete from cart_items where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<CartItem> findAllById(Collection<Integer> integers) {
        return null;
    }

    @Override
    public Boolean existsById(Integer integer) {
        return null;
    }

}
