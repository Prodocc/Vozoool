package com.vozoool;

import com.vozoool.entity.User;

import java.sql.*;

public class App00 {
    public static final String URL = "jdbc:mysql://localhost:3306/vozoool";
    public static final String NAME = "root";
    public static final String PASSWORD = "123456";

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, NAME, PASSWORD);
        Statement statement = connection.createStatement();
//        statement.executeUpdate("insert into users (user_id, user_name, user_surname, user_email" +
//                ",user_password, user_type) values ('1', 'VlaDICK','Lyudoed','YaEmLyudei228@mail.ru','YaEmLyudei228','0');");
        ResultSet set = statement.executeQuery("select * from users;");
        while (set.next()) {
            String user_name = set.getString("user_name");
            String user_surname = set.getString("user_surname");
            String user_email = set.getString("user_email");
            String user_password = set.getString("user_password");
            int user_type = set.getInt("user_type");
            int user_id = set.getInt("user_id");
            User user = new User(user_name, user_surname, user_email, user_password, user_type);
            System.out.println(user);
        }
    }
}
