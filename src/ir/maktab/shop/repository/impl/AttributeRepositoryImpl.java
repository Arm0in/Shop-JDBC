package ir.maktab.shop.repository.impl;

import ir.maktab.shop.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.shop.domain.Attribute;
import ir.maktab.shop.repository.AttributeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AttributeRepositoryImpl extends BaseRepositoryImpl<Attribute, Integer> implements AttributeRepository {

    public AttributeRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Attribute update(Attribute attribute) {
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement
//                    ("update categories set title = ?, description = ? where id = ?");
//            preparedStatement.setString(1, attribute.getTitle());
//            preparedStatement.setString(2, attribute.getDescription());
//            preparedStatement.setInt(3, attribute.getId());
//            preparedStatement.executeUpdate();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        return attribute;
    }

    @Override
    public Attribute save(Attribute attribute) {
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement
//                    ("insert into categories (title, description) values(?, ?)");
//            preparedStatement.setString(1, attribute.getTitle());
//            preparedStatement.setString(2, attribute.getDescription());
//            preparedStatement.executeUpdate();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        return attribute;
    }

    @Override
    public Attribute findById(Integer id) {
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement
//                    ("select * from categories where id = ?");
//            preparedStatement.setInt(1, id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                Attribute attribute = new Attribute();
//                attribute.setId(resultSet.getInt(1));
//                attribute.setTitle(resultSet.getString(2));
//                attribute.setDescription(resultSet.getString(3));
//                return attribute;
//            }
//            return null;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//            return null;
//        }
        return null;
    }

    @Override
    public List<Attribute> findAll() {
//        List<Attribute> categories = new ArrayList<>();
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("select * from categories");
//            while (resultSet.next()) {
//                Attribute attribute = new Attribute();
//                attribute.setId(resultSet.getInt(1));
//                attribute.setTitle(resultSet.getString(2));
//                attribute.setDescription(resultSet.getString(3));
//                categories.add(attribute);
//            }
//            return categories;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//            return null;
//        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement
//                    ("delete from categories where id = ?");
//            preparedStatement.setInt(1, id);
//            preparedStatement.executeUpdate();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
    }

    @Override
    public List<Attribute> findAllById(Collection<Integer> integers) {
        return null;
    }

    @Override
    public Boolean existsById(Integer integer) {
        return null;
    }


    @Override
    public List<Attribute> findProductAttributesById(Integer productId) {
        List<Attribute> attributes = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select attributes.* from attributes join products_attributes on attributes.id = products_attributes.attribute_id join products on products_attributes.product_id = products.id where products.id = ?"
            );
            preparedStatement.setInt(1, productId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Attribute attribute = new Attribute();
                attribute.setId(resultSet.getInt(1));
                attribute.setAttributeName(resultSet.getString(2));
                attribute.setAttributeValue(resultSet.getString(3));
                attributes.add(attribute);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return attributes;
    }
}
