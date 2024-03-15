package com.vozoool.util;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.mysql.cj.jdbc.MysqlDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class DataSourceFactory {
    private static MysqlDataSource ds = null;

    public static DataSource getDataSourceInstance() {
        if (ds == null) {
            Properties prop = new Properties();
            try (FileInputStream in = new FileInputStream("src/main/resources/application.properties")) {
                prop.load(in);
                ds = new MysqlDataSource();
                ds.setURL(prop.getProperty("url"));
                ds.setUser(prop.getProperty("username"));
                ds.setPassword(prop.getProperty("password"));
                System.out.println(ds.getURL());
                System.out.println(ds.getUser());
                System.out.println(ds.getPassword());
                ds.getConnection();
            } catch (IOException | SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return ds;
    }
}
