package com.vozoool.service;

import com.vozoool.entity.User;
import com.vozoool.repository.UserDao;

import java.sql.*;
import java.util.List;

import static com.vozoool.App00.*;

public class UserDaoImpl implements UserDao {
    @Override
    public User findByEmail(String email) {
        Connection connection;
        User user = null;
        try {
            connection = DriverManager.getConnection(URL, NAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users where user_email = '" + email + "';");
            while (rs.next()) {
                String user_name = rs.getString("user_name");
                String user_surname = rs.getString("user_surname");
                String user_email = rs.getString("user_email");
                String user_password = rs.getString("user_password");
                int user_type = rs.getInt("user_type");
                int user_id = rs.getInt("user_id");
                user = new User(user_name, user_surname, user_email, user_password, user_type);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        statement.executeUpdate("insert into users (user_id, user_name, user_surname, user_email" +
//                ",user_password, user_type) values ('1', 'VlaDICK','Lyudoed','YaEmLyudei228@mail.ru','YaEmLyudei228','0');");
        return user;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void addUser(User user) {

    }
}
