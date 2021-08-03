package ir.maktab.shop.repository.impl;

import ir.maktab.shop.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.shop.domain.Category;
import ir.maktab.shop.domain.Customer;
import ir.maktab.shop.repository.CategoryRepository;
import ir.maktab.shop.repository.CustomerRepository;

import java.sql.*;
import java.util.Collection;
import java.util.List;

public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer, Integer> implements CustomerRepository {


    public CustomerRepositoryImpl(Connection connection) {
        super(connection);
    }


    @Override
    public Customer update(Customer customer) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("update customers set username = ?, password = ?, nationalcode = ?, birthday = ?, status = ?, balance = ? where id = ?");
            preparedStatement.setString(1, customer.getUserName());
            preparedStatement.setString(2, customer.getPassword());
            preparedStatement.setString(3, customer.getNationalCode());
            preparedStatement.setDate(4, Date.valueOf(customer.getBirthday()));
            preparedStatement.setBoolean(5, customer.isStatus());
            preparedStatement.setBigDecimal(6, customer.getBalance());
            preparedStatement.setInt(7, customer.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    @Override
    public Customer save(Customer customer) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("insert into customers (username, password, nationalcode, birthday, status, balance) values(?, ?, ?, ?, 0, 0)");
            preparedStatement.setString(1, customer.getUserName());
            preparedStatement.setString(2, customer.getPassword());
            preparedStatement.setString(3, customer.getNationalCode());
            preparedStatement.setDate(4, Date.valueOf(customer.getBirthday()));
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    @Override
    public Customer findById(Integer id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("select * from customers where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt(1));
                customer.setUserName(resultSet.getString(2));
                customer.setNationalCode(resultSet.getString(4));
                customer.setBirthday(resultSet.getDate(5).toLocalDate());
                customer.setStatus(resultSet.getBoolean(6));
                customer.setBalance(resultSet.getBigDecimal(7));
                return customer;
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public List<Customer> findAllById(Collection<Integer> integers) {
        return null;
    }

    @Override
    public Boolean existsById(Integer integer) {
        return null;
    }
}
