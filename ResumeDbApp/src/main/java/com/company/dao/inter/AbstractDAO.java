package com.company.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class AbstractDAO {
    public Connection connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/Resume";
        String username = "root";
        String password = "yusif3200";
        Connection con = DriverManager.getConnection(url, username, password);
        return con;
    }
}
