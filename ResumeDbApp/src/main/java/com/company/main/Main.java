package com.company.main;


import java.sql.Connection;
import java.sql.DriverManager;


public class Main {
        public static void connect() throws Exception {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Resume";
            String username = "root";
            String password = "yusif3200";
            Connection c = DriverManager.getConnection(url, username, password);
            System.out.println(c.getClass().getName());
        }

    public static void main(String[] args) throws Exception {
        connect();
    }

    }
