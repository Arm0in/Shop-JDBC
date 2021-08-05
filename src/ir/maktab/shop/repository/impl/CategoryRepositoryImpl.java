package ir.maktab.shop.repository.impl;

import ir.maktab.shop.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.shop.domain.Category;
import ir.maktab.shop.repository.CategoryRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CategoryRepositoryImpl extends BaseRepositoryImpl<Category, Integer> implements CategoryRepository {

    public CategoryRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Category update(Category category) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("update categories set title = ?, description = ? where id = ?");
            preparedStatement.setString(1, category.getTitle());
            preparedStatement.setString(2, category.getDescription());
            preparedStatement.setInt(3, category.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return category;
    }

    @Override
    public Category save(Category category) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("insert into categories (title, description) values(?, ?)");
            preparedStatement.setString(1, category.getTitle());
            preparedStatement.setString(2, category.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return category;
    }

    @Override
    public Category findById(Integer id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("select * from categories where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getInt(1));
                category.setTitle(resultSet.getString(2));
                category.setDescription(resultSet.getString(3));
                return category;
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from categories");
            while (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getInt(1));
                category.setTitle(resultSet.getString(2));
                category.setDescription(resultSet.getString(3));
                categories.add(category);
            }
            return categories;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("delete from categories where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Category> findAllById(Collection<Integer> integers) {
        return null;
    }

    @Override
    public Boolean existsById(Integer integer) {
        return null;
    }
}
