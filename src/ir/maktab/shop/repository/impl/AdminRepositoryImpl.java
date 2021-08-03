package ir.maktab.shop.repository.impl;

import ir.maktab.shop.base.repository.BaseRepository;
import ir.maktab.shop.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.shop.domain.Admin;
import ir.maktab.shop.repository.AdminRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AdminRepositoryImpl extends BaseRepositoryImpl<Admin, Integer> implements AdminRepository {

    public AdminRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Admin update(Admin admin) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("update admins set username = ?, password = ? where id = ?");
            preparedStatement.setString(1, admin.getUserName());
            preparedStatement.setString(2, admin.getPassword());
            preparedStatement.setInt(3, admin.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return admin;
    }

    @Override
    public Admin save(Admin admin) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("insert into admins (username, password) values(?, ?)");
            preparedStatement.setString(1, admin.getUserName());
            preparedStatement.setString(2, admin.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return admin;
    }

    @Override
    public Admin findById(Integer id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("select * from admins where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Admin admin = new Admin();
                admin.setId(resultSet.getInt(1));
                admin.setUserName(resultSet.getString(2));
                return admin;
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Admin> findAll() {
        List<Admin> admins = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from admins");
            while (resultSet.next()) {
                Admin admin = new Admin();
                admin.setId(resultSet.getInt(1));
                admin.setUserName(resultSet.getString(2));
                admins.add(admin);
            }
            return admins;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("delete from users where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Admin> findAllById(Collection<Integer> integers) {
        return null;
    }

    @Override
    public Boolean existsById(Integer integer) {
        return null;
    }

    @Override
    public Admin findByUserName(String username, String password) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("select * from admins where username = ? and password = ?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Admin admin = new Admin();
                admin.setId(resultSet.getInt(1));
                admin.setUserName(resultSet.getString(2));
                return admin;
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
