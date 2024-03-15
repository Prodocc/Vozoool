package com.vozoool;

import com.vozoool.util.DataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App02 {
    public static void main(String[] args) {
        DataSource ds = DataSourceFactory.getDataSourceInstance();
        try(Connection conn = ds.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM city WHERE id = 1;");
            while (rs.next()){
                System.out.println(rs.getInt("Id"));
                System.out.println(rs.getString("Name"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
