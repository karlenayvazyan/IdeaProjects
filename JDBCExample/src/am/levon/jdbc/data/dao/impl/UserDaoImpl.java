package am.levon.jdbc.data.dao.impl;

import am.levon.jdbc.data.dao.IUserDao;
import am.levon.jdbc.data.model.User;
import am.levon.jdbc.data.util.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by karlen on 8/1/15.
 */
public class UserDaoImpl implements IUserDao {

    private Connection connection;

    public UserDaoImpl() {
        connection = ConnectionProvider.getInstance().getConnection();
    }

    @Override
    public void addUser(User user) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO users (name, surname) VALUES (?, ?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {}
            }
        }
    }
}
