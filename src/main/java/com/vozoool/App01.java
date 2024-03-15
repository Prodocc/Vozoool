package com.vozoool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class App01 {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws SQLException {
        logger.info("Logger test - info");
        logger.debug("Logger test - debug");
        logger.warn("Logger test - warn");
        logger.error("Logger test - error");
        logger.fatal("Logger test - fatal");

        Properties properties = new Properties();
        try (FileInputStream in = new FileInputStream("src/main/resources/application.properties")) {
            properties.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(properties.get("url"));
        Connection conn = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
//        Connection conn = DriverManager.getConnection(App00.URL, App00.NAME, App00.PASSWORD);
    }
}
