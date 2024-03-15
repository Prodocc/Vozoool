package com.vozoool.examples_from_book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.util.Enumeration;

@WebServlet(name = "TestServlet00",
        value = "/test00",
        initParams = {
                @WebInitParam(name = "adminEmail", value = "admin_email@mail.ru"),
                @WebInitParam(name = "devEmail", value = "dev_email@mail.ru")
        }
)

//TODO: bind db url,login,pass with servletContext or with app.props
public class TestServlet00 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("test servlet init parameters");

        Enumeration<String> initParameterNames = getServletConfig().getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            out.println("param name = " + initParameterNames.nextElement());
        }
        out.println("init admin email is: " + getServletConfig().getInitParameter("adminEmail"));
        out.println("init dev email is: " + getServletConfig().getInitParameter("devEmail"));

        out.println("test context init parameters");
        out.println(getServletContext().getInitParameter("adminGmail"));
        out.println(getServletContext().getInitParameter("devGmail"));










    }
}
